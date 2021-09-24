<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos-Tienda Generica</title>
<link rel="stylesheet" href="estilo_producto1.css">
</head>
<body>
<%!
int codigo,nit;
String nombre="";
double preciocompra,iva,precioventa;
 %>
<%
if(request.getParameter("codigo")!=null){
codigo=Integer.parseInt(request.getParameter("codigo"));
nombre=request.getParameter("nombre");
nit=Integer.parseInt(request.getParameter("nit"));
preciocompra=Double.parseDouble(request.getParameter("preciocompra"));
iva=Double.parseDouble(request.getParameter("iva"));
precioventa=Double.parseDouble(request.getParameter("precioventa"));

}
if(request.getParameter("men")!=null){
    String mensaje=request.getParameter("men");
out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
codigo=0;nombre="";nit=0;preciocompra=0;iva=0;precioventa=0;

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
<h4>Registro de Proveedor</h4>
<!-- Para Archivo CSV -->
<form  action="Producto" method="post" enctype="multipart/form-data"><!-- Multipart nos permite trabajar archivos -->
<div><input class="controls" type="file" name="archivo" value="Examinar" accept="application/vnd.ms-excel"></div>
<input class="botons" type="submit" name="cargar" value="Cargar Archivo">
</form>
</section>
</body>
</html>