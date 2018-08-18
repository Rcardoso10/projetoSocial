angular.module("app").factory("campanhaService", function ($http, defaultUrl) {

    var _getCampanha =  function () {
        return $http.get(defaultUrl.getServerUrl() + "/campanha");
    };

    var _saveCampanha =  function (campanha) {
        return $http.post(defaultUrl.getServerUrl() + "/campanha", campanha);
    };

    var _updateCampanha =  function (campanha) {
        return $http.put(defaultUrl.getServerUrl() + "/campanha" + "/" + campanha.id, campanha);
    };

    var _buscaCampanhaById =  function (id) {
        return $http.get(defaultUrl.getServerUrl() + "/campanha" + "/" + id);
    };

    var _deleteCampanha  = function (campanha) {
        return $http.delete(defaultUrl.getServerUrl() + "/campanha" + "/" + campanha.id,campanha);
    };

    return{
        getCampanha : _getCampanha,
        saveCampanha : _saveCampanha,
        updateCampanha : _updateCampanha,
        deleteCampanha : _deleteCampanha,
        buscaCampanhaById : _buscaCampanhaById
    };

});