<!DOCTYPE HTML>
<html>
    <head>
        <title>Consultor&iacute;a Software Libre - ECCI</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="assets/css/main.css" />
    </head>
    <body class="homepage is-preload">
        <div id="page-wrapper">
            <section id="header">
                <div class="container">
                    <h1 id="logo"><a href="index.jsp">Consultor&iacute;a Software Libre</a></h1>
                    <p>&nbsp;</p>
                </div>
            </section>
            <section id="features">
                <div class="container">
                    <form>
                        <p>Escr&iacute;benos tu necesidad y te mostraremos un listado de posibles herramientas de software libre que te pueden llegar a servir</p>
                        <div class="row">
                            <div class="col-12">
                                <section>
                                    <div class="row gtr-50">
                                        <div class="col-2">
                                            <label for="nombre">Nombre:</label>
                                        </div>
                                        <div class="col-10">
                                            <input name="nombre" placeholder="Nombre" type="text" required="true" id="nombre" />
                                        </div>
                                    </div>
                                    <br />
                                    <div class="row gtr-50">
                                        <div class="col-2">
                                            <label for="email">Correo:</label>
                                        </div>
                                        <div class="col-10">
                                            <input name="email" placeholder="Email" type="text" required="true" id="email"/>
                                        </div>
                                    </div>
                                    <br />
                                    <div class="row gtr-50">
                                        <div class="col-2">
                                            <label for="email">Nivel de escolaridad:</label>
                                        </div>
                                        <div class="col-10">
                                            <select name="escolaridad" id="escolaridad" required="true">
                                            </select>
                                        </div>
                                    </div>
                                    <br />
                                    <div class="row gtr-50">
                                        <div class="col-2">
                                            <label for="email">Ocupaci&oacute;n:</label>
                                        </div>
                                        <div class="col-10">
                                            <select name="profesion" id="profesion" required="true">
                                            </select>
                                        </div>
                                    </div>
                                    <br />
                                    <div class="row gtr-50">
                                        <div class="col-2">
                                            <label for="email">Necesidad:</label>
                                        </div>
                                        <div class="col-10">
                                            <textarea name="necesidad" placeholder="Qu&eacute; necesita" type="text" required="true" id="necesidad"></textarea>
                                        </div>
                                    </div>
                                    <br />
                                    <div class="row gtr-50">
                                        <div class="col-2">
                                            <label for="email">Jusificaci&oacute;n:</label>
                                        </div>
                                        <div class="col-10">
                                            <textarea name="justificacion" placeholder="Por qu&eacute; lo necesita" type="text" id="justificacion"></textarea>
                                        </div>
                                    </div>
                                    <br />
                                    <div class="row gtr-50">
                                        <div class="col-2">
                                            <label for="herramientaActual">Herramienta actual:</label>
                                        </div>
                                        <div class="col-10">
                                            <input name="herramientaActual" placeholder="Qu&eacute; usa actualmente" type="text" id="herramientaActual" />
                                        </div>
                                    </div>
                                    <br />
                                    <div class="row gtr-50">
                                        <div class="col-12">
                                            <a href="javascript:consultar()" class="form-button-submit button icon fa-search" id="btnConsultar">Consultar</a>
                                        </div>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
            <section id="footer">
                <div id="copyright" class="container">
                    <ul class="links">
                        <li>&copy; Consultor&iacute;a Software Libre. ECCI.</li>
                    </ul>
                </div>
            </section>
        </div>
        <!-- Scripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/jquery.dropotron.min.js"></script>
        <script src="assets/js/browser.min.js"></script>
        <script src="assets/js/breakpoints.min.js"></script>
        <script src="assets/js/util.js"></script>
        <script src="assets/js/main.js"></script>
        <script>
            function cargarEscolaridades() {
                $.ajax({
                    url: './escolaridades/lista',
                    dataType: 'json',
                    type: 'POST',
                    success: function (response) {
                        var array = response.escolaridades;
                        if (array != '') {
                            for (i in array) {
                                $("#escolaridad").append("<option value=" + array[i].id + ">" + array[i].nombre + "</option>");
                            }
                        }
                    }
                });
            }

            function cargarProfesiones() {
                $.ajax({
                    url: './profesiones/lista',
                    dataType: 'json',
                    type: 'POST',
                    success: function (response) {
                        var array = response.profesiones;
                        if (array != '') {
                            for (i in array) {
                                $("#profesion").append("<option value=" + array[i].id + ">" + array[i].nombre + "</option>");
                            }
                        }
                    }
                });
            }

            function consultar() {
                var nombre = $("#nombre").val();
                var email = $("#email").val();
                var escolaridad = $("#escolaridad").val();
                var profesion = $("#profesion").val();
                var necesidad = $("#necesidad").val();
                var justificacion = $("#justificacion").val();
                var herramientaActual = $("#herramientaActual").val();

                if (nombre == "") {
                    alert('Ingrese el nombre');
                    $("#nombre").focus();
                    return;
                }
                if (email == "") {
                    alert('Ingrese el correo');
                    $("#email").focus();
                    return;
                }
                if (escolaridad == "") {
                    alert('Ingrese el nivel de escolaridad');
                    $("#escolaridad").focus();
                    return;
                }
                if (profesion == "") {
                    alert('Ingrese la ocupación');
                    $("#profesion").focus();
                    return;
                }
                if (necesidad == "") {
                    alert('Ingrese la necesidad');
                    $("#necesidad").focus();
                    return;
                }
                $.ajax({
                    url: './solicitudes/guardar',
                    type: 'post',
                    data: {
                        nombre: nombre,
                        email: email,
                        escolaridad: escolaridad,
                        profesion: profesion,
                        necesidad: necesidad,
                        justificacion: justificacion,
                        herramientaActual: herramientaActual
                    },
                    success: function (response) {
                        window.location = "metrica.jsp?s=" + response.idsolicitud;
                    },
                    error: function () {
                        alert('Error a realizar la consulta');
                    }
                });
            }

            $(function () {
                cargarEscolaridades();
                cargarProfesiones();
            });
        </script>
    </body>
</html>