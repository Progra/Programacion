<%@page import="beans.MonedaBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%  Vector<MonedaBean> monedas= (Vector)request.getAttribute("monedas");%>


<select>

<%for(int i=0; i<monedas.size(); i++) {%>
<option value=<%=monedas.get(i).getIdTipoMoneda()%>><%=monedas.get(i).getNomMoneda() %> </option>
<%
}
%>

</select>
</body>
</html>