<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>:: ECCI - M&oacute;dulo de administraci&oacute;n - Inicio de sesi&oacute;n::</title>
        <link href="../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="text-center">
        <form class="form-signin" action="../usuarios/validarUsuario" method="post">
            <img class="mb-4" src="https://www.ecci.edu.co/sites/default/files/logo_0.png" alt="" width="225" height="90">
            <h1 class="h3 mb-3 font-weight-normal">Iniciar sesi&oacute;n</h1>
            <label for="inputEmail" class="sr-only">Login</label>
            <input type="text" name="login" class="form-control" placeholder="Login" required autofocus>
            <label for="inputPassword" class="sr-only">Contrase&ntilde;a</label>
            <input type="password" name="password" class="form-control" placeholder="contrase&ntilde;a" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2018</p>
        </form>
    </body>
</html>