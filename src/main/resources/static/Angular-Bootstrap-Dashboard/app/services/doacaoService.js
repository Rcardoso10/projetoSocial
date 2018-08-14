angular.module("app").factory("doacaoService", function ($http, defaultUrl) {

    var _getDoacao =  function () {
        return $http.get(defaultUrl.getServerUrl() + "/doacao");
    };

    var _saveDoacao = function (doacao) {
        return $http.post(defaultUrl.getServerUrl() + "/doacao", doacao);
    };

    var updateDoacao = function (doacao) {
        return $http.put(defaultUrl.getServerUrl() + "/doacao" + "/" + doacao.id, doacao);
    };

    var deleteDoacao = function (doacao) {
        return $http.delete(defaultUrl.getServerUrl() + "/doacao" + "/" +  doacao.id, doacao);
    };

    return{
        getDoacao : _getDoacao,
        saveDoacao : _saveDoacao,
        updateDoacao : updateDoacao,
        deleteDoacao : deleteDoacao
    };

});