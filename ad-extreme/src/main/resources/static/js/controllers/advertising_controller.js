/**
 * Created by gersonsales on 21/03/17.
 */

app.controller('AdvertisingController', ['$scope', 'AdvertisingService', function ($scope, AdvertisingService) {
    $scope.app = "Ad Extreme";

    var self = this;
    self.advertisement = {id: null, title: null, price: null, type: null};
    self.nullAdvertisementForm = {id: null, title: null, price: null };
    self.advertisements = [];

    self.fetchAllAdvertisements = function () {
        console.log("fetchAllAdvertisements()");
        AdvertisingService.fetchAllAdvertisements().then(
            function (advertisements) {
                self.advertisements = advertisements;

            },
            function (errorResponse) {
                console.error('Error while fetching advertisements.');
            }
        )

    };

    self.createAdvertisement = function (advertisementForm) {
        AdvertisingService.createAdvertisement(advertisementForm).then(
            self.fetchAllAdvertisements,
            function (errorResponse) {
                console.error("Error while creating advertisement.")
            }
        )
    };

    self.updateAdvertisement = function (advertisement) {
        AdvertisingService.updateAdvertisement(advertisement).then(
            self.fetchAllAdvertisements,
            function (errorResponse) {
                console.error("Error while updating advertisement ", advertisement.id);
            }
        )
    };

    self.submit = function () {
        if (self.advertisement.id == null) {
            self.createAdvertisement(self.advertisement);
            console.log("Saving new advertisement", self.advertisement);
            self.advertisement = self.nullAdvertisementForm;
        }else {
            self.updateAdvertisement(self.advertisement);
            console.log("'Advertisement update with id'", self.advertisement.id);
        }
    };

    self.delete = function (id) {
        console.log("Id to be deleted", id);
        AdvertisingService.deleteAdvertisement(id).then(
            self.fetchAllAdvertisements,
            function (errorResponse) {
                console.error("Error while deleting user.")
            }
        )
    };

    self.get = function (id) {
        console.log("Getting advertisement", id);
        AdvertisingService.getAdvertisement(id).then(
            self.fetchAllAdvertisements,
            function (errorResponse) {
                console.error("Error while getting advertisement.")

            }
        )
    }





}]);