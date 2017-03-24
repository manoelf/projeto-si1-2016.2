/**
 * Created by matth on 19/03/2017.
 */

app.controller('userController', ['$scope', 'userService', function($scope, userService) {
    $scope.app = "Ad Extreme";
    $scope.userList = [];

    var self = this;

    self.createUser = function(user){
        userService.createUser(user)
            .then(

                 function(errResponse){
                    console.error('Error while creating User.');
                }
            );
    };

    self.updateUser = function(user, id){
        UserService.updateUser(user, id)
            .then(
                function(errResponse){
                    console.error('Error while updating User.');
                }
            );
    };


}]);
