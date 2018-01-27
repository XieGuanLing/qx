/**
 * Created by guan on 2016/9/20 0020.
 */
var scope = {
    baseUpload: function (url, service, file, ok) {
        if (!file) {
            return;
        }
        service.upload({
            url: url,
            data: {file: file}
        }).then(function (resp) {
            if (resp.data.success == true) {
                ok(resp.data.resultObject);
            } else {
                dialogUtils.showTip(resp.data.msg);
            }
        }, function (resp) {

        }, function (evt) {
            //var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
            //console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
        });
    },
    upload2Asset: function (service, file, ok) {
        this.baseUpload('/internal/asset/up0', service, file, ok);
    },
    upload2Media: function (service, file, ok) {
        if (file && file.size && file.size > 1024000) {
            dialogUtils.showTip('图片不能大于1M');
            return;
        }
        this.baseUpload('/media/upload', service, file, ok);
    },
    initSelectedList: function ($scope, $uibModalInstance, equalId) {
        var handleSelected = function (i) {
            //处理添加或删除
            if (i.isCheck) {
                $scope.selected.push(i);
            } else {
                var deleteIndex;
                $.each($scope.selected, function (index, item) {
                    if (item[equalId] == i[equalId]) {
                        deleteIndex = index;
                    }
                });
                if (deleteIndex != undefined) {
                    $scope.selected.splice(deleteIndex, 1);
                }
            }
        };
        $scope.check = function (i) {
            //处理是否全选
            var diff = $.grep($scope.list, function (item, index) {
                return item.isCheck != i.isCheck;
            });
            if (diff.length == 0) {
                $scope.isCheckAll = i.isCheck;
            } else {
                $scope.isCheckAll = false;
            }
            handleSelected(i);
        };
        $scope.checkAll = function () {
            //处理是否全选
            $.each($scope.list, function (index, item) {
                item.isCheck = $scope.isCheckAll;
                handleSelected(item);
            });
        };
        $scope.ok = function () {
            $uibModalInstance.close($scope.selected);
        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    },
    showModal: function ($uibModal, tip, ok) {
        var special = {tip: tip};
        $uibModal.open({
            animation: true,
            templateUrl: 'tip-modal.html',
            controller: 'tip-modal-ctrl',
            size: 'sm',
            resolve: {
                special: function () {
                    return special;
                }
            }
        }).result.then(function (res) {
            ok();
        }, function () {
            ok()
        });
    },
    initClassToggle: function ($scope) {
        $scope.current = 0;
        $scope.setCurrent = function (index) {
            $scope.current = index;
        };
        $scope.isCurrent = function (index) {
            return $scope.current == index;
        };
    },
    initModal2: function ($uibModal, modal, size, special, ok) {
        $uibModal.open({
            animation: true,
            templateUrl: modal + '-modal.html',
            controller: modal + '-modal-ctrl',
            size: size,
            resolve: {
                special: function () {
                    return special;
                }
            }
        }).result.then(function (res) {
            if (ok) {
                ok(res);
            }
        }, function () {

        });
    },
    initModal: function ($scope, $uibModal, template, ctrl, size, special, ok) {
        $uibModal.open({
            animation: true,
            templateUrl: template,
            controller: ctrl,
            size: size,
            resolve: {
                special: function () {
                    return special;
                }
            }
        }).result.then(function (res) {
            ok(res);
        }, function () {

        });
    },
    /**
     * 传递基本值时使用
     * @param $scope
     * @param $uibModalInstance
     * @param resultCallBack
     */
    initModalButton: function ($scope, $uibModalInstance, resultCallBack) {
        $scope.ok = function () {
            if (resultCallBack) {
                $uibModalInstance.close(resultCallBack());
            } else {
                $uibModalInstance.close();
            }
        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    },
    /**
     * result传递基本值时有误，不是地址传递
     * @param $scope
     * @param $uibModalInstance
     * @param result
     * @param ifOK
     */
    initModalInstance: function ($scope, $uibModalInstance, result, ifOK) {
        $scope.ok = function () {
            if (ifOK) {
                if (ifOK()) {
                    $uibModalInstance.close(result);
                }
            } else {
                $uibModalInstance.close(result);
            }
        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    },
    initCheckList: function ($scope, changeCallBack) {
        $scope.check = function (i) {
            var diff = $.grep($scope.list, function (item, index) {
                return item.isCheck != i.isCheck;
            });
            if (diff.length == 0) {
                $scope.isCheckAll = i.isCheck;
            } else {
                $scope.isCheckAll = false;
            }
        };
        $scope.checkAll = function () {
            $.each($scope.list, function (index, item) {
                item.isCheck = $scope.isCheckAll;
                if (changeCallBack) {
                    changeCallBack(item);
                }
            });
        };
    },
    /**
     * 上下翻页可选
     * @param $scope
     * @param propertyName
     */
    initPageCheckList : function ($scope, propertyName) {
        $scope.selecteds = [];
        $scope.successCallBack = function (res) {
            $scope.total = res.total;
            $scope.list = res.rows;
            $scope.totalPage = Math.ceil(res.total / $scope.q.max);

            //检查是否是选中项
            $scope.isCheckAll = false;
            $.each($scope.list, function (index, item) {
                //需补数量
                item.goods.alarmNum = item.goods.alarmNum || 0;
                item.inventoryTotalNum = item.inventoryTotalNum || 0 ;
                //排序字段
                item.costPrice = item.goods.costPrice || 0;
                item.need = item.goods.alarmNum - item.inventoryTotalNum;
                if (objectIndexOf($scope.selecteds, propertyName, item[propertyName]) != -1) {
                    item.isCheck = true;
                    //处理是否全选
                    $scope.check(item);
                }
            });
        };


        $scope.checkChange = function (item) {
            var index = objectIndexOf($scope.selecteds, propertyName, item[propertyName]);
            if (item.isCheck) {
                //不存在则加入
                if (index == -1) {
                    $scope.selecteds.push(item);
                }
            } else {
                //存在则删除
                if (index != -1) {
                    $scope.selecteds.splice(index, 1);
                }
            }
        };

        $scope.check = function (i) {
            var diff = $.grep($scope.list, function (item, index) {
                return item.isCheck != i.isCheck;
            });
            if (diff.length == 0) {
                $scope.isCheckAll = i.isCheck;
            } else {
                $scope.isCheckAll = false;
            }
            $scope.checkChange(i);
        };
        $scope.checkAll = function () {
            $.each($scope.list, function (index, item) {
                item.isCheck = $scope.isCheckAll;
                $scope.checkChange(item);
            });
        };
    },

    initDeleteFunction: function ($scope, service) {
        var deleteSuccess = function (res) {
            $scope.search();
            dialogUtils.showTip('操作成功');
        };

        $scope.deleteOne = function (id) {
            var ids = [id];
            var ok = function () {
                service.deleteByIdLogically(ids, deleteSuccess);
            };
            dialogUtils.showTipWithCB('确定删除吗？', ok);
        };


        $scope.deleteChecked = function () {
            var ids = [];
            $.each($scope.list, function (index, item) {
                if (item.isCheck) {
                    ids.push(item.id);
                }
            });
            if (ids.length) {
                var ok = function () {
                    service.deleteByIdLogically(ids, deleteSuccess);
                };
                dialogUtils.showTipWithCB('确定删除吗？', ok);
            } else {
                dialogUtils.showTip('请先选择要删除的内容');
            }
        };
    },
    /**
     *
     * @param $scope
     * @param search
     * @param successCallBack
     * @param initSearchParameterCallBack  比如有全选功能时，传入$scope.isCheckAll = false;
     */
    initPage: function ($scope, search, successCallBack, initSearchParameterCallBack) {
        if(!successCallBack){
            successCallBack = function (res) {
                $scope.total = res.total;
                $scope.list = res.rows;
                $scope.totalPage = Math.ceil(res.total / $scope.q.max);
            }
        }

        var initSearchParameter = function () {
            $scope.list = [];
            $scope.currPage = 0;
            $scope.totalPage = 0;
            $scope.total = 0;

            $scope.q.max = 10;
            $scope.q.start = 0;

            if (initSearchParameterCallBack) {
                initSearchParameterCallBack();
            }
        };

        $scope.search = function () {
            initSearchParameter();
            search($scope.q, successCallBack);
        };
        $scope.search();

        $scope.firstPage = function () {
            if ($scope.currPage <= 0) {
                return;
            }
            $scope.currPage = 0;
            $scope.q.start = $scope.currPage * $scope.q.max;
            search($scope.q, successCallBack);
        };

        $scope.previousPage = function () {
            if ($scope.currPage <= 0) {
                return;
            }
            $scope.currPage = $scope.currPage - 1;
            $scope.q.start = $scope.currPage * $scope.q.max;
            search($scope.q, successCallBack);
        };

        $scope.nextPage = function () {
            if ($scope.currPage >= $scope.totalPage - 1) {
                return;
            }
            $scope.currPage = $scope.currPage + 1;
            $scope.q.start = $scope.currPage * $scope.q.max;
            search($scope.q, successCallBack);
        };

        $scope.lastPage = function () {
            if ($scope.currPage >= $scope.totalPage - 1) {
                return;
            }
            $scope.currPage = $scope.totalPage - 1;
            $scope.q.start = $scope.currPage * $scope.q.max;
            search($scope.q, successCallBack);
        };
    }
};