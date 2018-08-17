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
            $scope.buscaId(pessoa);
            $scope.limpar();
            $location.path("/doacao/" + pessoanova.id);
        });

    };

    $scope.buscaId = function(){
        pessoaService.findById($scope.pessoa).success(function (data) {
            $scope.pessoanova = data;
        }).error(function (data,status) {
            alert("Id não encontrado!");
        });
    };

    $scope.limpar = function () {
        delete $scope.pessoa;
    };

    $scope.onInit = function () {
        $scope.pessoa.campanha = $rootScope.campanha.id;
        listar();
    };

    $scope.back = function () {
        $location.path('/campanha');
    };

    $scope.onInit();

});