<%-- 
    Document   : register
    Created on : 28/10/2015, 08:28:12 PM
    Author     : rodrigo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="register">  
    <s:textfield name="user" label="Usuario" required="True"></s:textfield>  
    <s:password name="password" label="Contraseña" required="True"></s:password>  
    <s:textfield name="name" label="Nombre" required="True"></s:textfield> 
    <s:submit value="register"></s:submit>

</s:form>  
