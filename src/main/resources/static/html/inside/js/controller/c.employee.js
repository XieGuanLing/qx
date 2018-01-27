angular.module('c.employee', [])

    .controller('role-ctrl', ['$scope', '$stateParams', 'adService', 'employeeService',
        function ($scope, $stateParams, adService, employeeService) {

            var showCancelAndSave = function (index, isShowCancel) {
                var current = $('.power .left li').eq(index);
                if (isShowCancel) {
                    $('.power .left li').not(current).fadeTo('slow', 0.2);
                    $('.power .left li').find('.cancel, .preser').hide();
                    $('.power .left li').find('.del, .set').show();
                    current.find('.cancel, .preser').show();
                    current.find('.del, .set').hide();
                    current.fadeTo('slow', 1);
                } else {
                    $('.power .left li').fadeTo('slow', 1);
                    current.find('.cancel, .preser').hide();
                    current.find('.del, .set').show();
                }

            };
            $scope.cancel = function (index) {
                $scope.currentIndex = 0;
                $scope.disabled = true;
                showCancelAndSave(index, false);
            };

            //点击新增角色时，先判断是否有未保存或取消的
            $scope.currentIndex = 0;
            $scope.disabled = true;
            $scope.set = function (index, role) {
                $scope.currentIndex = index;
                $scope.disabled = false;
                showCancelAndSave(index, true);
                $('.power_in input').prop({disabled: ""});
                $scope.auths = authUtils.setCheckNodes($scope.auths, role.codes);
            };

            $scope.delete = function (index, role) {
                var current = $('.power .left li').eq(index);
                $('.power .left li').not(current).fadeTo('slow', 0.2);
                $('.power .left li').find('.cancel, .preser').hide();
                $('.power .left li').find('.del, .set').show();
                current.fadeTo('slow', 1);

                var deleteCB = function () {
                    var deleteSuccess = function () {
                        employeeService.listRoles(function (res) {
                            $scope.roles = res;
                        });
                    };
                    employeeService.deleteRole(role.roleId, deleteSuccess);
                    showCancelAndSave(index, false);
                };
                var cancelCB = function () {
                    $('.power .left li').fadeTo('slow', 1);
                };
                dialogUtils.showTipWithCB("确定删除吗?", deleteCB, cancelCB);

            };

            $scope.save = function (index, role) {
                $scope.currentIndex = 0;
                $scope.disabled = true;
                role.codes = authUtils.getCheckNodeCodes($scope.auths);
                var success = function () {
                    dialogUtils.showTip('操作成功');
                    showCancelAndSave(index, false);
                };
                if (role.roleId) {
                    employeeService.updateInternalRole(role, success);
                }
            };

            $scope.showDialog = function (role) {
                var special = {};
                $.extend(special, role);
                if(!role.hasOwnProperty('codes')) {
                    special.codes = [];
                }
                $scope.showModal('role', 'sm', special, function (res) {
                    var role = res;
                    employeeService.updateInternalRole(role, function () {
                        employeeService.listRoles(function (res) {
                            $scope.roles = res;
                        });
                    })
                });
            };

            $scope.checkedParent = function (parent) {
                if (parent.checked) {
                    if (parent.children) {
                        authUtils.setAllNodesChecked(parent.children);
                    }
                } else {
                    if (parent.children) {
                        authUtils.setAllNodesUnchecked(parent.children);
                    }
                }
            };

            $scope.checkedChild = function (parent) {
                if (!parent.checked) {
                    parent.checked = true;
                }
            };


            var init = function () {
                employeeService.listAuth(function (res) {
                    $scope.auths = res;
                });
                employeeService.listRoles(function (res) {
                    $scope.roles = res;
                });
            };
            init();
            $scope.showRoleModal = function () {
                var special = {};
                $scope.showModal('role', 'sm', special, function (res) {
                    var role = res;
                    employeeService.saveInternalRole(role, function () {
                        employeeService.listRoles(function (res) {
                            $scope.roles = res;
                        });
                    })
                });
            };
        }])
    .controller('role-modal-ctrl', ['$scope', '$uibModalInstance', 'special', 'employeeService',
        function ($scope, $uibModalInstance, special, employeeService) {
            $scope.ok = function () {

                $uibModalInstance.close($scope.m);
            };

            $scope.cancel = function () {
                $uibModalInstance.dismiss('cancel');
            };
            var init = function () {
                $scope.m = special;
            };

            init();


        }])
    .controller('internal-user-ctrl', ['$scope', '$stateParams', 'adService', 'employeeService',
        function ($scope, $stateParams, adService, employeeService) {


            $scope.showAddRoleToUserModal = function () {
                $scope.roleId = [];
                var flag = 0;
                for (var i = 0; i < $scope.list.length; i++) {
                    var user = $scope.list[i];
                    if (user.isCheck) {
                        flag = 1;
                        $scope.userId.push(user.userId);
                        $scope.roleId.push(user.roleId);
                    }
                }
                if(!flag) {
                    dialogUtils.showTip('请先选择用户');
                    return ;
                }
                var special = {
                    userId : $scope.userId,
                    roleId : $scope.roleId
                };
                $scope.showModal('addRoleToUser', 'sm', special, function () {
                    $scope.userId = [];
                    $scope.search();
                });
            };
            $scope.showDeleteInternalUserModal = function () {
                var deleteCB = function () {
                    $scope.m.userId = [];
                    var flag = 0;
                    for (var i = 0; i < $scope.list.length; i++) {
                        var user = $scope.list[i];
                        if (user.isCheck) {
                            flag = 1;
                            $scope.m.userId.push(user.userId);
                        }
                    }
                    if(!flag) {
                        dialogUtils.showTip('请先选择用户');
                        return ;
                    }
                    employeeService.deleteInternalUser($scope.m, function () {
                        $scope.search();
                    });
                };
                dialogUtils.showTipWithCB("确定删除吗?", deleteCB);
            };


            $scope.showEditInternalUserModal = function (i) {
                if(i){
                    var special = i;
                }else {
                    var special = '';
                }
                $scope.showModal('addInternalUser', 'sm', special, function () {
                    $scope.search();
                }, function () {
                    $scope.search();
                });
            };
            $scope.searchInternalUser = function(){
                scope.initPage($scope, employeeService.listInternalUser);
            };

            var init = function () {
                $scope.userId = [];
                $scope.m = {userId: []};
                $scope.q = {key:''};
                scope.initPage($scope, employeeService.listInternalUser);
                scope.initCheckList($scope);
            };

            init();
        }])
    .controller('addInternalUser-modal-ctrl', ['$scope', '$uibModalInstance', 'special', 'employeeService', function ($scope, $uibModalInstance, special, employeeService) {
        $scope.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };

        $scope.ok = function () {
            if (!$scope.m.realName) {
                dialogUtils.showTip("员工名称不能为空");
            } else if (!$scope.m.phone) {
                dialogUtils.showTip("手机号不能为空");
            } else {
                if (special.userId) {
                    employeeService.updateInternalUser($scope.m, function () {
                        $uibModalInstance.close();
                    });
                } else {
                    if (!$scope.m.password) {
                        dialogUtils.showTip("密码不能为空");
                    } else {
                        employeeService.saveInternalUser($scope.m, function () {
                            $uibModalInstance.close();
                        });
                    }
                }
            }
        };

        var init = function () {
            $scope.m={};
            if(special){
                $scope.m = special;
            }

        };
        init();

    }])

    .controller('addRoleToUser-modal-ctrl', ['$scope', '$uibModalInstance', 'special', 'employeeService',
        function ($scope, $uibModalInstance, special, employeeService) {

            $scope.cancel = function () {
                $uibModalInstance.dismiss('cancel');
            };

            $scope.ok = function () {
                employeeService.addRoleToUsers($scope.m, function () {
                    $uibModalInstance.close();
                });
            };

            var init = function () {
                $scope.m = {userId: special.userId};
                employeeService.listRoles(function (res) {
                    $scope.listRoles = res;
                    if(special.roleId[0] !== 1 && special.roleId.length === 1) {
                        $scope.m.roleId = special.roleId[0] + '';
                    }else {
                        $scope.m.roleId = $scope.listRoles[0].roleId + '';
                    }
                });
            };
            init();

        }])
;

