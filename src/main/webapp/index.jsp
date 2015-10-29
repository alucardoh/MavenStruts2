<%-- 
    Document   : index
    Created on : 28/10/2015, 08:10:52 PM
    Author     : rodrigo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Login</title>
        <script>
	$("document").ready(function(){
	    $("#filesect").change(function() {
	    //archivo, ext, nombre, size
	    	var file = $("#filesect").files[0];

	    	var reader = new FileReader();
            reader.onload = (function(e) {
                var archi = e.target.result + "";
                $("#archivo").value=archi;
                document.getElementById("submitbutton").hidden = false;
            });
            document.getElementById("submitbutton").hidden = true;
            reader.readAsDataURL(file); 

	    	$("#ext").val(""+file.name.split('.').pop());
	    	$("#nombre").val(""+file.name);
	    	$("#size").val(""+file.size);

	    });
	});
</script>
    </head>
    <body>
        <s:form action="loginaction">
            <s:textfield name="user" label="Usuario" theme="xhtml"></s:textfield>  
            <s:password name="password" label="Contraseņa" theme="xhtml"></s:password>
            <s:submit value="Login" theme="xhtml"></s:submit>		
        </s:form>
        <a href="register.jsp">Registrar</a>
    </body>
</html>
