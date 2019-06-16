<%-- 
    Document   : ViewUsers
    Created on : Jan 7, 2017, 11:45:48 PM
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
            <h3>Twitter Users</h3>
            <%
                Set users_list = (Set) request.getAttribute("users_list");
                Iterator i = users_list.iterator();
                while (i.hasNext()) {
                    UserDetails ud = (UserDetails) i.next();
                   
            %>
            <b style="color: yellow"> <a href="FetchUserIndvidualDet?userId=<%= ud.getId()%>"><%= ud.getName()%> </a></b></br></br>
            
            <%             }
            %>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

