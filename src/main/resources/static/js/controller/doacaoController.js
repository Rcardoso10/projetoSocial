angular.module("app").controller("doacaoController", function ($scope, doacaoService, $location, $routeParams) {

    var id = $routeParams.id;

    $scope.doacao = {};

    var listar =  function () {
        doacaoService.getDoacao().success(function (data) {
            $scope.doacao =  data;
        }).error(function (data,status) {
            alert("Erro ao buscar por doações, culpa do Luis!");
        });
    };

    $scope.save =  function (doacao) {
        $scope.doacao.pessoa = id;
        $scope.doacao.campanha = $rootScope.campanha.id;
        doacaoService.saveDoacao($scope.doacao).success(function (data) {
            $scope.limpar();
            $scope.changeToList();
            $location.path("/campanha");
        });
    };

    $scope.limpar = function () {
        delete $scope.doacao;
    };

    $scope.onInit = function () {
        $scope.doacao.campanha = $rootScope.campanha.id;
        listar();
    };

    $scope.onInit();
});