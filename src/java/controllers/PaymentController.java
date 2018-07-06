
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
import models.BookingSeatModel;
import models.PaymentDetailModel;


@WebServlet(name = "PaymentController", urlPatterns = {"/PaymentController"})
public class PaymentController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PaymentController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentController at " + request.getContextPath() + "</h1>");
            HttpSession hs = request.getSession();
            int bookingcode=(Integer)hs.getAttribute("bookingcode");
            String ccholdername=request.getParameter("txtccholdername");
            String ccnumber=request.getParameter("txtccnumber");
            String cvnumber=request.getParameter("txtcvvnumber");
            String validupto=request.getParameter("txtdate");
            int amount=Integer.parseInt(request.getParameter("txtamount"));
            
            
            
            out.println(bookingcode+", "+ccholdername+", "+ccnumber+", "+
                    cvnumber+","+validupto+", "+amount);
            
            models.PaymentDetailModel obpdm=new PaymentDetailModel();
            obpdm.setBookingCode(bookingcode);
            obpdm.setcHolder(ccholdername);
            obpdm.setCcNo(ccnumber);
            obpdm.setCvno(cvnumber);
            obpdm.setValidupto(validupto);
            obpdm.setAmount(amount);
            String res=obpdm.insert();
            request.setAttribute("result", res);
            out.println(res);
            
            BookingSeatModel obbs=new BookingSeatModel();
            res+="<br/>"+obbs.updatePayStatusByBookingCode(bookingcode);
            
            RequestDispatcher rd=request.getRequestDispatcher("BookingForm6.jsp");
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
