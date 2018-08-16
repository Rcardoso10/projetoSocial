angular.module("app").controller("campanhaController", function ($scope, campanhaService) {

    $scope.campanha = {};

    var listar = function () {
        campanhaService.getCampanha().success(function (data) {
            $scope.campanhas =  data;
        }).error(function (data,status) {
            alert("Erro ao buscar por campanhas, culpa do Luis!");
        });
    };

    var save = function () {
        campanhaService.saveCampanha($scope.campanha).success(function (data) {
            $scope.limpar();
            $scope.changeToList();
        });
    };

    var update  = function(){
        campanhaService.updateCampanha($scope.campanha).success(function (data) {
            $scope.limpar();
            $scope.changeToList();
        });
    };

    $scope.limpar = function () {
        delete $scope.campanha;
    };

    $scope.changeToList =  function () {
        listar();
    };

    $scope.back = function () {
        $location.path('/campanha');
    };

    $scope.changeToList();
});