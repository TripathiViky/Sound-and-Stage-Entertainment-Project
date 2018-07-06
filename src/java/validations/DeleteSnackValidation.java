
package validations;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.SnackModel;


@WebFilter(urlPatterns = {"/SnackEditDeleteController"})
public class DeleteSnackValidation implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         String operation=request.getParameter("operation");
        int id=Integer.parseInt(request.getParameter("id"));
        if(operation.equals("delete"))
        {
            boolean check=new SnackModel().checkExistsRecordsInBookingSnackBySnackCode(id);
            if(check==true)
            {
                HttpServletRequest request1=(HttpServletRequest)request;
                HttpServletResponse response1=(HttpServletResponse)response;
                HttpSession session= request1.getSession();
                session.setAttribute("result", "such snack already exists in BookingSnack and so cannot be deleted");
                response1.sendRedirect("admin/NewSnack1.jsp");
                return;
            }
            
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    
    
}
