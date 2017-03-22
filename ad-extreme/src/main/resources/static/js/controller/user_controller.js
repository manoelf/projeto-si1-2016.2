/**
 * Created by matth on 19/03/2017.
 */

appADExtreme.controller ("userController", ["$scope", "userService",function($scope, userService){

    $scope.userList = [];


    $scope.createUser = function(user){
        userService.createUser(user)
            .then(
                function(errResponse){
                    console.error('Error while creating User.');
                }
            );
    };

}]);
