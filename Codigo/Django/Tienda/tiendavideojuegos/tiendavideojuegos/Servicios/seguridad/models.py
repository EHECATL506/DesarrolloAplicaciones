from django.db import models
#from __future__ import unicode_literals

# Create your models here.
class Compra (models.Model):
    idCompra = models.AutoField(primary_key=True)
    Fecha = models.DateField()
    Monto = models.IntegerField()
    idVideojuego = models.IntegerField()
    cantidad = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'compra'

class Reserva(models.Model):
    idReservacion = models.AutoField(primary_key=True)
    estado = models.CharField(max_length=10)
    idCliente = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column='idCliente')
    fecha = models.DateField()
    idVideojuego = models.IntegerField()

    class Meta:
        managed = False
        db_table = 'reserva'

class Videojuego(models.Model):
    idVideojugo = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=50)
    genero= models.CharField(max_length=20)
    precioVenta = models.IntegerField()
    clasificacion= models.CharField(max_length=1)
    disponibilidad = models.SmallIntegerField()
    descripcion = models.CharField(max_length=50)
    fechaRegistro = models.DateField()

    class Meta:
        managed = False
        db_table = 'videojuego'



class Usuarios(models.Model):
    idCliente = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=30)
    apellidos=models.CharField(max_length=30)
    telefono=models.IntegerField()
    correo = models.CharField(max_length=30)

    class Meta:
        managed = False
        db_table = 'usuarios'

class Venta(models.Model):
    idVenta = models.AutoField(primary_key=True)
    monto= models.IntegerField()
    fechaventa= models.DateField()
    idvideojuego = models.IntegerField()
    cantidadVendida = models.IntegerField()
  # reserva= models.BooleanField(False)
    idCliente = models.ForeignKey('Usuarios', models.DO_NOTHING, db_column ='usuarios')

    class Meta:
        managed = False
        db_table = 'venta'