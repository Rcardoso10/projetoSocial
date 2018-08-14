angular.module("app").controller("pessoaController", function ($scope, pessoaService) {

    var listar =  function () {
        pessoaService.getPessoas().success(function (data) {
            $scope.pessoas = data;
        }).error(function (data,status) {
            alert("Erro ao buscar por pessoas, culpa do Luis!");
        });
    };

    $scope.save = function(){
        pessoaService.savePessoas($scope.pessoas).success(function (data) {
            $scope.limpar();
            $scope.changeToList();
        });
    };

    $scope.limpar = function () {
        delete $scope.pessoas;
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