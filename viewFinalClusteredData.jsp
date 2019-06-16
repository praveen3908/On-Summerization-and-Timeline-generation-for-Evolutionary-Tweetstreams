<%-- 
    Document   : viewFinalClusteredData
    Created on : Apr 18, 2017, 12:15:15 AM
    Author     : Praveen
--%>
<%-- 
    Document   : viewClusteredData
    Created on : Feb 22, 2017, 10:18:44 AM
    Author     : Praveen
--%>


<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <script>
            $(document).ready(function() {          
                var clusterData = '${Final_clusterData}';
                $('#t_msg').val(clusterData.trim());

            });

            $(document).ready(function() {
                $("form").submit(function() {
                    var msg = $('#t_msg').val();
                    if (msg == "" || msg == " ") {
                        alert("Please enter valid message");
                        return false;
                    }
                });
            });
        </script>
    </head>
    <body>
        <div style="min-height: 500px;color: #fff;background-color: #2196f3;" align="center">            
            <%@include file="menu.jsp" %>          
            <div align="right">Welcome to <b style="color:lightgreen">${user}</b>&nbsp;&nbsp;</div>  
            <h2>Summarized Final Data</h2><br>
            <form action="SummarizeCoreLevelServlet" id="target" method="post">
                <table>                   
                    <tr>
                        <td><b>Summarized Data:</b></td>
                        <td>
                            <textarea name="tweet_msg"  id="t_msg" style="width: 400px;height: 150px"></textarea>
                        </td>
                    </tr>

                </table>

            </form>


        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

