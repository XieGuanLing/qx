/**
 * Created by gl on 2017/7/6.
 */
angular.module('c.ad', [])
    .controller('internal-content-ctrl', ['$scope', '$uibModal','employeeService', function ($scope, $uibModal,employeeService) {


        $scope.hasAuthCode = function(m){
            return employeeService.hasAuth(m)
        } ;

        $scope.showSuccessTip = function () {
            $scope.showTip('操作成功');
        };

        $scope.showTip = function (tip, ok) {
            $scope.showModal('tip', 'sm', {tip:tip}, ok);
        };

        $scope.showModal = function (modal, size, special, ok, cancel){
            $uibModal.open({
                animation: true,
                templateUrl: modal+'-modal.html',
                controller: modal+'-modal-ctrl',
                size:size,
                resolve: {
                    special: function () {
                        return special;
                    }
                }
            }).result.then(function (res) {
                if(ok) ok(res);
            }, function () {
                if(cancel) cancel();
            });
        };


        var init =function(){
            if(!Cookies.get('sid')){
                window.location='./login.html';
            }
            employeeService.authMark.isManager = localStorage.getItem('isManager');
            var user ={phone:localStorage.getItem('phone'),realName:localStorage.getItem('internalRealName')}
            employeeService.queryInternalUser(user,function(res){
                if(res.isLogin==false){
                    Cookies.remove('sid');
                    window.location='./login.html';
                }
            });
        };
        init();
    }])
    .controller('ad-modal-ctrl', ['$scope', '$uibModalInstance', 'Upload', 'adService', 'special' ,
        function ($scope, $uibModalInstance, Upload, adService, special) {
            if(special){
                $scope.m = {};
                $.extend($scope.m, special);
                $scope.m.sourceType = special.sourceType + '';
                $scope.m.adType = special.adType + '';
            }else{
                //source 0:普通 1:新概念
                //adType 1:闪屏 2:banner
                $scope.m = {sourceType:'0', adType:'2', showTime:3};
            }

            $scope.upload = function (file) {
                scope.upload2Asset(Upload, file, function (res) {
                    if(res.length){
                        console.log(res[0]);
                        $scope.m.imgURL = res[0];
                    }
                })
            };

            $scope.ok = function () {
                var field = ['title', 'shareText', 'showTime', 'imgURL', 'detailURL', 'sourceType', 'adType'];
                var tips = ['标题', '分享文案', '展示时间', '图片', '详情链接', '渠道', '广告类型'];

                if(validateNeedField($scope.m, field, tips)){
                    if($scope.m.adNodeId){
                        adService.editAd($scope.m,  function () {
                            $uibModalInstance.close();
                        });
                    }else{
                        adService.addAd($scope.m,  function () {
                            $uibModalInstance.close();
                        });
                    }
                }
            };

            $scope.cancel = function () {
                $uibModalInstance.dismiss('cancel');
            };

        }])
    .controller('ads-ctrl', ['$scope', '$stateParams', 'adService',
        function ($scope, $stateParams, adService) {


            $scope.showAdModal = function (m) {
                $scope.showModal('ad', 'lg', m, function (res) {
                    $scope.search();
                });
            };

            $scope.editAd = function (i) {
                adService.editAd(i,  function () {
                })
            };

            $scope.deleteAd = function () {
                var ids = [];
                // for(var i=0; i++ ; i< $scope.list.length){
                //     var item = $scope.list[i];
                //     if(item.isCheck){
                //         ids.push(item.adNodeId);
                //     }
                // }
                $.each($scope.list, function (index, item) {
                    if(item.isCheck){
                        ids.push(item.adNodeId);
                    }
                });
                if(ids.length){
                    adService.deleteAd(ids, $scope.search);
                }else{
                    $scope.showTip('请先选择要删除的内容');
                }
            };

            scope.initCheckList($scope);
            $scope.q = {sourceType:'0'};
            scope.initPage($scope, adService.listAd, function (res) {
                $scope.list = res;
            });
        }])



;


