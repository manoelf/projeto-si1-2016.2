/**
 * Created by gersonsales on 21/03/17.
 */

app.controller('AdvertisingController', ['$scope', 'AdvertisingService', function ($scope, AdvertisingService) {

    var self = this;
    self.advertisements = [{text: "learn Angularjs", done: false, favorite: false},
        {text: "learn html", done: false, favorite: false},
        {text: "learn css", done: false, favorite: false}];

    self.fetchAllAdvertisements = function () {
        AdvertisingService.fetchAllAdvertisements().then(
            function (advertisements) {
                self.advertisements = advertisements;
            },
            function (errorResponse) {
                console.error('Error while fetching advertisements.');
            }
        )

    }



}]);