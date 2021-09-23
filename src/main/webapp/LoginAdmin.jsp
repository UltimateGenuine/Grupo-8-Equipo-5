<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administracion-Tienda Generica</title>
<link rel='stylesheet' href='estilosLoginAdmin.css' type='text/css'>
</head>
<body>
<section class="form-login">
    <h1 class="titulo">Bienvenido a la Tienda Generica</h1>
    <form action="loginAdmin" method="post">
        <input class="control" type="text" name="usuario" placeholder="Usuario" required>
        <input class="control" type="password" name="pass" min="1" max="100" placeholder="Contraseña" required>
        <input class="buttons" type="submit" name="enviar" value="Aceptar">
        <a href="index.jsp"><input class="buttons" type="button" name="cancela" value="Cancelar"></a>
    </form>
    </section>
</body>
</html>