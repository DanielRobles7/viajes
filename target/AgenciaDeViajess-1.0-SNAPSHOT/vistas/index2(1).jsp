<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body background="imagenes/avion.jpg">
        <!img src="imagenes/avion.jpg" alt=""/>
    <div class="container">
        <div clas="row">
            <div class="col-12">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <a class="navbar-brand" href="#">Inicio</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Clientes <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Reservas</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Categorias
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">Action</a>
                                    <a class="dropdown-item" href="#">Another action</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#">Something else here</a>
                                </div>
                            </li>
                            <!--nav class="navbar navbar-inverse">
                                <div class="container -fluid">
                                    <div  class="navbar-header">
                                        <a class="navbar-brand" href="/agenciaDeViajes/cliente?action=inicio&cliente=${nombre}">Agencia De Viajes</a>
                                    </div>
                                    <ul class="nav navbar-nav">
                                        <li class="active"><a href="/agenciaDeViajes/cliente?action=inicio&cliente=${nombre}">Inicio</a></li>
                                        <li class="dropnow"><a class="dropnow-toggle" data-toggle="dropnow" href="#">Consultas<span class="caret"></span></a></li>
                                        <!--lista de  articulos sin orden--->
                                        <ul class="dropnow-menu">
                                            <!--li lista enumerada--->
                                            <li><a href="/agenciaDeViajes/aereoline?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Aereoline</a></li>
                                            <li><a href="/agenciaDeViajes/aereolinea?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Aereolinea</a></li>
                                            <li><a href="/agenciaDeViajes/aereopuerto?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Aereopuerto</a></li>
                                            <li><a href="/agenciaDeViajes/categoria?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Categoria</a></li>
                                            <li><a href="/agenciaDeViajes/ciudad?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Ciudad</a></li>
                                            <li><a href="/agenciaDeViajes/cliente?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Clientes</a></li>
                                            <li><a href="/agenciaDeViajes/compania_aerea?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Compañia Aerea</a></li>
                                            <li><a href="/agenciaDeViajes/escala?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Escalas</a></li>
                                            <li><a href="/agenciaDeViajes/registro_vuelo?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Registro Vuelo</a></li>
                                            <li><a href="/agenciaDeViajes/reserva?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Reservas</a></li>
                                            <li><a href="/agenciaDeViajes/tipo_categoria?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Tipo de  Categoria</a></li>
                                            <li><a href="/agenciaDeViajes/tramo?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Tramos</a></li>
                                            <li><a href="/agenciaDeViajes/vuelos?action=consultarAll_vuelos&cliente=${vuelo_cliente}">Vuelos</a></li>
                                        </ul>
                                        </li>

                                    </ul>
                                </div>
                            <!--/nav--->
                    </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <div id="myCarousel" class="carouesel slide" data-ride="carouseñ">
                            <!--indicadores :v ol->lista ordenada  de  articulos--->
                            <ol class="carouesel-indicators">  
                                <il data-target="#myCarousel" data-sile-to="0"  class="active"></il>
                                <il  data-target="#myCarousel" data-sile-to="1" ></il>
                                <li data-target="#myCarousel" data-sile-to="2" ></li>
                            </ol>
                            <!--envoltoria para las diapositivas--->
                            <!--Wrapper for slides -->
                            <div class="carouesel-inner">
                                <div  class="item-active">
                                    <img src="imagenes/avion3.jpg" width="1500" alt="img1"/>                                             
                                </div>

                                <div class="item">
                                    <img src="imagenes/avion4.jpg" width="1200" alt="img2"/>
                                </div>

                                <div  class="item">
                                    <img src="imagenes/avion2.jpg" width="1100" alt="img3"/>
                                </div>
                            </div>
                            <!-- Left and right controls -->
                            <!controles izquierdo y derecho-->

                            <a class=" left carouesel-control" href="#myCarousel" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                                <span class="sr-only">Previus</span>

                            </a>

                            <a class="left carouesel-control" href="#myCarousel" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                                <span class="sr-only">Next</span>

                            </a>

                        </div>
                    </div>
                    <div class="col-1"></div>                                   


                </div>
            </div>


        </div>
    </body>
</html>
