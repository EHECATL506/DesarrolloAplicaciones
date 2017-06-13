from django.shortcuts import render_to_response, RequestContext
from django.shortcuts import redirect
import datetime
#from BaseDeDatos.serializers import *
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
    render_to_response("Reservar.html")

def ventas(request):
    render_to_response("Ventas.html")

def ingresos(request):
    render_to_response("Ingresos.html")

def compras(request):
    render_to_response("Compras.html")

def egresos(request):
    render_to_response("Egresos.html")

def catalogo(request):
    render_to_response("ListaJuegos.html")



