<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venta - Tienda Generica</title>
<link rel="stylesheet" href="Ventas.css">
</head>
<body>
<%!
String cedula="",cliente="",producto="",codigo="",iva="",precioCom="",precioVen="",cantidaduno="",valortotaluno="",productodos="",codigodos="",ivados="",precioComdos="",precioVendos="",cantidaddos="",valortotaldos="",productotres="",codigotres="",ivatres="",precioComtres="",precioVentres="",cantidadtres="",valortotaltres="",totalventa="", totaliva="",total="";
%>
<%
if(request.getParameter("cedula")!=null){
cedula=request.getParameter("cedula");
cliente=request.getParameter("nombre");
}

if(request.getParameter("codigo")!=null){
codigo=request.getParameter("codigo");
producto=request.getParameter("producto");
precioCom=request.getParameter("precioCom");
precioVen=request.getParameter("precioVen");
}

if(request.getParameter("codigodos")!=null){
codigodos=request.getParameter("codigodos");
productodos=request.getParameter("productodos");
precioComdos=request.getParameter("precioComdos");
precioVendos=request.getParameter("precioVendos");
}

if(request.getParameter("codigotres")!=null){
codigotres=request.getParameter("codigotres");
productotres=request.getParameter("productotres");
precioComtres=request.getParameter("precioComtres");
precioVentres=request.getParameter("precioVentres");
}

if(request.getParameter("men")!=null){
	String mensaje = request.getParameter("men");
	out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
	cedula=""; 
	cliente=""; 
}

if(request.getParameter("valortotaltres")!=null){
valortotaluno=request.getParameter("valortotaluno");
cantidaduno=request.getParameter("cantidaduno");
valortotaldos=request.getParameter("valortotaldos");
cantidaddos=request.getParameter("cantidaddos");
valortotaltres=request.getParameter("valortotaltres");
cantidadtres=request.getParameter("cantidadtres");
totalventa=request.getParameter("totalventa");
totaliva=request.getParameter("totaliva");
total=request.getParameter("total");
}
%>

	<h1>Tienda Genérica</h1>
	<nav>
		<ul>
			<li><a href="Usuario.jsp" target="_blank">Usuarios</a></li>
			<li><a href="Cliente.jsp" target="_blank">Clientes</a></li>
			<li><a href="Proveedor.jsp" target="_blank">Proveedores</a></li>
			<li><a href="Producto.jsp" target="_blank">Productos</a></li>
			<li><a href="Ventas.jsp" target="_blank">Ventas</a></li>
			<li><a href="Reportes.jsp">Reportes</a></li>
		</ul>
	</nav>
<section class="form-register">
<form action="Venta" method=post>
	<div>
	<input class="consultandoC" type="text" placeholder="Digite la cedula" name="cedula" required value=<%=cedula%>>
	<input class="consulta" type="submit" name="consultar" Value="Consultar">
	<input class="consultandoCl" type="text" name="cliente" value=<%=cliente%>>
	</div>

<label class="a1">Cod. Producto</label><label class="a2">Nombre del producto</label><label class="a3">Cant.</label><label class="a4">Valor total</label>

	<div><input class="consultandoC2" type="text" placeholder="Digite el codigo" name="codigo" value=<%=codigo%>>
		<input class="consulta2" type="submit" name="consultaruno" Value="Consultar">
		<input class="consultandoPr" type="text" name="productouno" value=<%=producto%>>
		<input class="consultandoCa" type="text" name="cantidaduno" pattern="[1-9]+" title="Introduzca solo numeros" value=<%=cantidaduno%>>
		<input class="consultandoVal" type="text" name="valortotaluno" value=<%=valortotaluno%>>
		<input type="hidden" name="precioCom" value=<%=precioCom%>>
		<input type="hidden" name="precioVen" value=<%=precioVen%>>
	</div>

	<div><input class="consultandoC3" type="text" placeholder="Digite el codigo" name="codigodos" value=<%=codigodos%>>
		<input class="consulta3" type="submit" name="consultardos" Value="Consultar">
		<input class="consultandoPr3" type="text" name="productodos" value=<%=productodos%>>
		<input class="consultandoCa3" type="text" name="cantidaddos" pattern="[1-9]+" title="Introduzca solo numeros" value=<%=cantidaddos%>>
		<input class="consultandoVal3" type="text" name="valortotaldos" value=<%=valortotaldos%>>
		<input type="hidden" name="precioComdos" value=<%=precioComdos%>>
		<input type="hidden" name="precioVendos" value=<%=precioVendos%>>
	</div>


	<div><input class="consultandoC3" type="text" placeholder="Digite el codigo" name="codigotres" value=<%=codigotres%>>
		<input class="consulta3" type="submit" name="consultartres" Value="Consultar">
		<input class="consultandoPr3" type="text" name="productotres" value=<%=productotres%>>
		<input class="consultandoCa3" type="text" name="cantidadtres" pattern="[1-9]+" title="Introduzca solo numeros" value=<%=cantidadtres%>>
		<input class="consultandoVal3" type="text" name="valortotaltres" value=<%=valortotaltres%>>
		<input type="hidden" name="precioComtres" value=<%=precioComtres%>>
		<input type="hidden" name="precioVentres" value=<%=precioVentres%>>
	</div>


<div><label class="a5">Total venta</label><input id="consultandoC4" class="a8" type="text" name="totalventa" value=<%=totalventa%>></div>
<div><label class="a6">Total IVA</label><input id="consultandoC4" class="a9" type="text" name="totaliva" value=<%=totaliva%>></div>
<div><label class="a7">Total con IVA</label><input id="consultandoC4" class="a10" type="text" name="total" value=<%=total%>></div>
<input id="consultandoCa4" class="a11" type="submit" name="confirmar" Value="Confirmar">
</form>
</section>
</body>
</html>