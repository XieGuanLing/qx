/**
 * Created by lihaodi on 2016/7/20.
 */
angular.module('internal-login', ['services-base','services-data-transform'])
    .controller('login-ctrl', ['$scope', 'dataTransformService', function ($scope, dataTransformService) {
        $scope.login = function () {
            if(!$scope.user){
                dialogUtils.showTip('请输入用户名');
                return;
            }
            if(!$scope.password){
                dialogUtils.showTip('请输入密码');
                return;
            }
            var loginSuccess = function (res) {
                localStorage.setItem('isManager',res.isManager);
                localStorage.setItem('internalRealName', res.realName);
                localStorage.setItem('internalAuthCode', res.code);
                localStorage.setItem('phone', res.phone);
                window.location = './container.html';

            };
            dataTransformService.loginInternal($scope.user, $scope.password, loginSuccess);
        };

        initKeyPress($scope.login);
    }
]);
