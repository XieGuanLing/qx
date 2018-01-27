/**
 * Created by somebody on 2017/7/31.
 */
angular.module('c.exception', [])
    .controller('exception-logs-ctrl', ['$scope', '$uibModal', '$stateParams', 'exceptionLogService',
        function ($scope, $uibModal, $stateParams, exceptionLogService) {

            $scope.timeChange = function (modelName, newDate) {
                $scope.q[modelName] = newDate.format('YYYY-MM-DD HH:mm:ss');
            };

            $scope.resolved = function (exception) {
                scope.initModal2($uibModal, 'resolved', 'sm', null, function (res) {
                    exception.remark = res;
                    exceptionLogService.resolve(exception, function () {
                        dialogUtils.showTip('success');
                        init();
                    })
                })
            };

            $scope.detail = function (i) {
                scope.initModal2($uibModal, 'exception-log', 'lg', i);
            };

            function init() {
                $scope.q = {
                    sortCondition : 'lastTime' ,
                    sort : '-1'
                };
                $.extend($scope.q, $stateParams);
                scope.initPage($scope, exceptionLogService.query);
            }

            init();

        }])

    .controller('resolved-modal-ctrl', ['$scope', '$uibModalInstance',
        function ($scope, $uibModalInstance) {
            scope.initModalButton($scope, $uibModalInstance, function () {
                return $scope.remark;
            })
        }])

    .controller('exception-log-modal-ctrl', ['$scope', '$uibModalInstance', 'special',
        function ($scope, $uibModalInstance, special) {
            $scope.exception = special ;
            scope.initModalButton($scope, $uibModalInstance);
        }])


;


