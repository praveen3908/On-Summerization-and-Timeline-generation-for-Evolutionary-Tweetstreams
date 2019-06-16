<%-- 
    Document   : reTweetPage
    Created on : Feb 22, 2017, 12:02:24 AM
    Author     : Praveen
--%>


<%@page import="com.ieee.pojo.Tweets"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.ieee.dao.FetchDAO"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <script>
            $(document).ready(function() {
                $("#target").submit(function() {
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
            <h2>Retweet Here</h2><br>          


            <form action="StoreReTweetsServlet" id="target" method="post">
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



            <table cellpadding="15px">
                <%
                    Set tweets_set = (Set) session.getAttribute("retweets_set");
                    Iterator i = tweets_set.iterator();
                    while (i.hasNext()) {
                        Tweets t = (Tweets) i.next();

                %>             
                <tr style="background-color: turquoise">
                    <td style="color: #fff"><%=t.getTweetedBy()%></td>
                    <td style="color: yellow"><%=t.getMsg()%></td>
                </tr>

                <%             }
                %>

            </table>

            <br><br>
            <h3>Summarize Here</h3>
            <form action="SummarizeTweetsServlet" method="POST">
            <table cellpadding="8">
                <tr>
                    <td>Summarize Data(Cluster based on):</td>
                    <td><input type="text" name="clusterData" required="true"></td>
                </tr>
                <tr>
                    <td>From Date</td>
                    <td><input type="date" name="fdt" required=""></td>
                </tr>
                <tr>
                    <td>To Date</td>
                    <td><input type="date" name="tdt" required=""></td>
                </tr>

                <tr>
                    <td align="center" colspan="2"><input type="submit" value="Summarize" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff;border-radius: 10px ">
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff;border-radius: 10px "></td>
                </tr>

            </table>
            </form>
            <br><br>
                
            </table>
            
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

