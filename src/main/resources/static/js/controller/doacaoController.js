angular.module("app").controller("doacaoController", function ($scope, doacaoService, $location, $routeParams,
                                                               pessoaService, campanhaService) {

    //$scope.doacao = {};

    var id = $routeParams.id;
    var cpf = $routeParams.cpf;

    var listaObj = function () {

        pessoaService.findByCpf(cpf).success(function (data) {
            $scope.pessoa = data;
        }).error(function (data) {
            alert("Erro ao buscar os pessoas!");
        });

        campanhaService.buscaCampanhaById(id).success(function (data) {
            $scope.campanha = data;
        }).error(function (data) {
           // alert("Erro ao buscar por campanhas!");
        });
    };

    var listar =  function () {
        doacaoService.getDoacao().success(function (data) {
            $scope.doacoes =  data;
        }).error(function (data,status) {
            alert("Erro ao buscar por doações, culpa do Luis!");
        });
    };

    $scope.save =  function (doacao) {

        $scope.doacao.pessoa = $scope.pessoa;
        $scope.doacao.campanha = $scope.campanha;
        doacaoService.saveDoacao($scope.doacao).success(function () {
            $scope.limpar();
        });
        $location.path("/campanha");
    };

    $scope.limpar = function () {
        delete $scope.doacao;
    };

    $scope.onInit = function () {
        listar();
    };

    listaObj();
    $scope.onInit();
});