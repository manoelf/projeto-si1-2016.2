/**
 * Created by matth on 19/03/2017.
 */

app.controller('userController', ['$scope', 'UserService', function($scope, UserService) {
    $scope.app = "Ad Extreme";
    var self = this;
    self.user = {id: null, name: null, email: null, password: null, repeatedPassword: null, personType: null};
    self.users = [];

    self.fetchAllUsers = function () {
        UserService.fetchAllUsers().then (
            function (users) {
                self.users = users;
            },
            function (errorResponse) {
                console.error();
            }
        )
    };

    self.createUser = function(userForm){
        UserService.createUser(userForm)
            .then(self.fetchAllUsers(),
                 function(errResponse){
                    console.error('Error while creating User.');
                }
            );
    };

    self.updateUser = function(user, id){
        UserService.updateUser(user, id)
            .then(self.fetchAllUsers,
                function(errResponse){
                    console.error('Error while updating User.');
                }
            );
    };

    self.submit = function () {
        if (self.user.id == null) {
            console.log("Saving new user", self.user);
            self.createUser(self.user);
        }else {
            self.updateUser(self.user, id);
            console.log("User updated with id ", self.user.id);
        }

        self.reset();

    };

    self.reset = function () {
        console.log("Resetting the user form.");
        self.user = {id: null, name: null, email: null, password: null, repeatedPassword: null, personType: null};
        $scope.userForm.$setPristine();
    };

    self.getUser = function (id) {
        console.log("Getting user ", id);
        UserService.getUser(id).then (
            self.fetchAllUsers(),
                function (errorResponse) {
                    console.error("Error while getting user");
                }
            );

    };

    /* When the user clicks on the button,
     toggle between hiding and showing the dropdown content */
    function dropMainFunction() {
        document.getElementById("myDropdown").classList.toggle("show");
    }

    // Close the dropdown if the user clicks outside of it
    window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {

            var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    }


}]);
