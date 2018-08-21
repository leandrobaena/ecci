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
            <!-- Header -->
            <section id="header">
                <div class="container">
                    <!-- Logo -->
                    <h1 id="logo"><a href="index.jsp">Consultor&iacute;a Software Libre</a></h1>
                    <p>&nbsp;</p>
                </div>
            </section>
            <!-- Main -->
            <section id="main">
                <div class="container">
                    <div class="row">
                        <!-- Content -->
                        <div id="content" class="col-12 col-12-medium">
                            <!-- Post -->
                            <article class="box post">
                                <header>
                                    <p>El resultado de la b&uacute;squeda de acuerdo a las necesidades que ingres&oacute; son:</p>
                                </header>
                            </article>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-1 col-1-medium">
                            <h3>Nombre</h3>
                        </div>
                        <div class="col-4 col-4-medium">
                            <h3>Descripci&oacute;n</h3>
                        </div>
                        <div class="col-1 col-1-medium">
                            <h3>Licencia</h3>
                        </div>
                        <div class="col-2 col-2-medium">
                            <h3>Descarga</h3>
                        </div>
                        <div class="col-1 col-1-medium">
                            <h3>Versi&oacute;n</h3>
                        </div>
                        <div class="col-2 col-2-medium">
                            <h3>Necesidad</h3>
                        </div>
                        <div class="col-1 col-1-medium">
                            <h3>Porcentaje</h3>
                        </div>
                    </div>
                    <div id="result"></div>
                </div>
            </section>
            <!-- Footer -->
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
            function cargarMetrica() {
                $.ajax({
                    url: './solicitudes/metrica',
                    dataType: 'json',
                    type: 'POST',
                    data: {
                        idsolicitud: <% out.write(request.getParameter("id"));%>
                    },
                    success: function (response) {
                        var array = response.metricas;
                        if (array != '') {
                            for (i in array) {
                                $("#result").append("<div class=\"row\">" +
                                        "<div class=\"col-1 col-1-medium\">" +
                                        array[i].nombre +
                                        "</div>" +
                                        "<div class=\"col-4 col-4-medium\">" +
                                        array[i].descripcion +
                                        "</div>" +
                                        "<div class=\"col-1 col-1-medium\">" +
                                        array[i].licencia +
                                        "</div>" +
                                        "<div class=\"col-2 col-2-medium\">" +
                                        "<a href=\"" + array[i].url + "\" target=\"_blank\">" + array[i].url + "</a>" +
                                        "</div>" +
                                        "<div class=\"col-1 col-1-medium\">" +
                                        array[i].version +
                                        "</div>" +
                                        "<div class=\"col-2 col-2-medium\">" +
                                        array[i].necesidad +
                                        "</div>" +
                                        "<div class=\"col-1 col-1-medium\">" +
                                        array[i].porcentaje + " %" +
                                        "</div>" +
                                        "</div>");
                            }
                        }
                    }
                });
            }

            $(function () {
                cargarMetrica();
            });
        </script>
    </body>
</html>