angular.module("app").factory("campanhaService", function ($http, defaultUrl) {

   var _getCampanha =  function () {
     return $http.get(defaultUrl.getServerUrl() + "/campanha") ;
   };

   var _savecampanha =  function (campanha) {
       return $http.post(defaultUrl.getServerUrl() + "/campanha", campanha);
   };

   var _updateCampanha = function (campanha) {
       return $http.put(defaultUrl.getServerUrl() + "/campanha" + "/" + campanha.id, campanha);
   };

   var _deleteCampanha =  function (campanha) {
       return $http.delete(defaultUrl.getServerUrl() + "/campanha" + "/" + campanha.id, campanha);
   };

   return{
       getCampanha : _getCampanha,
       saveCampanha : _savecampanha,
       updateCampanha : _updateCampanha,
       deleteCampanha : _deleteCampanha
   };

});