<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script>
            $(document).ready(function () {
                $.ajax('webapi/accounts/<%=request.getParameter("id")%>', {
                    success: function (d) {
                        $("#id").val(d.id);
                        $("#password").val(d.password);
                        $("#email").val(d.email);
                    }
                });
            });
            
             function update(){
                let data={
                  id:$("#id").val(),
                  password:$("#password").val(),
                  email:$("#email").val()
                };
                $.ajax("webapi/accounts",{
                    type:"PUT",
                    contentType:"application/json",
                    data:JSON.stringify(data),
                    success:function(d){
                        alert("success!");
                    },
                    error:function(){
                        alert("failed");
                    }
                });
            }
        </script>
    </head>
    <body>
        ID:<input type="text" id="id"/><br/>
        Password:<input type="text" id="password"/><br/>
        Email:<input type="text" id="email"/><br/>
        <input type="button" value="update" onclick="update();"/>
    </body>
</html>
