<%-- 
    Document   : viewIndividualUserDet
    Created on : Jan 24, 2017, 11:19:48 AM
    Author     : Praveen
--%>

<%@page import="com.ieee.pojo.UserDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    
    <body>        
        <div style="min-height: 500px;color: #fff;background-color: #2196f3;" align="center">            
            <%@include file="menu.jsp" %> 
            <h3>Twitter User Details</h3>
            <%
                UserDetails user_det = (UserDetails) request.getAttribute("ud");             
            %>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><%=user_det.getName()%></td>
                </tr>
                <tr>
                    <td>Mobile No :</td>
                    <td><%=user_det.getMobile()%></td>
                </tr>
                <tr>
                    <td>Mail :</td>
                    <td><%=user_det.getMail()%></td>
                </tr>
            </table>
           <br>
           <%
              String follwer=(String) request.getAttribute("follwer");
              if(follwer.equals("N")){
           %>
           <i style="color: yellow"> <a href="StoreFollwerDetailsServlet?follwerId=<%= user_det.getId()%>">Follow</a></i>
           <%}%>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

