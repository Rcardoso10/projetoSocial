angular.module("app").factory("pessoaService", function ($http, defaultUrl) {

    var _getPessoas = function () {
        return $http.get(defaultUrl.getServerUrl() + "/pessoas");
    };

    var _savePessoas = function (pessoa) {
        return $http.post(defaultUrl.getServerUrl() + "/pessoas", pessoa);
    };

    var _updatePessoas =  function (pessoa) {
        return $http.put(defaultUrl.getServerUrl() + "pessoas" + "/" + pessoa.id, pessoa);
    };

    var _deletePessoas = function (pessoa) {
        return $http.delete(defaultUrl.getServerUrl() + "/pessoas" + "/" + pessoa.id, pessoa );
    };

    return{
        getPessoas : _getPessoas,
        savePessoas : _savePessoas,
        updatePessoas : _updatePessoas,
        deletepessoas : _deletePessoas
    };
});