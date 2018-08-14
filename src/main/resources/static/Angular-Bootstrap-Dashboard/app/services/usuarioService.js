angular.module("app").factory("usuarioService", function ($http, defaultUrl) {

    var _getUsuario = function () {
        return $http.get(defaultUrl.getServerUrl() + "/usuarios");
    };

    var _saveUsuario = function (usuario) {
        return $http.post(defaultUrl.getServerUrl() + "/usuarios", usuario);
    };

    var _updateUsuario = function (usuario) {
        return $http.put(defaultUrl.getServerUrl() + "/usuarios" + "/" + usuario.id, usuario);
    };

    var _deleteUsuario =  function (usuario) {
        return $http.delete(defaultUrl.getServerUrl() + "/usuarios" + "/" + usuario.id, usuario);
    };

    return{
        getUsuario : _getUsuario,
        saveUsuario : _saveUsuario,
        updateUsuario : _updateUsuario,
        deleteUsuario : _deleteUsuario
    };

});