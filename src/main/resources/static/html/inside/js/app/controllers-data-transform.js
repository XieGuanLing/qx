/**
 * Created by lihaodi on 2016/7/20.
 */
angular.module('controllers-data-transform', [])
    .controller('feedback-ctrl', ['$scope', '$stateParams', 'feedbackService',
        function ($scope, $stateParams, feedbackService) {
            $scope.q = {start:0, max:10,key:'0'};
            $scope.currPage = 0;
            $scope.totalPage = 0;
            var queryFeedbackSuccess = function (res) {
                $scope.list = res.rows;
                $scope.total = res.total;
                $scope.totalPage = Math.ceil($scope.total/$scope.q.max);
            };
            $scope.search = function () {
                feedbackService.queryFeedback($scope.q, queryFeedbackSuccess);
            };
            $scope.search();
            initPage($scope, $scope.search);

            $scope.updateState = function (feedbackId) {
                var ok = function () {
                    var updateStateSuccess = function (res) {
                        dialogUtils.showTip('操作成功');
                    };
                    feedbackService.updateState(feedbackId, updateStateSuccess);
                };
                dialogUtils.showTipWithCB('确定更新吗？', ok);
            };
        }])
    .controller('data-transform-list-ctrl', ['$scope', 'dataTransformService','Upload','$state',
        function ($scope, dataTransformService, Upload,$state) {
            $scope.upload = function (file) {
                if(!file){
                    return;
                }

                if(!$scope.m.companyId.length){
                    dialogUtils.showTip('车店编号');
                    return;
                }
                if(!checkPhone($scope.m.phone)){
                    dialogUtils.showTip('请检查手机号码格式');
                    return;
                }
                if(!$scope.m.remark.length){
                    dialogUtils.showTip('请输入备注');
                    return;
                }

                dialogUtils.showTip('开始执行数据导入');

                Upload.upload({
                    url: '/internal/asset/up0',
                    data: {file: file}
                }).then(function (resp) {
                    //console.log(JSON.stringify(resp.data));
                    $.each(resp.data.resultObject, function (index, file) {
                        dataTransformService.parseExcel(file, $scope.m, $scope.search);
                    });

                }, function (resp) {
                    console.log('Error status: ' + resp.status);
                }, function (evt) {
                    //进度
                    //console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
                });
            };
            $scope.assertDetail = function (batchId) {
                $state.go('assert-detail', {batchId: batchId});
                save2Local('currPage', $scope.currPage);
            };
            $scope.search = function () {
                var success = function (res) {
                    $scope.records = res.records;
                    $scope.totalPage = Math.ceil(res.total / $scope.q.pageSize);
                };
                $scope.q.currPage = $scope.currPage;
                dataTransformService.uploadRecords($scope.q, success);
            };

            var init = function () {
                $scope.q = {currPage: 0, pageSize: 10};
                $scope.currPage = getFromLocal('currPage') ? getFromLocal('currPage') : 0;
                $scope.phone = '';
                $scope.remark = '';
                $scope.search();
                initPage($scope, $scope.search);
            };

            init();

    }])
    .controller('data-export-ctrl', ['$scope', 'dataExportService','Upload', 'momentService',
        function($scope, dataExportService, Upload, momentService){
            $scope.timeChange = function (modelName, newDate) {
                if (modelName == 'endTime') {
                    $scope.q[modelName] = newDate.format("YYYY-MM-DD") + ' 23:59:59';
                } else {
                    $scope.q[modelName] = newDate.format("YYYY-MM-DD") + ' 00:00:00';
                }
                $scope.timeCheck();
            };

            $scope.timeCheck = function () {
                if ($scope.q.startTime && $scope.q.endTime &&
                    $scope.q.startTime > $scope.q.endTime) {
                    dialogUtils.showTip('请输入正确查询时间段');
                }
            };

            $scope.toExcel =function(){
                if(!$scope.q.companyId){
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }
                $scope.q.types = [];
                $.each($scope.types, function (index, item) {
                     if(item.isCheck){
                         $scope.q.types.push(index);
                     }
                });
                if(!$scope.q.types.length){
                    dialogUtils.showTip('请选择导出数据');
                    return;
                }
                var p = 'types='+$scope.q.types.join(',');
                if($scope.q.startTime){
                    p += '&startTime=' + $scope.q.startTime
                }
                if($scope.q.endTime){
                    p += '&endTime=' + $scope.q.endTime
                }
                window.open('/internal/export/'+$scope.q.companyId+'/toExcel?'+p);
            };

            $scope.getExportTypes = function () {
                dataExportService.getExportTypes(function (res) {
                    $scope.types = res;
                });
            };

            var init = function () {
                $scope.q = {types:[]};
                $scope.getExportTypes();
            };
            init();
        }
    ])
    .controller('assert-detail-ctrl', ['$scope', '$stateParams', 'dataTransformService',
        function ($scope, $stateParams, dataTransformService) {
            $scope.batchId = $stateParams.batchId;
            //工作簿没有分页功能
            dataTransformService.sheets(function (res) {
                $scope.sheets = res;
            });

            dataTransformService.batchSummary($scope.batchId, function (res) {
                $scope.res = res;
            });
            dataTransformService.getUploadRecord($scope.batchId, function (res) {
                //正在执行导入
                if (res.processing){
                    $scope.isImport2Mysql = '正在执行数据导入';
                }
                if (!res.processing && res.dropedTmpCollections){
                    $scope.isImport2Mysql = '数据导入完成';
                }
                if(!res.processing && !res.dropedTmpCollections){
                    $scope.isImport2Mysql = '数据导入失败，请重新导入';
                }
            });
            $scope.import2Mysql = function () {
                dataTransformService.import2Mysql($scope.batchId);
            };
        }])
    .controller('sheet-detail-ctrl', ['$scope', '$timeout', '$stateParams', 'dataTransformService','Excel',
        function ($scope, $timeout,  $stateParams, dataTransformService, Excel) {

            $scope.export2Excel = function () {
                $scope.exportHref = Excel.tableToExcel('#export2Excel',$scope.model);
                $timeout(function(){location.href=$scope.exportHref;},100); // trigger download
            };

            $scope.q = {currPage: 0, start: 0, max: '1000', state:''};
            $scope.currPage = 0;

            $scope.model = dataTransformService.getModel($stateParams.model); //获取单元格属性
            $scope.attrs = dataTransformService.getAttrs($scope.model); //获取单元格属性
            $scope.sheetName = $stateParams.sheetName;
            $scope.listData = [];
            $scope.search = function () {
                var showDetailSuccess = function (res) {
                    $scope.listData = res.records;
                    $scope.totalPage = Math.ceil(res.total / $scope.q.max);
                };
                $scope.q.currPage = $scope.currPage;
                dataTransformService.sheetDetail($stateParams.batchId, $stateParams.model, $scope.q, showDetailSuccess);
            };
            $scope.search();
            initPage($scope, $scope.search);

            var dataTransformDialogId = '#record-detail';
            $scope.showDialog = function (row) {
                $scope.m = {};
                $.extend($scope.m, row);

                    var updateSuccess = function (res) {
                        $(dataTransformDialogId).dialog('destroy');
                        $scope.search();
                    };
                    var ok = function () {
                        dataTransformService.updateModel( $scope.m, $stateParams.model, updateSuccess);
                    };
                    var remove = function () {
                        dataTransformService.removeModel($scope.m, $stateParams.model, updateSuccess);
                    };
                    showDialogWith3Button(dataTransformDialogId, 800, Math.ceil($scope.attrs.length / 2) * 70,
                        ok, null, remove);
            };
            $scope.repeatTimes = function () {
                return new Array(Math.ceil($scope.attrs.length / 2));
            };
            $scope.import2Mysql = function () {
                var reImportSuccess = function (data) {
                    $scope.search();
                    initPage($scope, $scope.search);
                };
                dataTransformService.import2Mysql($stateParams.batchId, reImportSuccess);
            };
        }])
    .controller('wechat-menu-ctrl', ['$scope', '$interval', 'wechatService', 'companyService', 'internalWeCatService',
        function ($scope, $interval, wechatService, companyService, internalWeCatService) {
            var init = function () {
                $scope.companyId = '';
                $scope.appId = '';
                $scope.menu = '';
                $scope.m = {};
            };
            init();

            $scope.sendSmsPhoneCodeToCreateOwner = function () {
                $scope.m.companyId = $scope.companyId;

                if(!$scope.m.companyId) {
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }

                var phone = $scope.m.telephone || '';
                if (!checkPhone(phone)) {
                    dialogUtils.showTip('手机号码格式不对，请重新输入');
                    return;
                }

                if ($scope.isCount) {
                    return;
                }
                var success = function () {
                    dialogUtils.showTip('验证码已经发送，请查收');
                    $scope.count = 80;
                    $scope.isCount = true;
                    $scope.fight();
                };
                internalWeCatService.sendSmsPhoneCodeToCreateOwner($scope.m, success);
            };

            $scope.bind = function () {
                wechatService.bindOpenId($scope.m, function () {
                    $state.go('center' , $scope.m) ;
                });
            };

            $scope.isCount = false;
            $scope.count = '发送验证码';
            var stop;
            $scope.fight = function () {
                // Don't start a new fight if we are already fighting
                if (angular.isDefined(stop)) return;
                stop = $interval(function () {
                    if ($scope.count > 0) {
                        $scope.count--;
                    } else {
                        $scope.stopFight();
                    }
                }, 1000);
            };

            $scope.stopFight = function () {
                if (angular.isDefined(stop)) {
                    $interval.cancel(stop);
                    stop = undefined;
                    $scope.count = '发送验证码';
                    $scope.isCount = false;
                }
            };

            $scope.getMenu = function () {
                if(!$scope.companyId){
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }
                var getMenuSuccess = function (res) {
                    $scope.menu = JSON.stringify(JSON.parse(res).menu);
                };
                wechatService.getMenu($scope.companyId, getMenuSuccess);

                wechatService.getDefaultMenu($scope.companyId , function(res){
                    $scope.defaultMenu = res ;
                }) ;
            };

            $scope.createMenu = function () {
                var companyId = $scope.companyId;
                if(!companyId){
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }
                var telephone = $scope.m.telephone;
                if(!telephone) {
                    dialogUtils.showTip('请输入车店注册手机号');
                    return;
                }
                if(!$scope.menu){
                    dialogUtils.showTip('请先检查菜单');
                    return;
                }
                var m = {telephone:telephone, companyId:companyId, menu:$scope.menu};
                $scope.m = m;
                var createMenuSuccess = function (res) {
                    dialogUtils.showTip(res);
                };
                internalWeCatService.isCompanyRegisterPhone($scope.m, function (res) {
                    wechatService.createMenu(m, createMenuSuccess );
                })

            };

            $scope.refreshCompanyChoices = function (key) {
                var queryByNameSuccess = function (res) {
                    $scope.companies = res.rows;
                };
                companyService.queries(key, queryByNameSuccess);
            };
        }
    ])
    .controller('feature-enroll-ctrl', ['$scope', '$interval', 'wechatService', 'companyService', 'validateSmsCode', 'momentService', 'featureEnrollService', 'internalWeCatService',
        function($scope, $interval, wechatService, companyService, validateSmsCode, momentService, featureEnrollService, internalWeCatService){
            var init = function () {
                $scope.insurance={};
                $scope.m={features:[]};
                $scope.features = [
                    {feature: 'CAR_INSURANCE', name: '车险业务', isCheck: false},
                    {feature: 'PERFORMANCE', name: '绩效管理', isCheck: false},
                    {feature: 'REMINDING', name: '智能提醒', isCheck: false},
                    {feature: 'WX_PERSONAL_CENTER', name: '微信端个人中心', isCheck: false},
                    {feature: 'VIN_SCAN', name: '扫描车架号', isCheck: false},
                    {feature: 'CAR_NUMBER_SCAN', name: '扫描车牌', isCheck: false},
                    {feature: 'CAR_INFORMATION', name: '查询车辆配置详情', isCheck: false},
                    {feature: 'INVENTORY', name: '库存管理', isCheck: false},
                    {feature: 'DISPATCH_BILL', name: '施工单', isCheck: false},
                    {feature: 'RESCUE', name: '道路救援', isCheck: false},
                    {feature: 'BOOKING', name: '预约管理', isCheck: false},
                    {feature: 'WX_PUSH_MESSAGE', name: '微信推送', isCheck: false},
                    {feature: 'WX_ACTIVITY', name: '微信活动', isCheck: false},
                    {feature: 'WX_MENU', name: '微信菜单管理', isCheck: false},
                    {feature: 'WX_COMPANY', name: '微门店', isCheck: false},
                    {feature: 'WX_NAVIGATION', name: '一键导航', isCheck: false},
                    {feature: 'WX_SHARE_ACTIVITY', name: '分享积客', isCheck: false},
                    {feature: 'WX_COUPON', name: '微信卡券', isCheck: false},
                    {feature: 'CHAIN_COMPANY', name: '连锁模块', isCheck: false},
                    {feature: 'WX_MATERIAL', name: '微信素材', isCheck: false},
                    {feature: 'WX_SUBSCRIBE_REPLY', name: '关注回复', isCheck: false}
                ];
                $scope.versionInfo = {};
            };
            init();



            $scope.bind = function () {
                wechatService.bindOpenId($scope.m, function () {
                    $state.go('center' , $scope.m) ;
                });
            };


            $scope.timeChange = function (modelName, newDate) {
                if(!newDate){
                    $scope.m[modelName] = null ;
                    return ;
                }
                $scope.m[modelName] = newDate.format(momentService.simpleUtilDatePattern) + ' 00:00:00';
            };
            $scope.search = function () {
                if(!$scope.m.companyId){
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }
                featureEnrollService.queryAllFeatureUsingState($scope.m.companyId, function (res) {
                    $scope.list = res.featureList;
                    $scope.versionInfo = res.versionInfo ;
                });
            };
            //购买功能
            $scope.buyFeature = function(){

                if(!validInput()){
                    return ;
                }

                $scope.m.features=[$scope.m.feature];

                internalWeCatService.isCompanyRegisterPhone($scope.m, function (res) {
                    featureEnrollService.buyFeatures($scope.m,function(res){
                        $scope.boughtFeature() ;
                    });
                });

            };

            //功能延期
            $scope.boughtFeature = function(){

                if(!validInput()){
                    return ;
                }

                internalWeCatService.isCompanyRegisterPhone($scope.m, function (res) {
                    featureEnrollService.boughtFeature($scope.m , function(){
                        dialogUtils.showTip('操作成功') ;
                        $scope.search() ;
                    });
                });
            };

            function validInput(){

                if(!commonValidInput()){
                    return ;
                }

                if(!$scope.m.feature){
                    dialogUtils.showTip('请选择其中一个功能');
                    return;
                }

                return true;
            }

            function commonValidInput(){
                if(!$scope.m.companyId){
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }

                if(!$scope.m.telephone) {
                    dialogUtils.showTip('请输入车店注册手机号');
                    return;
                }

                if(!$scope.forever && !$scope.m.expireTime){
                    dialogUtils.showTip('请检查到期日');
                    return;
                }

                if($scope.forever && $scope.m.expireTime){
                    dialogUtils.showTip('到期日与永久有效不能同时存在');
                    return;
                }

                return true;
            }

            //开通套餐
            $scope.boughtFeaturePackage = function(featurePackage){

                if(!commonValidInput()){
                    return ;
                }

                $scope.m.featurePackage = featurePackage ;
                internalWeCatService.isCompanyRegisterPhone($scope.m, function (res) {
                    featureEnrollService.boughtFeaturePackage($scope.m);
                })
            };

            $scope.findAccount = function () {
                if(!$scope.m.companyId){
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }
                featureEnrollService.findAccount($scope.m.companyId, function (res) {
                    $scope.settingInsurance = res;
                });

            };

            $scope.addAccount = function(isEdit){
                if(!$scope.m.companyId){
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }
                $scope.insurance.companyId = $scope.m.companyId;
                if(!$scope.insurance.accountId){
                    dialogUtils.showTip('请输入车险代理账号');
                    return;
                }
                if(!$scope.insurance.password){
                    dialogUtils.showTip('请输入代理密码');
                    return;
                }
                if(isEdit){
                    featureEnrollService.editInsurancePassword($scope.insurance);
                }else{
                    featureEnrollService.addAccount($scope.insurance);

                }
            };

        }])
    .controller('wechat-template-ctrl', ['$scope', '$interval', 'wechatService', 'companyService', '$location' , 'internalWeCatService',
        function ($scope, $interval, wechatService, companyService , $location, internalWeCatService) {

            $scope.m = {};

            var checkInput = function () {
                if(!$scope.m.companyId){
                    dialogUtils.showTip('请输入车店编号');
                    return false;
                }
                if(!$scope.m.telephone) {
                    dialogUtils.showTip('请输入车店注册手机号');
                    return false;
                }
                return true;
            };

            $scope.setTemplate = function () {
                if(checkInput()){
                    internalWeCatService.isCompanyRegisterPhone($scope.m, function (res) {
                        wechatService.setTemplate($scope.m, function (res) {
                        });
                    })
                }
            };

            $scope.getAppIdAppSecrets = function () {
                if(checkInput()){
                    wechatService.getAppIdAppSecrets($scope.m, function (res) {
                        $scope.appIdAppsecret = res;
                    });
                }
            };


            $scope.setIndustry = function () {
                if(checkInput()){
                    internalWeCatService.isCompanyRegisterPhone($scope.m, function (res) {
                        wechatService.setIndustry($scope.m, function (res) {
                        });
                    })
                }
            };


            $scope.deleteTemplateById = function (id) {
                dialogUtils.showTipWithCB('确认删除吗？', function () {
                    wechatService.deleteTemplateById(id, function (res) {
                        $scope.getTemplates();
                    });
                });

            };


            $scope.deleteAppSecretById = function (id) {
                dialogUtils.showTipWithCB('确认删除吗？', function () {
                    wechatService.deleteAppSecretById({id:id}, function (res) {
                       $scope.getAppIdAppSecrets();
                    });
                });

            };


            $scope.goAuthorizationPage = function(){
                var authorizationUrl = 'car.realscloud.com' == $location.host()
                    ? 'http://wx.realscloud.com/we/component.html' : 'http://wxt.realscloud.com/we/component.html' ;
                window.open(authorizationUrl) ;
            } ;

            $scope.getTemplates = function () {
                if($scope.m.companyId){
                    wechatService.getTemplates($scope.m.companyId, function (res) {
                        $scope.list = res;
                    });
                }else{
                    dialogUtils.showTip('请检查输入车店编号');
                }
            };

            $scope.syncSubscribe = function(){
                if($scope.m.companyId){
                    wechatService.syncSubscribeByCompany($scope.m.companyId);
                }else{
                    dialogUtils.showTip('请检查输入车店编号');
                }

            };

        }
    ])
    .controller('wechat-template-delete-ctrl', ['$scope', 'wechatService', 'companyService',
        function ($scope, wechatService, companyService) {

            $scope.deleteAppId = function () {
                if($scope.m.companyId){
                    wechatService.deleteTemplateAndAppSecret($scope.m, function (res) {
                        dialogUtils.showTip('操作成功');
                    });
                }else{
                    dialogUtils.showTip('请检查输入项');
                }
            };

            var init = function () {
                $scope.m = {companyId:''};
            };
            init();


        }
    ])
    .controller('company-lakala-ctrl', ['$scope', 'companyService',
        function ($scope, companyService) {

            $scope.saveOrUpdateCompanyLakalaDevice = function () {
                if($scope.m.companyId && $scope.m.deviceInfo && $scope.m.mchId && $scope.m.bankDeviceInfo){
                    companyService.saveOrUpdateCompanyLakalaDevice($scope.m, function (res) {
                        dialogUtils.showTip('操作成功');
                        $scope.findCompanyLakalaDevice();
                    });
                }else{
                    dialogUtils.showTip('请检查输入项');
                }
            };

            $scope.findCompanyLakalaDevice = function () {
                companyService.findCompanyLakalaDevice($scope.m , function (res) {
                    $scope.list = res;
                });
            };

            $scope.deleteCompanyLakalaDevice = function (id) {
                dialogUtils.showTipWithCB('确定删除吗?', function(){
                    companyService.deleteCompanyLakalaDevice({id:id}, function (res) {
                        $scope.findCompanyLakalaDevice();
                    });
                });
            };

            var init = function () {
                $scope.m = {companyId:'', deviceInfo:'', mchId:'', bankDeviceInfo:'' };
            };
            init();


        }
    ])
    .controller('navigation-ctrl', ['$scope', function ($scope) {
            $scope.realName = localStorage.getItem('internalRealName');
            $scope.logout = function () {
                Cookies.remove('sid');
                window.location='./login.html';
            };
    }])
    .controller('company-clear-ctrl', ['$scope','companyClear','validateSmsCode', function ($scope,companyClear,validateSmsCode) {

         $scope.clearAll = function(){
             dialogUtils.showTipWithCB('确定清理吗?', function(){
                 validateSmsCode.validateSmsCode($scope.smsCode,function(){
                     companyClear.clearAll($scope.companyId);
                 });

             })
         };
        $scope.clearAllExceptGoods = function(){
            dialogUtils.showTipWithCB('确定清理吗?',function(){
                validateSmsCode.validateSmsCode($scope.smsCode,function(){
                    companyClear.clearAllExceptGoods($scope.companyId);
                });

            });
        };
        $scope.clearAllExceptGoodsAndService = function(){
            dialogUtils.showTipWithCB('确定清理吗?',function(){
                validateSmsCode.validateSmsCode($scope.smsCode,function(){
                    companyClear.clearAllExceptGoodsAndService($scope.companyId);
                });

            });
        };
        $scope.clearAllExceptService = function(){
            dialogUtils.showTipWithCB('确定清理吗?',function(){
                validateSmsCode.validateSmsCode($scope.smsCode,function(){
                    companyClear.clearAllExceptService($scope.companyId);
                })

            });
        };

        //获取短信验证码
        $scope.fetchSmsCode = function(){
            $scope.m.timestamp = $('#imageCode').attr('src').substring(15);
            validateSmsCode.fetchSmsCode($scope.m);
        };

        $scope.validateSmsCode=function(){
            validateSmsCode.validateSmsCode()

        };





        $scope.changeImageCode = function() {
            $('#imageCode').attr('src', '/code?type=4&t=' + new Date().getTime());
        };
        $scope.changeImageCode();





        var init = function(){
            $scope.m={phoneCodeType:4};

        };
        init();


    }])
    .controller('chain-shop-ctrl', ['$scope', 'companyService', function ($scope, companyService) {
            $scope.searchListChainCompanies = function(){
                scope.initPage($scope,companyService.listChainCompanies,function(res){
                    $scope.list = res;
                });
            };
            var init = function(){
                $scope.q = {companyId: ''}
            };
            init();
    }])
    .controller('page-setting-ctrl', ['$scope', 'companyService', function ($scope, companyService) {

        $scope.companyId = '';

        $scope.findByWebPageSetting = function () {
            companyService.findWebPageSetting({id:1}, function (res) {
                $scope.list = res;
            });
        };
        $scope.findByWebPageSetting();


        $scope.updateWebPageSettingId = function(){
            if($scope.companyId==''){
                dialogUtils.showTip('请输入车店编号');
                return;
            }
            var q = {"companyIds":[$scope.companyId],"webPageSettingId": 1};
            companyService.updateWebPageSettingId(q, function () {
                $scope.findByWebPageSetting();
            });
        };

        $scope.cancelWebPageSettingId = function (companyId) {
            var q = {"companyIds":[companyId],"webPageSettingId": 0};
            companyService.updateWebPageSettingId(q, function () {
                $scope.findByWebPageSetting();
            });
        };


    }])
    .controller('apk-update-ctrl', ['$scope', 'Upload', 'apkUpdateService',  function ($scope, Upload, apkUpdateService) {

        $scope.upload = function (type,file) {
            if (!file) {
                return;
            }
            if (type == 0) {
                $scope.m.apkName0 = file.name;
                $scope.m.apkNameSize0 = file.size;
            }
            if (type == 1) {
                $scope.m.apkName1 = file.name;
                $scope.m.apkNameSize1 = file.size;

            }
            if (type == 2) {
                $scope.m.updateInfoName = file.name;
            }
            var fileName = 'version/' + file.name;
            apkUpdateService.getSts(function (res) {
                var sts = res;
                $scope.uploadApk(file, fileName, sts);
            });
            $scope.uploadApk = function (file, fileName, sts) {
                var client = new OSS.Wrapper({
                    accessKeyId: sts.accessKeyId,
                    accessKeySecret: sts.accessKeySecret,
                    stsToken: sts.securityToken,
                    endpoint: 'http://oss-cn-shenzhen.aliyuncs.com',
                    bucket: 'scs-pic',
                    callbackUrl: sts.callbackUrl,
                    //cname: true
                });
                client.multipartUpload(fileName, file
                ).then(function (result) {
                    $scope.showTip('上传' + fileName + '成功');
                }).catch(function (err) {
                    $scope.showTip('上传' + fileName + '失败');
                });

            }
        };
        $scope.saveInfo = function () {
            if (!$scope.m.apkName0) {
                dialogUtils.showTip('请先上传超级车店apk更新包');
                return;
            }
            if (!$scope.m.apkName1) {
                dialogUtils.showTip('请先上传新概念apk更新包');
                return;
            }
            if (!$scope.m.updateInfoName) {
                dialogUtils.showTip('请先上传updateInfo文件');
                return;
            }
            apkUpdateService.apkUpdate($scope.m, function () {
                $scope.m = {};
            });
        };
            var init = function(){
                $scope.m = {};
            };
            init();
        }
    ]);


