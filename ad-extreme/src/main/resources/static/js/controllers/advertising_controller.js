/**
 * Created by gersonsales on 21/03/17.
 */

app.controller('AdvertisingController', ['$scope', 'AdvertisingService', function ($scope, AdvertisingService) {
    $scope.app = "Ad Extreme";

    var self = this;
    self.advertisements = [];

    self.fetchAllAdvertisements = function () {
        AdvertisingService.fetchAllAdvertisements().then(
            function (advertisements) {
                self.advertisements = advertisements;
            },
            function (errorResponse) {
                console.error('Error while fetching advertisements.');
            }
        )

    };

    self.createAdvertisement = function (advertisingForm) {
        AdvertisingService.createAdvertisement(advertisingForm).then(
            self.fetchAllAdvertisements(),
            function (errorResponse) {
                console.error("Error while creating advertisement.")
            }
        )
    }





}]);