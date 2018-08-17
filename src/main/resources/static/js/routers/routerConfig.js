angular.module("app").config(function ($routeProvider) {

    $routeProvider.when("/doacao/:id",{
        controller : "doacaoController",
        templateUrl : "view/doacao.html"
    })
        .when("/campanha",{
            controller : "campanhaController",
            templateUrl : "view/campanha.html"
        })

        .when("/pessoas",{
            controller : "pessoaController",
            templateUrl : "view/pessoa.html"
        })


        .otherwise({redirectTo: "/dashboard"});
});