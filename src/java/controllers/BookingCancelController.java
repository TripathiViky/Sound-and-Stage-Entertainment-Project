
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.BookingSeatDetailModel;
import models.BookingSeatModel;


@WebServlet(name = "BookingCancelController", urlPatterns = {"/BookingCancelController"})
public class BookingCancelController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingCancelController</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session = request.getSession();
            int bcode = (Integer)session.getAttribute("bookingcode");
            out.println(bcode);
            
            BookingSeatModel obbs=new BookingSeatModel();
            boolean check=obbs.checkPaidOrNotByBookingCode(bcode);
            if(check==true)
            {
                out.println("already made payment!cannot delete/remove booking");
                
            return;
            }
            
            out.println("<br/>check="+check);
            BookingSeatDetailModel obbsdm=new BookingSeatDetailModel();
            String res=obbsdm.updateLayoutPlanBookingStatusCancellationByBookingCode(bcode);
            
            res+="<br/>"+obbsdm.deleteBookingDetailsByBookingCode(bcode);
            res+="<br/>"+obbs.deleteBookingByBookingCode(bcode);
            
            request.setAttribute("result", res);
            
            RequestDispatcher rd=request.getRequestDispatcher("pos/CancelBooking3.jsp");
            rd.forward(request, response);
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
