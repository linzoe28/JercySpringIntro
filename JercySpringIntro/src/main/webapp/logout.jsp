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
            function logout() {
                $.ajax("webapi/login/"+$("#id").val(), {
                    type: "DELETE",
                    success: function (d) {
                        alert("success!");
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
        <input type="button" value="logout" onclick="logout();"/>
    </body>
</html>
