<%-- 
    Document   : newjsp
    Created on : 2 Jul, 2018, 11:59:35 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script type="text/javascript">
        function change()
        {
            var vl=document.form1.slt.value;
            //document.getElementById("sett").value=v1;
            window.location.replace("newjsp.jsp?name="+vl);
        }
        
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
       <form name="form1" >
            <table align="center">
                <tr>
                    <td>User Type</td>
                    <td>
                        <select name="slt" onchange="change()">
                            <option>Select item</option>
                            <option value="0">Admin</option>
                            <option value="1">POS Officer</option>
                        </select>
                    </td>
                </tr>
            </table>
        </form> 
       <script language="javascript" type="text/javascript">
        function call(){
            var name = "xyz";
            
        }
    </script>
    <input type="button" value="Get" onclick='call()'>
    <%
        String str = request.getParameter("name");
        if(str!=null)
        {
          int s = Integer.parseInt(str);
        out.println(s);  
        }
        
     //${param.name}   
    %>
        
    </body>
</html>
