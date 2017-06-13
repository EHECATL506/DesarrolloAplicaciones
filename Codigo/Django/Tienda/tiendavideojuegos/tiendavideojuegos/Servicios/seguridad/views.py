from django.shortcuts import render_to_response, RequestContext
from django.shortcuts import redirect
import datetime
from tiendavideojuegos.Servicios.seguridad.serializers  import *
#from rest_framework import viewsets

# Create your views here.

def vista_inicio(request):
    return render_to_response('index.html', context=RequestContext(request))

def vista_nuevovideojuego(request):
    return render_to_response('nuevovideojuego.html', context=RequestContext(request))

def inicio(request):
    return render_to_response("index.html")

def registra(request):
    return render_to_response("nuevovideojuego.html")

def cliente(request):
    render_to_response("RegistrarCliente.html")

def reservas(request):
    return render_to_response("Reservar.html", context=RequestContext(request))

def ventas(request):
    return render_to_response("Ventas.html", context=RequestContext(request))

def ingresos(request):
    return render_to_response("Ingresos.html", context=RequestContext(request))

def compras(request):
  return  render_to_response("Compras.html", context=RequestContext(request))

def egresos(request):
   return render_to_response("Egresos.html", context=RequestContext(request))

def catalogo(request):
    render_to_response("ListaJuegos.html")


def agregarVideojuego(request):
    if request.POST:
        videojuego = videojuego()
        if request.POST['idVideojuego'] != '':
            videojuego.idVideojugo = request.POST['idVideojuego']

            videojuego.nombre= request.POST ['nombre']
            videojuego.genero = request.POST ['genero']
            videojuego.precioVenta = request.POST['precioVenta']
            videojuego.clasificacion = request.POST['clasificacion']
            videojuego.disponibilidad= request.POST['disponibilidad']
            videojuego.descripcion = request.POST ['descripcion']
            videojuego.fechaRegistro = datetime.datetime.now()
            videojuego.save()
            return render_to_response("nuevovideojuego.html")

def eliminarjuego(request):
    if request.POST:
        videojuego = videojuego.objects.get(idVideojuego=request.POST['idVideojuego'])
        videojuego.delete()
    return render_to_response("nuevovideojuego.html.html")
