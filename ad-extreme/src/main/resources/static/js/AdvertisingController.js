/**
 * Created by matth on 19/03/2017.
 */

appADExtreme.controller ("AdvertisingRegisterCtrl", function($scope, $http){
    $scope.advertisingList = [];

    $http({method: "POST", url: "ad/list/advertising"}).then(function (response) {

        $scope.advertisingList = response.data;

    }, function (response) {

        console.log(response.data);
        console.log(response.status);

    });

    $scope.saveAdvertising = function (advertising) {


        $http({method: "POST", url: "ad/add/advertising"}).then(function (response) {

            $scope.advertisingList.push(response.data)

        }, function (response) {

            console.log(response.data);
            console.log(response.status);

        });
    }


});