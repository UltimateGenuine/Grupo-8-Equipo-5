<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedor-Tienda Generica</title>
<link rel="stylesheet" href="estilo_proveedor1.css">
</head>
<body>
<body>

<%!
String nit="", telefono="",nombre="",ciudad="",direccion="",estado="";
 %>
<%
if(request.getParameter("nit")!=null){
nit=request.getParameter("nit");
telefono=request.getParameter("telefono");
nombre=request.getParameter("nombre");
ciudad=request.getParameter("ciudad");
direccion=request.getParameter("direccion");
estado="disabled";
}
if(request.getParameter("men")!=null){
    String mensaje=request.getParameter("men");
out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
nit="";telefono="";nombre="";ciudad=""; direccion="";
estado="";
}
%>
    <h1>Tienda Generica</h1>
    <nav>
      <ul>
        <li><a href="Usuario.jsp" target="_blank">Usuario</a></li>
        <li><a href="Cliente.jsp" target="_blank">Clientes</a></li>
        <li><a href="Proveedor.jsp" target="_blank">Proveedores</a></li>
        <li><a href="" target="_blank">Productos</a></li>
        <li><a href="" target="_blank">Ventas</a></li>
        <li><a href="" target="_blank">Reportes</a></li>
      </ul>
    </nav>
  <section class="form-register">
    <form action="Proveedor" method="post">
    <h4>Registro de Proveedor</h4>
    <div>
    <input class="controls" type="text" name="nit" placeholder="NIT" pattern="[0-9]+" title="(Digite numeros sin puntos o guiones)" required value="<%=nit%>" <%=estado%>>
    <input type="hidden" name="cod" value="<%=nit%>">
    <input class="controls" type="text" name="telefono" placeholder="Telefono" pattern="[0-9]+" title="(Digite numeros sin puntos o guiones)" required value="<%=telefono%>">
    <input class="controls" type="text" name="nombre" placeholder="Nombre Completo" required value="<%=nombre%>">
    <input class="controls" type="text" name="ciudad" placeholder="Ciudad" required value="<%=ciudad%>">
    <input class="controls" type="text" name="direccion" placeholder="Direccion" required value="<%=direccion%>">
    </div>
    <!-- <input class="botons" type="submit" name="consultar" value="Consultar"> -->
    <input class="botons" type="submit" name="insertar" value="Crear">
    <input class="botons" type="submit" name="actualizar" value="Actualizar">
    <input class="botons" type="submit" name="eliminar" value="Borrar">
    <!--<a href="usuario.html"><input class="botons" type="button" name="cancela" value="Cancelar"></a>-->
	</form>
	<form action = "Proveedor" method="post">
	<div><input class="consultando" type ="number" name = "nit" placeholder="Introduzca NIT a Consultar">
	<input class="consulta" type="submit" name="consultar" Value="Consultar"></div>
    <!--<a href="usuario.html"><input class="botons" type="button" name="cancela" value="Cancelar"></a>-->
    </form>
  </section>
</body>
</html>