angular.module("app").config(function ($routeProvider) {

    $routeProvider.when("/doacao",{
        controller : "doacaoController",
        templateUrl : "view/doacao.html"
    })

        .when("/campanha",{
            controller : "campanhaController",
            templateUrl : "view/campanha.html"
        })

        .when("/usuarios",{
            controller : "usuarioController",
            templateUrl : "view/usuario.html"
        })

        .when("/dashboard",{
            controller: "dashboardController",
            templateUrl: "view/dashboard.html"
        })

        .otherwise({redirectTo: "/"});

});


