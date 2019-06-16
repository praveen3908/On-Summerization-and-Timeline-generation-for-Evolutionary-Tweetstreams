<%-- 
    Document   : PostTweets
    Created on : Jan 4, 2017, 10:22:36 AM
    Author     : Praveen
--%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <script>
            $(document).ready(function() {
                $("form").submit(function() {
                    var msg=$('#t_msg').val();
                    if(msg == "" || msg==" "){
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
            <h2>Tweet Here</h2><br>
            <form action="StoreTweetsServlet" id="target" method="post">
                <table>
                    <td><img src="images/this.png"></td>
                    <td>
                        <table>
                            <tr>
                                <td><b>Tweet:</b>
                                </td>
                                <td>
                                    <textarea name="tweet_msg" id="t_msg" style="width: 300px"></textarea>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="2" align="center"><input type="submit" value="Tweet" style="padding: 10px; background-color: #17c762"/> &nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="reset" value="Clear" id="t_sub" style="padding: 10px; background-color:#17c762 "/>
                                </td>
                            </tr>
                        </table>

                    </td>

                </table>

            </form>


        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

