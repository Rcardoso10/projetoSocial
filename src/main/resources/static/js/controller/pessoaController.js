angular.module("app").controller("pessoaController", function ($scope, pessoaService, $location, $rootScope) {

    $scope.pessoa = {};

    var listar = function () {
        pessoaService.getPessoas().success(function (data) {
            $scope.pessoas = data;
        }).error(function (data,status) {
            alert("Erro ao buscar por pessoas!");
        });
    };


    $scope.save = function (pessoa) {
        pessoaService.savePessoa($scope.pessoa).success(function () {
            $scope.limpar();
            $location.path("/doacao/"+ pessoa.campanha + "/" + pessoa.cpf );
        });

    };

    $scope.limpar = function () {
        delete $scope.pessoa;
    };

    $scope.onInit = function () {
        $scope.pessoa.campanha = $rootScope.campanha.id;
    };

    $scope.back = function () {
        $location.path('/campanha');
    };

    listar();
    //$scope.onInit();

});