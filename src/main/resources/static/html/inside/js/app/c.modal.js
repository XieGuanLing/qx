angular.module('c.modal',[])
    .controller('money-modal-ctrl', ['$scope', '$uibModalInstance', 'special' , function ($scope, $uibModalInstance, special) {
        $scope.m = special;
        if($scope.m.paid ){
        $scope.m.paid = parseFloat($scope.m.paid).toFixed(2);
        }
        scope.initModalButton($scope, $uibModalInstance, function () {
            if(!$scope.m.discount){
                $scope.m.discount = 0;
            }
            return $scope.m;
        });

        $scope.discountChange = function () {
            if($scope.m.discount&&($scope.m.discount!=0 )){
                $scope.m.paid = ($scope.m.total*$scope.m.discount*0.1).toFixed(2);
            }else{
                $scope.m.paid = $scope.m.total;
            }
        };

        $scope.paidChange = function () {
            $scope.m.discount = ($scope.m.paid/$scope.m.total*10).toFixed(2);
        };


    }])
    .controller('print-modal-ctrl', ['$scope', '$uibModalInstance', 'special' , function ($scope, $uibModalInstance, special) {
        scope.initModalInstance($scope, $uibModalInstance);
        $scope.print = function () {
            $uibModalInstance.close();
            window.open(special);
        };

    }])
    .controller('tip-modal-ctrl', ['$scope', '$uibModalInstance', 'special' , function ($scope, $uibModalInstance, special) {
        $scope.tip = special.tip;
        scope.initModalInstance($scope, $uibModalInstance);

    }]);