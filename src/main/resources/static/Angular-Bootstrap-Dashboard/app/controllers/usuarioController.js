angular.module("app").controller("usuarioController", function ($scope, usuarioService) {

    var listar =  function () {
        usuarioService.getUsuario().success(function (data) {
           $scope.usuarios = data;
        }).error(function (data,status) {
            alert("Erro ao buscar por usuarios, culpa do Luis!");
        });
    };

    $scope.save = function(){
      usuarioService.saveUsuario($scope.usuarios).success(function (data) {
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