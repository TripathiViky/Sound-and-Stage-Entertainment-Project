
package validations;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.BookingSeatModel;


@WebFilter(urlPatterns = {"/DeleteSeatController"})
public class DeleteSeatValidation1 implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String operation=request.getParameter("operation");
        int id=Integer.parseInt(request.getParameter("id"));
        if(operation.equals("delete"))
        {
            BookingSeatModel obseat=new BookingSeatModel();
            boolean check=obseat.checkRecordExistsInLayoutPlanBySeatCode(id);
            if(check==true)
            {
                PrintWriter pw=response.getWriter();
                pw.println("<br/>such seat id exist in layoutplan and so cannot be deleted");

                String path=request.getServletContext().getContextPath();
                pw.println("<br/>path");
               
               
                HttpServletResponse response1=(HttpServletResponse)response;
                HttpServletRequest request1=(HttpServletRequest)request;
                HttpSession session1=request1.getSession();
                session1.setAttribute("result", "such seat already exists in layoutplan and so cannot be deleted");
                response1.sendRedirect("admin/NewSeat2.jsp");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    
    
}
