<%-- 
    Document   : index
    Created on : 08-06-2019, 04:13:50 PM
    Author     : Teresa Acostha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head background="">
    <img src="back.jpg" width="1665" alt="200"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-4"><div class="header">

                    <div class="navbar" id='nav'>

                        <ul>
                            <li><em>Menu</em></li>
                           <li><em>Clientes</em></li>
                            <li><em>Reservas</em></li>
                           <li><em>Categoria</em></li>
                          <li><em>Tramos</em></li>
                        </ul>

                    </div>

                </div>

                <div class="box"></div>


                <!--agregando codigo de  javascript :v -->

                <script type="text/javascript">

                    var nav = document.getElementById('nav');

                    window.onscroll = function () {

                        if (window.pageYOffset > 100) {

                            nav.style.background = "#5C97D6";
                            nav.style.boxShadow = "0px 4px 2px blue";
                        } else {
                            nav.style.background = "transparent";
                            nav.style.boxShadow = "none";
                        }
                    }



                </script>



                <!-- esta cosa le agrega estilo ^^ -->

                <style type="text/css">

                    *{
                        padding: 0px;
                        margin:0px;
                        box-sizing: border-box;
                    }

                    .header{
                        width: 100%;
                        height: 100%;
                        background-image:url(back.jpg);
                        background-size: cover;

                    }

                    .navbar{
                        width: 100%;
                        padding: 20px;
                        position: fixed;
                        top: 0px;
                        text-align: center;
                        transition: .5s;
                    }

                    .navbar ul li{
                        list-style-type: none;
                        display:inline-block;
                        padding: 10px 50px;
                        color: white;
                        font-size: 24px;
                        font-family: sans-serif;
                        cursor: pointer;
                        border-radius:10px;
                        transition: .5s;
                    }

                    .navbar ul li:hover{
                        background: #cccccc;
                    }




                </style></div>

        </div>
    </div>
    <!-- esto no sirve  .box{
                      width: 80%;
                      height: 2000px;
                      background: green;
                      margin: 20px auto;

                  } -->
</body>
</html>
