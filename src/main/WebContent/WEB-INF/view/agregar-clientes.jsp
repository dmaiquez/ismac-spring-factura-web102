<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>  Clientes </h1>


	<form action=""  method="get">
	
		<input type="hidden" id="idCliente" name="idCliente" />
		<br/><br/>
		Cedula
		<input type="number" id="cedula" name="cedula" />
		<br/><br/>
		Nombre
		<input type="text" id="nombre" name="nombre" maxlength=20 />
		<br/><br/>
		Apellido
		<input type="text" id="apellido" name="apellido" />
		<br/><br/>
		Fecha de Nacimiento
		<input type="date" id="fechaNacimiento" name="fechaNacimiento" />
		<br/><br/>
		Edad
		<input type="number" id="edad" name="edad" />
		
		
	
	</form>



</body>
</html>