angular.module('services-base', [])
    .factory('httpService', function($http) {
        return {
            handleBusinessError : function (res, error) {
                if(res.code==403){
                    var okCb = function(){
                        window.location = './login.html';
                    };
                    dialogUtils.autoCloseTip(res.msg, okCb);
                    return;
                }
                if(error){
                    error();
                }else{
                    dialogUtils.showTipAndNotCloseCurrent(res.msg);
                }
            },
            handleError: function (res, status, headers, config) {
                if(status=='-1'){
                    dialogUtils.showTipAndCloseCurrent('网络异常, 请检查网络');
                    return;
                }
                if(res.msg){
                    dialogUtils.showTip(res.msg);
                    return;
                }
                dialogUtils.showSysError();

            },
            postWithStringify  : function (url, data){
                return $http({
                    method: 'POST',
                    url: url,
                    data: JSON.stringify(data),
                    headers: {'Content-Type': 'application/json'}
                });
            },
            putWithStringify  : function (url, data){
                return $http({
                    method: 'PUT',
                    url: url,
                    data: JSON.stringify(data),
                    headers: {'Content-Type': 'application/json'}
                });
            },

            post  : function (isLoading, url, data, success, error){
                var that = this;
                var loading;
                if(isLoading){
                    loading = dialogUtils.getLoadingDialog();
                    loading.show();
                }
                this.postWithStringify(url, data).success(function(res, status, headers, config){
                    if(isLoading){
                        loading.close().remove();
                    }
                    if(res.success){
                        if(success){
                            success(res.resultObject);
                        }else{
                            dialogUtils.showTip('操作成功');
                        }
                    }else{
                        that.handleBusinessError(res, error);
                    }

                }).error(function(res, status, headers, config){
                    if(isLoading){
                        loading.close().remove();
                    }
                    that.handleError(res, status, headers, config);
                });
            },
            put  : function (isLoading, url, data, success, error){
                var that = this;
                var loading;
                if(isLoading){
                    loading = dialogUtils.getLoadingDialog();
                    loading.show();
                }
                this.putWithStringify(url, data).success(function(res, status, headers, config){
                    if(isLoading){
                        loading.close().remove();
                    }
                    if(res.success){
                        if(success){
                            success(res.resultObject);
                        }else{
                            dialogUtils.showTip('操作成功');
                        }
                    }else{
                        that.handleBusinessError(res, error);
                    }

                }).error(function(res, status, headers, config){
                    if(isLoading){
                        loading.close().remove();
                    }
                    that.handleError(res, status, headers, config);
                });
            },

            post2Object : function (isLoading, url, data, $scope, object, error) {
                var that = this;
                var loading;
                if(isLoading){
                    loading = dialogUtils.getLoadingDialog();
                    loading.show();
                }

                var success = function (res) {
                    if(res.resultObject && res.resultObject.rows){
                        $scope[object] = res.resultObject.rows;
                    }else{
                        if($scope && object){
                            $scope[object] = res.resultObject;
                        }
                    }
                };
                this.postWithStringify(url, data).success(function(res, status, headers, config){
                    if(isLoading){
                        loading.close().remove();
                    }
                    if(res.success){
                        success(res);
                    }else{
                        that.handleBusinessError(res, error);
                    }

                }).error(function(res, status, headers, config){
                    if(isLoading){
                        loading.close().remove();
                    }
                    that.handleError(res, status, headers, config);

                });
            },
        };
    });