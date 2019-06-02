<%-- 
    Document   : login
    Created on : 2019/6/2, 下午 10:29:39
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <title>JSP Page</title>
        <script>
            function login() {
                $.ajax("webapi/login", {
                    type: "POST",
                    data: {
                        id: $("#id").val(),
                        password: $("#password").val()
                    },
                    success: function (d) {
                        alert("success!"+d);
                    },
                    error: function () {
                        alert("failed");
                    }
                });
            }
        </script>
    </head>
    <body>
        ID:<input type="text" id="id"/><br/>
        Password:<input type="text" id="password"/><br/>
        <input type="button" value="login" onclick="login();"/>
    </body>
</html>
