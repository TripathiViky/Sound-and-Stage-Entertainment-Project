
package validations;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.HallModel;


@WebFilter(urlPatterns = {"/HallEditDeleteController"})
public class DeleteHallValidation implements Filter 
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String operation=request.getParameter("operation");
        int id=Integer.parseInt(request.getParameter("id"));
        if(operation.equals("delete"))
        {
            HallModel obh=new HallModel();
            
            boolean check = obh.checkRecordsExistsInSeatByHallCode(id);
            if(check==true)
            {
                HttpServletRequest request1=(HttpServletRequest)request;
                HttpServletResponse response1=(HttpServletResponse)response;
                HttpSession session= request1.getSession();
                session.setAttribute("result", "such hall already exists in seat and so cannot be deleted");
                response1.sendRedirect("admin/NewHall1.jsp");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    
}
