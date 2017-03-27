/**
 * Created by matth on 22/03/2017.
 */

app.factory('UserService', ['$http', '$q', function($http, $q) {
return {

    fetchAllUsers: function () {
        return $http.get('http://localhost:8080/user/').then (
            function (response) {
                return response.data;
            },
            function (errorResponse) {
                console.error("Error while fetching users.");
                return $q.reject(errorResponse);
            }
        )

    },

    getUser: function (user) {
        return $http.get('http://localhost:8080/user' + id, user)
            .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while searching user');
                    return $q.reject(errResponse);
                }
            );
    },

    createUser: function (userForm) {
        console.log("User form" + userForm + "has arrived in service.");
        return $http.post('http://localhost:8080/register/', userForm)
            .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while creating user');
                    return $q.reject(errResponse);
                }
            );
    }

}
}]);