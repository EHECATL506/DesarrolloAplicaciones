var app = angular.module('Video_Juegos', []);
app.controller('comprasController', function ($scope, $http, $filter, $location) {

    $scope.currentUrl = $location.absUrl().split('//')[1];
    $scope.currentUrl = $scope.currentUrl.split("/")[0];

    $scope.indiceSeleccionado = 0;
    $scope.seleccionar = function (e) {
        $scope.indiceSeleccionado = e.idcompra;
    };
    var elemento = $filter('filter')($scope.videojuegos, {id: $scope.indiceSeleccionado}, true);



    obtenerInformacion();
    function obtenerInformacion() {
        $http.get("http://" + $scope.currentUrl + "/TiendaGames4U/webresources/modelo.compra")
                .then(function (response) {
                    $scope.compras = response.data;
                });
        $http.get("http://" + $scope.currentUrl + "/TiendaGames4U/webresources/modelo.videojuego")
                .then(function (response) {
                    $scope.videojuegos = response.data;
                });
        $scope.tablaCompras = mergeRecursive($scope.compras, $scope.videojuegos);


    }
    ;
    mergeRecursive();
    function mergeRecursive(obj1, obj2) {
        //iterate over all the properties in the object which is being consumed
        for (var p in obj2) {
            // Property in destination object set; update its value.
            if (obj2.hasOwnProperty(p) && typeof obj1[p] !== "undefined") {
                mergeRecursive(obj1[p], obj2[p]);

            } else {
                //We don't have that level in the heirarchy so add it
                obj1[p] = obj2[p];

            }
            ;
        }
        ;
    }
    ;




});