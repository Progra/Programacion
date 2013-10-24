<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="beans.ServicioBean"%>
<%@page import="java.util.Vector"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Modulo de Administracion</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/admin/theme1.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/admin/style.css" />
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/ie.css" />
<![endif]-->
</head>
<body>
<div id="container">
	<div id="header">
		<h2>Modulo de Administracion</h2>
		<div id="topmenu">Bienvenido  | Cerrar sesion</div>
    </div>
    <div id="top-panel">
		<div id="panel"></div>
	</div>
	<div id="wrapper">
		<div id="content" style="height: 210px;">
             <!-- contenido especifico por pagina -->
             <%
             	Vector<ServicioBean> servicios =
             			(Vector)request.getAttribute("servicios");
             %>
             <table>
             	<thead>
             		<tr>
             			<td>Nombre</td>
             			<td>Opciones</td>
             		</tr>
             	</thead>
             	<tbody>
             		<% for(int i=0; i<servicios.size(); i++){ %>
             		<tr>
             			<td><%=servicios.get(i).getNombre() %></td>
             			<td>
             			<a href="<%=request.getContextPath() %>/Servicio?funcion=editar&codigo=<%=servicios.get(i).getId() %>">editar</a>
             			<a href="<%=request.getContextPath() %>/Servicio?funcion=eliminar&codigo=<%=servicios.get(i).getId() %>">eliminar</a>
             			</td>
             		</tr>
             		<% } %>
             	</tbody>
             </table>  
		</div>
		<div id="sidebar"><%@ include file="sidebar.jsp" %></div>
	</div>
	<div id="footer"><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>
