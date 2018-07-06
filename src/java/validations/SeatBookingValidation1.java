
package validations;

import java.io.IOException;
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


@WebFilter(urlPatterns = {"/RegisterBookingController"})
public class SeatBookingValidation1 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String[] seatsuniquecode=request.getParameterValues("chkseat");
        
        if(seatsuniquecode==null)
            {
                HttpServletResponse res = (HttpServletResponse)response;
                HttpServletRequest req=(HttpServletRequest)request;
                HttpSession ses= req.getSession();
                ses.setAttribute("result", "No Seat Booked");
                res.sendRedirect("BookingForm1.jsp");
                return;
            }
            chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    
    
}
