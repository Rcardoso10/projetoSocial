angular.module("app").controller("doacaoController", function ($scope, doacaoService) {

    $scope.doacao = {};

    var listar =  function () {
        doacaoService.getDoacao().success(function (data) {
            $scope.doacao =  data;
        }).error(function (data,status) {
            alert("Erro ao buscar por doações, culpa do Luis!");
        });
    };

    var save =  function () {
        doacaoService.saveDoacao().success(function (data) {
            $scope.limpar();
            $scope.changeToList();
        });
    };

    $scope.limpar = function () {
        delete $scope.doacao;
    };

    $scope.changeToList = function () {
        listar();
    };


});