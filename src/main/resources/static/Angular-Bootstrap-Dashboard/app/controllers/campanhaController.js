angular.module("app").controller("campanhaController", function ($scope, campanhaService) {

    var listar = function () {
        campanhaService.getCampanha().success(function (data) {
            $scope.campanha = data;
        }).error(function (data,status) {
           alert(("Erro ao buscar por campanhas, Culpa do Luis!"));
        });
    };

    $scope.save = function () {
        campanhaService.saveCampanha($scope.campanha).success(function (data) {
            $scope.limpar();
            $scope.changeToList();
        });
    };


    $scope.limpar = function () {
        delete $scope.campanha;
    };


    $scope.changeToList = function () {
        listar();
        $scope.registrar = false;
        $scope.listar = true;
        $scope.editar = false;

        $scope.titulo = "LISTAGEM";
    };

    $scope.changeToList();
});