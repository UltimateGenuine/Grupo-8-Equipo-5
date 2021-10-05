<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario-Tienda Generica</title>
<link rel="stylesheet" href="estilo_usuario1.css">
</head>
<body>

<%!
String cedula="", usuario="",nombre="",contraseña="",correo="", estado="";
 %>
<%
if(request.getParameter("cedula")!=null){
cedula=request.getParameter("cedula");
usuario=request.getParameter("usuario");
nombre=request.getParameter("nombre");
contraseña=request.getParameter("contraseña");
correo=request.getParameter("correo");
estado="disabled";
}
if(request.getParameter("men")!=null){
    String mensaje=request.getParameter("men");
out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
cedula="";usuario="";nombre="";contraseña=""; correo="";
estado="";
}
%>
    <h1>Tienda Generica</h1>
    <nav>
      <ul>
        <li><a href="Usuario.jsp" target="_blank">Usuario</a></li>
        <li><a href="Cliente.jsp" target="_blank">Clientes</a></li>
        <li><a href="Proveedor.jsp" target="_blank">Proveedores</a></li>
        <li><a href="Producto.jsp" target="_blank">Productos</a></li>
        <li><a href="" target="_blank">Ventas</a></li>
        <li><a href="" target="_blank">Reportes</a></li>
      </ul>
    </nav>
  <section class="form-register">
    <form action="Usuario" method="post">
    <h4>Registro de Usuario</h4>
    <div>
    <input class="controls" type="text" name="cedula" placeholder="Cedula" pattern="[0-9]+" title="(Digite numeros sin puntos o guiones)" required value="<%=cedula%>" <%=estado%>>
    <input type="hidden" name="cod" required value="<%=cedula%>">
    <input class="controls" type="text" name="usuario" placeholder="Usuario" required value="<%=usuario%>">
    <input class="controls" type="text" name="nombre" placeholder="Nombre Completo" required value="<%=nombre%>">
    <input class="controls" type="password" name="contraseña" min="1" max="100" placeholder="Contraseña" required value="<%=contraseña%>">
    <input class="controls" type="email" name="correo" placeholder="Correo Electronico" required value="<%=correo%>">
    </div>
    <!-- <input class="botons" type="submit" name="consultar" value="Consultar"> -->
    <input class="botons" type="submit" name="insertar" value="Crear">
    <input class="botons" type="submit" name="actualizar" value="Actualizar">
    <input class="botons" type="submit" name="eliminar" value="Borrar">
    <!--<a href="usuario.html"><input class="botons" type="button" name="cancela" value="Cancelar"></a>-->
	</form>
	<form action = "Usuario" method="post">
	<div><input class="consultando" type ="number" name = "cedula" placeholder="Introduzca Cedula a Consultar">
	<input class="consulta" type="submit" name="consultar" Value="Consultar"></div>
    <!--<a href="usuario.html"><input class="botons" type="button" name="cancela" value="Cancelar"></a>-->
    </form>
  </section>

</body>
</html>