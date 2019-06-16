<%-- 
    Document   : Login
    Created on : Dec 20, 2014, 1:51:47 PM
    Author     : Praveen
--%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <style>
            a:hover{
             color: red;
            }
        </style>
    </head>
    <body>
        <div style="min-height: 500px;color: #fff;background-color: #2196f3;" align="center">
                 <br>
            <div align="left">
                <a href="index.jsp"><img src="images/homeicon.png" width="80px" height="80px"></a>
            </div>
            <img src="images/Login-Button_1.png" height="70px" width="400px"></br></br>
            <form action="LoginCheckServlet" method="POST">
            <table cellpadding="8">
                <tr>
                    <td>User Name (Email Id):</td>
                    <td><input type="text" name="uname" required="true"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="pwd" required=""></td>
                </tr>

                <tr>
                    <td align="center" colspan="2"><input type="submit" value="Login" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff;border-radius: 10px ">
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff;border-radius: 10px "></td>
                </tr>

            </table>
            </form>
            <br><br><br>
            <h4>New User <a href="Register.jsp">Register Here</a></h4><br>

        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>
