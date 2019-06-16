<%-- 
    Document   : Logout
    Created on : Dec 24, 2014, 3:26:36 PM
    Author     : Praveen
--%>


<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
        <style>
            a:hover{
             color: red;
            }
        </style>
    </head>
    <body>
        <div align="center" style="min-height: 480px;color: #fff;background-image: url('images/wallpaper.gif')" >
            <br>
            <%
            session.removeAttribute("user");
            %>
            <div align="left">
                <a href="index.jsp"><img src="images/homeicon.png" width="80px" height="80px"></a>
            </div>
           
            <img src="images/logout.gif">
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>
