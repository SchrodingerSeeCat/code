from django.conf.urls import url

from . import views

urlpatterns = [
    url("hello/", views.hello),
]
# from django.contrib import admin
# from django.urls import path
#
# urlpatterns = [
#     path('admin/', admin.site.urls),
# ]
