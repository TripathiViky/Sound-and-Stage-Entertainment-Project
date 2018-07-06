
package validations;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.TheaterModel;

@WebFilter (urlPatterns = {"/TheaterEditDeleteController"})
public class TheaterEditDeleteValidation1 implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1=(HttpServletRequest)request;
        HttpServletResponse response1= (HttpServletResponse)response;
        String operation=request.getParameter("operation");
        int id = Integer.parseInt(request.getParameter("id"));
        if(operation.equals("delete"))
        {
            TheaterModel obt = new TheaterModel();
            boolean check = obt.checkRecordsExistsInHallByTheaterCode(id);
            if(check == true)
            {
                HttpSession session = request1.getSession();
                session.setAttribute("result", "cannot  delete theater as record exists in hall");
                response1.sendRedirect("admin/NewTheatre.jsp");
                return;
            }
            
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    
}
