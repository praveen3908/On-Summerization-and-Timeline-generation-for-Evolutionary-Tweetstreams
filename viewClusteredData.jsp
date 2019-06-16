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
                var cluster_data_tweet = '${cluster_data_tweet}';
                $('#t_msg').val(cluster_data_tweet.trim());

                var cluster_data_retweet = '${cluster_data_retweet}';
                $('#t_msg1').val(cluster_data_retweet.trim());

                var clusterData = '${clusterData}';
                $('#key').val(clusterData.trim());

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
            <h2>Summarize below Clustered Data</h2><br>
            <form action="SummarizeCoreLevelServlet" id="target" method="post">
                <table>                   
                    <tr>
                        <td><b>Data to Be Summarized:(Cluster 1)</b></td>
                        <td>
                            <textarea name="tweet_msg"  id="t_msg" style="width: 400px;height: 150px"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td><b>Data to Be Summarized:(Cluster 2)</b></td>
                        <td>
                            <textarea name="tweet_msg1"  id="t_msg1" style="width: 400px;height: 150px"></textarea>
                        </td>
                    <input type="hidden" name="key" id="key">
                    </tr>

                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Summarize" style="padding: 10px; background-color: #17c762"/> &nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" value="Clear" id="t_sub" style="padding: 10px; background-color:#17c762 "/>
                        </td>
                    </tr>
                </table>

            </form>


        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

