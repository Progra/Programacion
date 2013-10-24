<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
        	<div id="topmenu"></div>
        </div>
      	<div id="wrapper">
            <div id="content" style="text-align:center;width:950px;">
            	<form name="frm_usuario" method="post" action="">
            	<table cellpadding="0" cellspacing="0" style="width:50%">
            		<tr>
						<td colspan="2"><strong>INICIO DE SESION</strong></td>
	            	</tr>
	            	<tr>
	            		<td>Usuario:</td><td><input name="txt_user" type="text" style="width:150px;" /></td>
	            	</tr>
	            	<tr>
	            		<td>Clave:</td><td><input name="txt_pass" type="password"  style="width:150px;" /></td>
	            	</tr>
					<tr>
						<td colspan="2"><input type="submit" name="btn_login" value="ingresar" /></td>
	            	</tr>
				</table>
				</form>
            </div>
        </div>
		<div id="footer"  style="width:960px;margin-bottom:15px;">
        	Desarrollado por xyz
		</div>
	</div>
</body>
</html>