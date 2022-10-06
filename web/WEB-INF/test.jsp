<%-- 
    Document   : test
    Created on : Oct 5, 2022, 8:24:45 AM
    Author     : dyadlows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Request: ${reqAttr}</h2>
        <h2>Session: ${sessionAttr}</h2>
        <p>Username: ${username}</p>
        
        <br><br>
        <p>
            <a href="test2?param">Alternate Page</a>
        </p>
    </body>
</html>
