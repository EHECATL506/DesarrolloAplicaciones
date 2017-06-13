var app = angular.module('Video_Juegos', []);
app.controller('ventaController', function ($scope, $http, $filter, $location) {
   
    $scope.currentUrl = $location.absUrl().split('//')[1];
    $scope.currentUrl = $scope.currentUrl.split("/")[0];

    $scope.indiceSeleccionado = 0;
    $scope.seleccionar = function (e) {
        $scope.indiceSeleccionado = e.idventa;
    };
    var elemento = $filter('filter')($scope.videojuegos, {id: $scope.indiceSeleccionado}, true);

   

    obtenerInformacion();
    function obtenerInformacion() {
         $http.get("http://" + $scope.currentUrl + "/TiendaGames4U/webresources/modelo.venta")
            .then(function (response) {
                $scope.ventas = response.data;
            });

    };

    
});
