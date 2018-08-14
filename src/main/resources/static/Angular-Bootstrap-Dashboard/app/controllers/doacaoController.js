angular.module("app").controller("doacaoController", function ($scope, doacaoService) {

    var listar  =  function () {
        doacaoService.getDoacao().success(function (data) {
           $scope.doacao = data;
        }).error(function (data,status) {
            alert("Erro ao procurar por doações!");
        });
    };

    $scope.save = function () {
      doacaoService.saveDoacao($scope.doacao).success(function (data) {
          $scope.limpar();
          $scope.changeToList();
      });
    };


    $scope.limpar = function () {
        delete $scope.doacao;
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