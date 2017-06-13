var app = angular.module('Video_Juegos', []);
app.controller('videojuegosController', function ($scope, $http, $filter, $location) {
    $scope.currentUrl = $location.absUrl().split('//')[1];
    $scope.currentUrl = $scope.currentUrl.split("/")[0];

    $scope.indiceSeleccionado = 0;
    $scope.seleccionar = function (e) {
        $scope.indiceSeleccionado = e.idvideojuego;
    };
    var elemento = $filter('filter')($scope.videojuegos, {id: $scope.indiceSeleccionado}, true);


    $http.get("http://" + $scope.currentUrl + "/TiendaGames4U/webresources/modelo.videojuego")
            .then(function (response) {
                $scope.videojuegos = response.data;
            });



    $scope.nuevoVideojuego;
    $scope.registrarVideoJuego = function () {
        var videojuegoNuevo = {};
        videojuegoNuevo.nombre = $scope.nuevoVideojuego.nombre;
        videojuegoNuevo.genero = $scope.nuevoVideojuego.genero;
        videojuegoNuevo.clasificacion = $scope.nuevoVideojuego.clasificacion;
        videojuegoNuevo.precioDeVenta = $scope.nuevoVideojuego.precioDeVenta;
        videojuegoNuevo.precioDeCompra = $scope.nuevoVideojuego.precioDeCompra;
        videojuegoNuevo.fechaDePublicacion = $scope.nuevoVideojuego.fechaDePublicacion;
        videojuegoNuevo.disponibilidad = 1;

        $http.post("http://" + $scope.currentUrl + "/TiendaGames4U/webresources/modelo.videojuego", videojuegoNuevo)
                .then(function (response) {
                    $http.get("http://" + $scope.currentUrl + "/TiendaGames4U/webresources/modelo.videojuego")
                            .then(function (response) {
                                $scope.videojuegos = response.data;
                            });
                });
    };

    $scope.videojuegoPorModificar;
    $scope.onModificarClick = function () {
        var elemento = $filter('filter')($scope.videojuegos, {id: $scope.indiceSeleccionado}, true);
        $scope.videojuegoPorModificar = elemento[0];
    };

    $scope.modificarVideojuego = function () {
        $scope.videojuegoPorModificar.idvideojuego = JSON.parse($scope.videojuegoPorModificar.idvideojuego);
        $scope.videojuegoPorModificar.nombre = JSON.parse($scope.videojuegoPorModificar.nombre);
        $scope.videojuegoPorModificar.genero = JSON.parse($scope.videojuegoPorModificar.genero);
        $scope.videojuegoPorModificar.clasificacion = JSON.parse($scope.videojuegoPorModificar.clasificacion);
        $scope.videojuegoPorModificar.precioDeVenta = JSON.parse($scope.videojuegoPorModificar.precioDeVenta);
        $scope.videojuegoPorModificar.precioDeCompra = JSON.parse($scope.videojuegoPorModificar.precioDeCompra);
        $scope.videojuegoPorModificar.fechaDePublicacion = JSON.parse($scope.videojuegoPorModificar.fechaDePublicacion);

        console.log($scope.videojuegoPorModificar);

        $http.put("http://" + $scope.currentUrl + "/TiendaGames4U/webresources/modelo.videojuego/" + $scope.videojuegoPorModificar.id, $scope.videojuegoPorModificar)
                .then(function (response) {
                    console.log(response);
                    $http.get("http://" + $scope.currentUrl + "/TiendaGames4U/webresources/modelo.videojuego")
                            .then(function (response) {
                                $scope.videojuegos = response.data;
                                console.log(response)
                            });
                });
    };

    $scope.videojuegoAVender;
    $scope.onVenderClick = function () {
        var elemento = $filter('filter')($scope.envios, {id: $scope.indiceSeleccionado}, true);
        $scope.videojuegoAVender = elemento[0];
    };


    $scope.videojuegoPorVender;
    $scope.venderVideojuego = function () {
        var elemento = $filter('filter')($scope.videojuegos, {id: $scope.indiceSeleccionado}, true);
        $scope.videojuegoPorVender = elemento[0];
        var venta = {};
        venta.monto = $scope.videojuegoPorVender.precioDeVenta;
        venta.videojuegoIdvideojuego = $scope.videojuegoPorVender.videojuegoIdvideojuego;
        venta.fecha = new Date();//moment( new Date().toJSON().slice(0, 10) );

    };

    $scope.videojuegoAComprar;
    $scope.onComprarClick = function () {
        var elemento = $filter('filter')($scope.envios, {id: $scope.indiceSeleccionado}, true);
        $scope.videojuegoAComprar = elemento[0];
    };

    $scope.videojuegoPorComprar;
    $scope.comprarVideojuego = function () {
        var elemento = $filter('filter')($scope.videojuegos, {id: $scope.indiceSeleccionado}, true);
        $scope.videojuegoPorComprar = elemento[0];
        var compra = {};
        compra.monto = $scope.videojuegoPorVender.precioDeVenta;
        compra.videojuegoIdvideojuego = $scope.videojuegoPorVender.videojuegoIdvideojuego;
        compra.fecha = moment(new Date().toJSON().slice(0, 10));
    };

    $scope.eliminarVideojuego = function () {

    };


});