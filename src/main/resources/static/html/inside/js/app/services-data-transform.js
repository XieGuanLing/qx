/**
 * Created by guan on 2016/7/20.
 */
angular.module("services-data-transform", [])
    .factory('feedbackService', function (httpService) {
        return {
            ctrl: '/internal/feedback/',
            queryFeedback: function (data, success) {
                var url = this.ctrl + 'queryFeedback';
                httpService.post(true, url, data, success);
            },
            updateState: function (id, success) {
                var url = this.ctrl + 'updateState';
                var data = {id: id};
                httpService.post(true, url, data, success);
            }
        };
    })
    .factory('adService', function (httpService) {
        return {
            ctrl: '/internal/ad/',
            addAd: function (data, success) {
                var url = this.ctrl + 'addAd';
                httpService.post(true, url, data, success);
            },
            deleteAd: function (ids, success) {
                var url = this.ctrl + 'deleteAd';
                httpService.post(true, url, {ids:ids}, success);
            },
            listAd: function (data, success) {
                var url = '/internal/ad/listAd';
                httpService.post(true, url, data, success);
            },
            editAd: function (data, success) {
                var url = this.ctrl + 'editAd';
                httpService.post(true, url, data, success);
            }
        };
    })
    .factory('featureEnrollService', function (httpService) {
        return {
            ctrl: '/internal/companies/',
            queryAllFeatureUsingState: function (companyId, success) {
                var url = this.ctrl + companyId + '/' + 'queryAllFeatureUsingState';
                httpService.post(true, url, {companyId: companyId}, success);
            },
            buyFeatures: function (m, success) {
                if (!m.companyId) {
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }
                var url = this.ctrl + 'features/' + 'buyFeatures';
                httpService.post(true, url, m, success);
            },
            boughtFeature: function (m, success) {
                var companyId = m.companyId;
                var url = this.ctrl + companyId + '/features/' + 'boughtFeature';
                httpService.put(true, url, m, success);
            },
            boughtFeaturePackage: function (m, success) {
                if (!m.companyId) {
                    dialogUtils.showTip('请输入车店编号');
                    return;
                }
                var companyId = m.companyId;
                var url = this.ctrl + companyId + '/features/' + 'upgradeFeaturePackage';
                httpService.put(true, url, m, success);
            },
            addAccount: function (m, success) {
                var url = '/internal/insuranceProxy/addAccount' ;
                httpService.post(true, url, m, success);
            },
            findAccount: function (companyId, success) {
                var url = '/internal/insuranceProxy/findAccount' ;
                httpService.post(true, url, {id: companyId}, success);
            },
            editInsurancePassword: function (m, success) {
                var url = '/internal/insuranceProxy/editInsurancePassword';
                httpService.post(true, url, m, success);
            }

        };
    })
    .factory('companyService', function (httpService) {
        return {
            ctrl: '/internal/companies/',
            queries: function (key, success) {
                var url = this.ctrl + 'queries';
                httpService.post(false, url, {key: key}, success);
            },
            saveOrUpdateCompanyLakalaDevice: function (m, success) {
                var url = this.ctrl + 'saveOrUpdateCompanyLakalaDevice';
                httpService.post(false, url, m, success);
            },
            findCompanyLakalaDevice: function (m, success) {
                var url = this.ctrl + 'findCompanyLakalaDevice';
                httpService.post(false, url, m, success);
            },
            deleteCompanyLakalaDevice:function (m, success) {
                var url = this.ctrl + 'deleteCompanyLakalaDevice';
                httpService.post(false, url, m, success);
            },
            listChainCompanies: function (q, success) {
                var url = '/internal/listChainCompanies';
                httpService.post(false, url, q, success);
            },
            updateWebPageSettingId: function (q, success) {
                var url = this.ctrl + 'updateWebPageSettingId';
                httpService.post(false, url, q, success);
            },
            findWebPageSetting: function (q, success) {
                var url = this.ctrl + 'findWebPageSetting';
                httpService.post(false, url, q, success);
            }
        };
    })
    .factory('wechatService', function (httpService) {
        return {
            ctrl: '/wechat/',
            setTemplate: function (m, success) {
                var url = this.ctrl + 'setTemplate';
                httpService.post(true, url, m, success);
            },
            setIndustry: function (m, success) {
                var url = this.ctrl + 'setIndustry';
                httpService.post(true, url, m, success);
            },
            deleteTemplateAndAppSecret: function (m, success) {
                var url = this.ctrl + 'deleteTemplateAndAppSecret';
                httpService.post(true, url, m, success);
            },
            deleteAppSecretById: function (m, success) {
                var url = this.ctrl + 'deleteAppSecretById';
                httpService.post(true, url, m, success);
            },
            getTemplateTypes: function (success) {
                var url = this.ctrl + 'getTemplateTypes';
                httpService.post(true, url, {}, success);
            },
            deleteTemplateById: function (id, success) {
                var url = this.ctrl + 'deleteTemplateById';
                httpService.post(true, url, {id:id}, success);
            },
            getAppIdAppSecrets: function (m, success) {
                var url = this.ctrl + 'getAppIdAppSecrets';
                httpService.post(true, url, m, success);
            },
            getTemplates: function (companyId, success) {
                var url = this.ctrl + 'getTemplates';
                httpService.post(true, url, {companyId:companyId}, success);
            },
            getMenu: function (companyId, success) {
                var url = this.ctrl + 'getMenu';
                httpService.post(true, url, {companyId: companyId}, success);
            },
            createMenu: function (m, success) {
                var url = this.ctrl + 'createMenu';
                httpService.post(true, url, m, success);
            } ,
            getDefaultMenu: function (companyId, success) {
                var url = this.ctrl + 'getDefaultMenu';
                httpService.post(false, url, {companyId:companyId}, success);
            } ,
            syncSubscribeByCompany: function (companyId, success) {
                var url =  '/internal/syncSubscribeByCompany';
                httpService.post(false, url, {id:companyId}, success);
            }
        };
    })
    .factory('internalWeCatService', function (httpService) {
        return {
            ctrl: '/internal/wechat',
            sendSmsPhoneCodeToCreateOwner: function (m, success) {
                var url = this.ctrl + '/sendSmsPhoneCodeToCreateOwner';
                httpService.post(false, url, m, success);
            },
            checkSmsPhoneCodeToCreateOwner: function (m, success) {
                var url = this.ctrl + '/checkSmsPhoneCodeToCreateOwner';
                httpService.post(false, url, m, success);
            },
            isCompanyRegisterPhone: function (m, success) {
                var url = this.ctrl + '/isCompanyRegisterPhone';
                httpService.post(false, url, m, success);
            }
        }
    })
    .factory('dataTransformService', function (httpService) {
        return {
            ctrl: '/internal/data/',
            parseExcel: function (excel, m, success) {
                var data = {
                    excel: excel,
                    phone: m.phone,
                    remark: m.remark,
                    companyId: m.companyId,
                    user: "frank",
                    pwd: "YYuoMnxUKH82Yh"
                };
                httpService.post(true, this.ctrl + "parseExcel", data, success);
            },
            parseProgress: function (bid, success) {
                var data = {bid: bid};
                httpService.post(false, this.ctrl + "getProgress", data, success);
            },
            getUploadRecord: function (bid, success) {
                var data = {bid: bid};
                httpService.post(false, this.ctrl + "getUploadRecord", data, success);
            },
            uploadRecords: function (q, success) {
                var data = {
                    currPage: q.currPage,
                    pageSize: q.pageSize
                };
                httpService.post(false, this.ctrl + "uploadRecords", data, success);
            },
            sheets: function (success) {
                httpService.post(false, this.ctrl + "sheets", {}, success);
            },

            batchSummary: function (batchId, success) {
                httpService.post(false, '/internal/export/'+batchId + '/batchSummary', {}, success);
            },
            sheetDetail: function (batchId, model, q, success) {
                var data = {
                    batchId: batchId,
                    model: model,
                    state: q.state,
                    curPage: q.currPage,
                    pageSize: q.max
                };
                httpService.post(false, this.ctrl + "sheetDetail", data, success);
            },
            updateModel: function (m, modelName, success) {
                m.state_ = 'UPLOADED';
                m.errorMessage_ = '';
                delete m.$$hashKey;
                delete m.setterList;
                delete m.uploadTime_;
                var data = {
                    id: m._id,
                    model: m,
                    modelName: modelName
                };
                httpService.post(false, this.ctrl + "updateModel", data, success);
            },

            removeModel: function (m, modelName, success) {
                var data = {
                    id: m._id,
                    modelName: modelName
                };
                httpService.post(false, this.ctrl + 'removeModel', data, success);
            },
            loginInternal: function (user, password, success) {
                var data = {
                    user: user,
                    password: password
                };
                httpService.post(false, '/internal/userLogin', data, success);
            },
            import2Mysql: function (bid, success) {
                var data = {
                    bid: bid,
                    phone: "",
                    user: "frank",
                    pwd: "YYuoMnxUKH82Yh"
                };
                httpService.post(false, this.ctrl + "import2Mysql", data, success);
            },
            getModel: function (model) {
                return {
                    BillModel: {
                        companyName: "车店名称",
                        billIdString: "单据号",
                        carNumber: "车牌号",
                        phone: "联系手机",
                        name: "联系人",
                        total: "单据总价",
                        discount: "单据折扣",
                        paid: "实收金额",
                        waitInStore: "是否在店等",
                        payType: "支付类型",
                        remark: "备注",
                        createdDate: "开单时间",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    BillItemModel: {
                        companyName: "车店名称",
                        billIdString: "单据号",
                        name: "商品名称",
                        num: "数量",
                        price: "售价",
                        discount: "折扣",
                        itemType: "类型",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    MemberCardModel: {
                        companyName: "车店名称",
                        cardCode: "卡号",
                        memberCardName: "会员卡名称",
                        carNumber: "车牌号",
                        cardType: "卡类型",
                        cardSortName: "卡品种名称",
                        dateCreated: "开卡日期",
                        validTime: "到期日期",
                        balance: "卡内余额",
                        name: "联系人姓名",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    MemberCardItemModel: {
                        companyName: "车店名称",
                        cardCode: "卡号",
                        name: "商品名称",
                        price: "售价",
                        discount: "折扣",
                        num: "剩余数量",
                        originalNum: "初始数量",
                        itemType: "商品类别",
                        specialType: "项目类别",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    MemberCardSortModel: {
                        companyName: "车店名称",
                        cardName: "卡品种名称",
                        cardType: "卡类型",
                        demoPrice: "参考售价",
                        phone: "手机号码",
                        price: "实际售价",
                        validForEver: "是否永久生效",
                        validMonth: "有效期",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    MemberCardSortItemModel: {
                        companyName: "车店名称",
                        cardName: "卡品种名称",
                        name: "商品名称",
                        price: "售价",
                        discount: "折扣",
                        num: "初始数量",
                        type: "项目类型",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    CarInfoModel: {
                        brand: "品牌",
                        type: "车型",
                        carNumber: "车牌",
                        phone: "手机号",
                        registerDate: "注册日期",
                        engineNumber: "发动机号码",
                        uniqueId: "车架号",
                        insuranceValidDate: "保险日期",
                        insuranceCompany: '承保公司',
                        tcInsuranceValidDate: '交强险日期',
                        tcInsuranceCompany: '交强险承保公司',
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    ItemModel: {
                        companyName: "车店名称",
                        brandName: "品牌",
                        name: "商品名称",
                        goodsFormat: "商品规格",
                        itemType: "商品类型",
                        barCode: "条形码",
                        price: "售价",
                        firstCategoryName: "一级分类",
                        secondCategoryName: "二级分类",
                        manufactory: "厂商",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    SupplierModel: {
                        companyName: "车店名称",
                        name: "供应商名称",
                        phone: "手机",
                        fax: "传真",
                        address: "地址",
                        contactName: "其他联系人",
                        contactPhone: "其他联系手机",
                        accountName: "银行账号开户名称",
                        accountNumber: "银行账号",
                        depositBank: "开户行",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    StoreRoomInventoryModel: {
                        companyName: "车店名称",
                        storeRoomName: "仓库名称",
                        goodsName: "商品名称",
                        inventoryNum: "库存数量",
                        price: "入库单价",
                        remark: "备注",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    },
                    StoreRoomModel: {
                        companyName: "车店名称",
                        name: "仓库名称",
                        remark: "备注",
                        uploadTime_: "上传时间",
                        errorMessage_: "错误消息",
                        state_: "状态"
                    }
                }[model];
            },
            getAttrs: function (model) {
                var target = [];
                for (var attr in model) {
                    if (model.hasOwnProperty(attr)) {
                        target.push(attr);
                    }
                }
                return target;
            }
        };
    })
    .factory('dataExportService', function(httpService) {
        return{
            ctrl: '/internal/export/',
            getExportTypes: function(success){
               var url = this.ctrl + 'getExportTypes';
               httpService.post(true, url, {}, success);
            }
        };
    })
    .factory('Excel', function ($window) {
        var uri = 'data:application/vnd.ms-excel;base64,',
            template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
            base64 = function (s) {
                return $window.btoa(unescape(encodeURIComponent(s)));
            },
            format = function (s, c) {
                return s.replace(/{(\w+)}/g, function (m, p) {
                    return c[p];
                })
            };
        return {
            tableToExcel: function (tableId, worksheetName) {
                var table = $(tableId),
                    ctx = {worksheet: worksheetName, table: table.html()},
                    href = uri + base64(format(template, ctx));
                return href;
            }
        };
    })
    .factory('companyClear', function (httpService) {
        return {
            ctrl: '/internal/init/',
            clearAll: function (m, success) {
                var url = this.ctrl + 'clearAll';
                httpService.post(true, url, {companyId:m}, success);
            },
            clearAllExceptGoods: function (m, success) {
                var url = this.ctrl + 'clearAllExceptGoods';
                httpService.post(true, url, {companyId:m}, success);
            },
            clearAllExceptGoodsAndService: function (m, success) {
                var url = this.ctrl + 'clearAllExceptGoodsAndService';
                httpService.post(true, url, {companyId:m}, success);
            },
            clearAllExceptService: function (m, success) {
                var url = this.ctrl + 'clearAllExceptService';
                httpService.post(true, url, {companyId:m}, success);
            }
        };
    })
    .factory('validateSmsCode', function (httpService) {
        return {
            ctrl: '/sms/',
            fetchSmsCode: function (m,success) {
                var url = this.ctrl + 'fetchSmsCode';
                httpService.post(true, url, m, success);
            },
            validateSmsCode: function (m, success) {
                var url = this.ctrl + 'validateSmsCode';
                var codeCommand = {phoneCodeType: 4,smsCode : m };
                httpService.post(true, url,codeCommand, success);
            },

        };
    })
    .factory('apkUpdateService',function (httpService) {
        return{
            getSts:function(success){
                var url =  '/internal/android/getSts';
                httpService.post(false, url, {}, success);
            },
            apkUpdate: function (m, success) {
                var url = '/internal/android/apkUpdate';
                httpService.post(true, url, m, success);
            }
        }
    });
