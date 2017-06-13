var app = angular.module('Video_Juegos', []);
app.controller('comprasController', function ($scope, $http, $filter, $location) {
   
    $scope.currentUrl = $location.absUrl().split('//')[1];
    $scope.currentUrl = $scope.currentUrl.split("/")[0];

    $scope.indiceSeleccionado = 0;
    $scope.seleccionar = function (e) {
        $scope.indiceSeleccionado = e.id;
    };

   

    obtenerInformacion();
    function obtenerInformacion() {
         $http.get("http://" + $scope.currentUrl + "/TiendaGames4U/webresources/modelo.videojuego")
            .then(function (response) {
                $scope.videojuegos = response.data;
            });

    }

    
});