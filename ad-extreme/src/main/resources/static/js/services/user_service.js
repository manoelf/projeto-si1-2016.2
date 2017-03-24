/**
 * Created by matth on 22/03/2017.
 */

App.factory('UserService', ['$http', '$q', function($http, $q) {
return {

    getUser: function (user) {
        return $http.get('http://localhost:8080/registerUser', user)
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

    createUser: function (user) {
        return $http.post('http://localhost:8080/registerUser', user)
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

    /*updateUser: function (user) {
        return $http.put('http://localhost:8080/user/', user)
            .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while updating user');
                    return $q.reject(errResponse);
                }
            );
    }*/
}
}]);