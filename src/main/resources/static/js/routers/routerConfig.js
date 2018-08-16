angular.module("app").config(function ($routeProvider) {

    $routeProvider.when("/doacao",{
        controller : "doacaoController",
        templateUrl : "view/doacao.html"
    })
        .when("/campanha",{
            controller : "campanhaController",
            templateUrl : "view/campanha.html"
        })

        .when("/campanha/participar",{
            controller : "campanhaController",
            templateUrl : "view/campanhaParticipar.html"
        })

        .when("/dashboard",{
            controller: "dashboardController",
            templateUrl: "view/dashboard.html"
        })

        .otherwise({redirectTo: "/dashboard"});
});