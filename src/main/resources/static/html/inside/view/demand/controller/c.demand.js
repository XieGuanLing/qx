angular.module('c.demand', [])

    .controller('demand-list-ctrl', ['$scope', '$stateParams',
        function ($scope, $stateParams) {
            $scope.showNewDemandModal = function(){
                $scope.showModal('new-demand', '', {}, function () {

                })
            }
            ;
        }
    ])
    .controller('new-demand-modal-ctrl', ['$scope', '$uibModal',
        function ($scope, $uibModal) {

        }
    ])
    .controller('demand-record-ctrl', ['$scope', '$stateParams',
        function ($scope, $stateParams) {
            $scope.showNewRecordModal = function(){
                $scope.showModal('new-record', '', {}, function () {

                })
            }
            ;
        }
    ])
    .controller('new-record-modal-ctrl', ['$scope', '$uibModal',
        function ($scope, $uibModal) {

        }
    ])
