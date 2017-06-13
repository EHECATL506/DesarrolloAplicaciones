_author_='dixas'

from django.conf.urls import patterns, url
from views import *

urlpatterns = patterns('tiendavideojuegos.Servicios.seguridad.views',
                       url(r'^$', 'vista_inicio', name="index"),
                       url(r'^nuevovideojuego', 'vista_nuevovideojuego', name="nuevovideojuego"),
                       url(r'^inicio/', inicio),
                       url(r'^registra/', registra),
                       url(r'^cliente/', cliente),
                       url(r'^reservas/', reservas),
                       url(r'^ventas/', ventas),
                       url(r'^ingresos/', ingresos),
                       url(r'^egresos/', egresos),
                       url(r'^catalogo/', catalogo),
                       url(r'^compras/', compras)

)
