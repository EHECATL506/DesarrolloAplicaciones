from rest_framework import serializers
from tiendavideojuegos.Servicios.seguridad.models import *

class CompraSerializer(serializers.ModelSerializer):
    class Meta:
        model = Compra
        fields = '__all__'

class ReservaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Reserva
        fields = '__all__'


class UsuariosSerializer(serializers.ModelSerializer):
    class Meta:
        model = Usuarios
        fields = '__all__'


class VentaSerializer(serializers.ModelSerializer):
    idCliente = UsuariosSerializer()
    class Meta:
        model = Venta
        fields = '__all__'

class VideojuegosSerializer(serializers.ModelSerializer):
    class Meta:
        model = Videojuego
        fields = '__all__'
