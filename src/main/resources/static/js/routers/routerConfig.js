angular.module("app").config(function ($routeProvider) {

    $routeProvider.when("/doacao",{
        controller : "doacaoController",
        templateUrl : "view/doacao.html"
    })

        .when("/dashboard",{
            controller: "dashboardController",
            templateUrl: "view/dashboard.html"
        })

        .otherwise({redirectTo: "/dashboard"});
});