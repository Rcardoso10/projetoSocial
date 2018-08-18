angular.module("app").config(function ($routeProvider) {

    $routeProvider.when("/doacao/:id/:cpf",{
        controller : "doacaoController",
        templateUrl : "view/doacao.html"
    })
        .when("/pessoas/list", {
            controller : "pessoaController",
            templateUrl : "view/listPessoas.html"
        })

        .when("/doacao/list",{
            controller : "doacaoController",
            templateUrl : "view/listaDoacao.html"
        })

        .when("/campanha",{
            controller : "campanhaController",
            templateUrl : "view/campanha.html"
        })

        .when("/pessoas",{
            controller : "pessoaController",
            templateUrl : "view/pessoa.html"
        })


        .otherwise({redirectTo: "/campanha"});
});