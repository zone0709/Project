<%-- 
    Document   : error
    Created on : Apr 21, 2018, 6:42:58 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Error Page</h1>
        <font color="red">
        <s:property value="#request.ERROR"/>
        </font><br/>
        <a href="try">Back to Login</a>
        
    </body>
</html>
