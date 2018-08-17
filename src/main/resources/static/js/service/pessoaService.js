angular.module("app").factory("pessoaService", function ($http, defaultUrl) {

    var _getPessoas = function () {
        return $http.get(defaultUrl.getServerUrl() + "/pessoas");
    };

    var _savePessoa = function (pessoa) {
        return $http.post(defaultUrl.getServerUrl() + "/pessoas", pessoa);
    };

    var _findById = function (pessoa) {
        return $http.get(defaultUrl.getServerUrl() + "/pessoas" + "/" + pessoa.cpf, pessoa);
    };

    var _updatePessoa = function (pessoa) {
        return $http.put(defaultUrl.getServerUrl() + "/pessoas" + "/", pessoa.id, pessoa);
    };

    var _deletePessoa = function (pessoa) {
        return $http.delete(defaultUrl.getServerUrl() + "/pessoas" + "/" + pessoa.id, pessoa);
    };

    return{
        getPessoas : _getPessoas,
        savePessoa : _savePessoa,
        updatePessoa : _updatePessoa,
        deletePessoa : _deletePessoa,
        findById : _findById
    };

});