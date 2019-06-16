<%-- 
    Document   : Register
    Created on : Dec 22, 2014, 4:28:17 PM
    Author     : Praveen
--%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="jquery-1.12.0.min.js"></script>
        <script src="jquery-migrate-1.2.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hybrid</title>
        <style>
            a:hover{
                color: red;
            }
        </style>
        <script>

        </script>
        <script>
            $(document).ready(function() {
                $("#gimg").hide();
                $("#rimg").hide();            
                              
            });
            
            function validateForm() {
              
                var y = document.forms["RegForm"]["mob"].value;
                if (y.length != 10) {
                    alert("Mobile Number should be 10 length");
                    return false;
                }
                
                if (/\D/.test(y) || y == "")
                {
                    alert("Please enter only numeric mobile(Allowed input:0-9)")
                    return false;
                }

                var mail = document.forms["RegForm"]["c"].value;        
            
                
                if (/^([A-Za-z0-9_\-\.])+\@([gmail|GMAIL])+\.(com)$/.test(mail)) {
                } else {
                    alert("not valid mail");
                    return false;
               }
                
            }

            function checkduplicateid() {
                var mail = document.getElementById('mail').value;
                $.ajax({
                    url: "DupliacteCheckServlet?mail=" + mail,
                    success: function(data) {
                        if (data.trim() != "Proceed") {
                            alert("MAIL ID--> " + mail + " already exist");
                            $("#rimg").show(1000);
                            $("#gimg").hide();
                            document.getElementById('mail').value = "";
                            return false;
                        } else {
                            $("#gimg").show(1000);
                            $("#rimg").hide();
                        }
                    }

                }
                );
            }
        </script>
    </head>
    <body>
        <div style="min-height: 500px;color: #fff;background-color: #2196f3;" align="center">
              <br>
            <div align="left">
                <a href="index.jsp"><img src="images/homeicon.png" width="80px" height="80px"></a>
            </div>
            <img src="images/register-now.png" height="90px" width="400px"></br></br>
            <form name="RegForm" action="RegisterUserServlet" onsubmit="return validateForm()">
                <table cellpadding="8">
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" required=""></td>
                    </tr>
                    <tr>
                        <td>Mail Id(Login):</td>
                        <td><div><input type="text" name="c" required="" id='mail' onblur="return checkduplicateid();">                                
                                <img id='gimg' src="images/green-checkmark.png" height="20px" width="30px">  
                                <img id='rimg' src="images/wrong.gif" height="20px" width="30px">  
                            </div>                        
                        </td>                    

                    </tr>
                    <tr>
                        <td>Mobile No:</td>
                        <td><input type="text" name="mob" required="" maxlength="10"></td>
                    </tr>
                 
                    <tr>
                        <td>Choose Password:</td>
                        <td><input type="password" name="pwd" required="" maxlength="10"></td>
                    </tr>
                    
                    <tr>
                        <td align="center" colspan="2"><input type="submit" value="Register" onsubmit="return validateForm();" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff"/>
                            &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear" style="background-color:#0066FF;width: 100px;padding: 7px;color: #fff "></td>
                    </tr>

                </table>
            </form>
            <br>
        </div>
    </body>
    <%@include file="footer.jsp" %>
</html>
