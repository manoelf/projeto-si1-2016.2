/**
 * Created by matth on 22/03/2017.
 */


$http({method: "GET", url: "http://localhost:8080/registerUser"}).then(function (response) {

    $scope.userList = response.data;

}, function (response) {

    console.log(response.data);
    console.log(response.status);

});


$scope.saveUser = function (user) {

    $http({method: "POST", url: "http://localhost:8080/registerUser"}).then(function (response) {

        $scope.listaDeTarefasSelecionada.tarefas.push(response.data);

    }, function (response) {

        console.log(response.data);
        console.log(response.status);

    });
}