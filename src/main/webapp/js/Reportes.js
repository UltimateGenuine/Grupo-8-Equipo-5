$(document).ready(function(){

function listaUsuarios(){

$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"Usuario"},
	success: function(result){
		console.log(result)
		var titulo=document.querySelector(".titulo")
		titulo.innerHTML="Listado de usuarios"
		var tabla=document.querySelector(".tabla")
		tabla.innerHTML=''  
		// Hacemos encabezado de la tabla
		tabla.innerHTML+=`<tr> 
		<th>Cedula</th>
		<th>Correo Electronico</th>
		<th>Nombre</th>
		<th>Password</th>
		<th>Usuario</th>
		</tr>`
		for(let fila of result){
			tabla.innerHTML+=`<tr>
			<td>${fila.Cedula}</td>
			<td>${fila.Correo}</td>
			<td>${fila.Nombre}</td>
			<td>${fila.Contraseña}</td>
			<td>${fila.Usuario}</td>
			</tr>`
		}
	}
})	
}

function listaClientes(){

$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"Cliente"},
	success: function(result){
		console.log(result)
		var titulo=document.querySelector(".titulo")
		titulo.innerHTML="Listado de clientes"
		var tabla=document.querySelector(".tabla")
		tabla.innerHTML=''  
		// Hacemos encabezado de la tabla
		tabla.innerHTML+=`<tr class="bordes"> 
		<th>Cedula</th>
		<th>Direccion</th>
		<th>Correo Electronico</th>
		<th>Nombre</th>
		<th>Telefono</th>
		</tr>`
		for(let fila of result){
			tabla.innerHTML+=`<tr>
			<td>${fila.Cedula}</td>
			<td>${fila.Direccion}</td>
			<td>${fila.Correo}</td>
			<td>${fila.Nombre}</td>
			<td>${fila.Telefono}</td>
			</tr>`
		}
	}
})	
}

function listaVentas(){

$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"Venta"},
	success: function(result){
		console.log(result)
		var titulo=document.querySelector(".titulo")
		titulo.innerHTML="Total de ventas por cliente"
		var tabla=document.querySelector(".tabla")
		tabla.innerHTML=''  
		// Hacemos encabezado de la tabla
		tabla.innerHTML+=`<tr class="bordes"> 
		<th>Cedula</th>
		<th>Nombre</th>
		<th>Valor Total Ventas</th>
		</tr>`
		for(let fila of result){
			tabla.innerHTML+=`<tr>
			<td>${fila.cedula}</td>
			<td>${fila.nombre}</td>
			<td>$${fila.total}</td>
			</tr>`
		}
	}
})	
}

$('.Usuario').on('click',function(){
	listaUsuarios()
})	

$('.Cliente').on('click',function(){
	listaClientes()
})

$('.Venta').on('click',function(){
	listaVentas()
})
	
})