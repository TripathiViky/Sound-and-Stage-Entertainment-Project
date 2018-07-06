
package models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutModel 
{
    public String getLogoutButton(HttpSession session, 
            HttpServletResponse response,
            String actionName) throws Exception
    {
        String res="";
        Object ouser=session.getAttribute("user");
        if(ouser==null)
        {
            response.sendRedirect(actionName);
        }
        
        res="<form name='formlogout' method='post' action='"+actionName+"'>";
        res+="<input type='submit' name='btnlogoutsubmit' value='Logout'/>";
        res+="</form>";
        return res;
    }
    
}
