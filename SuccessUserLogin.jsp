<%@page import="com.ieee.dao.FetchDAO"%>
<%@page import="com.ieee.pojo.Tweets"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <%@include file="header.jsp" %>
    <body>
        <div style="min-height: 500px;color: #fff;background-color: #2196f3;" align="center">            
            <%@include file="menu.jsp" %>   <br>
            <h3>Tweets</h3>
            <table cellpadding="15px">

                <%
                    Set set = (Set) session.getAttribute("tweets_set");
                    Set tweets_set = null;
                    int userId = (Integer) session.getAttribute("userId");
                    System.out.println("userId-->" + userId);
                    if (set == null) {
                        FetchDAO fd = new FetchDAO();
                        set = fd.retriveFollowerTweets(userId);
                        session.setAttribute("tweets_set", set);
                        tweets_set = set;
                    }
                    tweets_set = set;
                    System.out.println("tweets_set-->" + tweets_set);
                    Iterator i = tweets_set.iterator();
                    while (i.hasNext()) {
                        Tweets t = (Tweets) i.next();

                %>             
                <tr style="background-color: turquoise">
                    <td style="color: #fff"><%=t.getTweetedBy()%></td>
                    <td style="color: yellow"><%=t.getMsg()%></td>
                    <td><a href="showPageForReTweetServlet?tweetId=<%=t.getTweetId()%>">Re Tweet / Summarize</a></td>
                </tr>

                <%             }
                %>
            </table>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>

