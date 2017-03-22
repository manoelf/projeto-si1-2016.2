/**
 * Created by gersonsales on 21/03/17.
 */

app.factory('AdvertisingService', ['$http', '$q', function ($http, $q) {
    return {
        fetchAllAdvertisements: function () {
            return $http.get('http://localhost:8080/').then(
                function (response) {
                    return response.data;
                },
                function (errorResponse) {
                    console.error('Error while fetching advertisements');
                    return $q.reject(errorResponse);
                }
            )
        }
    }
}])