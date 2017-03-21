/**
 * Created by matth on 21/03/2017.
 */

appADExtreme.factory("userService", ["$http", $q, function($http, $q)
{
    $http({method: "GET", url: "http://localhost:8080/registerUser"}).then(function (response) {

        $scope.userList = response.data;

    },function(errResponse){
        console.error('Error while fetching users');
        return $q.reject(errResponse);
    });


    $scope.saveUser = function (user) {

        $http({method: "POST", url: "http://localhost:8080/registerUser", data: user}).then(function (response) {
            return response.data;

        }, function(errResponse){
            console.error('Error while creating user');
            return $q.reject(errResponse);
        });
    };
}]);