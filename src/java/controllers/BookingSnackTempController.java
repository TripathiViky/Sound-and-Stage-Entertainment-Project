
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
import models.BookingSnackTempModel;
import models.SnackModel;

@WebServlet(name = "BookingSnackTempController", urlPatterns = {"/BookingSnackTempController"})
public class BookingSnackTempController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingSnackTempController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingSnackTempController at " + request.getContextPath() + "</h1>");
            BookingSnackTempModel obbstm = new BookingSnackTempModel();
            SnackModel obsm=new SnackModel();
            HttpSession session= request.getSession();
            
            int bcode = (Integer)session.getAttribute("bookingcode");
            String txtquantity=request.getParameter("txtquantity");
            String res="";
            if( txtquantity!=null && txtquantity.length()>0 )
            {
            int scode = Integer.parseInt(request.getParameter("cmb1"));
            int price = obsm.getPriceBySnackCode(scode);
            int quantity=Integer.parseInt(request.getParameter("txtquantity"));
            int totalprice=price*quantity;
            if(quantity > 0){
            obbstm.setBookingcode(bcode);
            obbstm.setSnackcode(scode);
            
            obbstm.setQuantity(quantity);
            obbstm.setPrice(price);
            obbstm.setTotalprice(totalprice);
            
            res = obbstm.insert();
            }
            
            String res1=obbstm.getRecordsWithDeleteAndEditButtonByBookingcode(bcode, "../SnackTempEditDeleteController");
            res+=res1;
           session.setAttribute("snackrecords", res);
           //request.setAttribute("result", res);
           //out.println("<br/>"+res);
          
           session.setAttribute("checkpaystate", "checked");
           
          // out.println("<br/>");
           //out.println("<form name='form1' method='post' action='BookingSnackConfirmPayment.jsp'>");
           //out.println("<input type='submit' name='btnsubmit' value='Confirm Purchase and Make Payment'/>");
           //out.println("</form>");
            //out.println("<hr/>");
            
            //RequestDispatcher rd= request.getRequestDispatcher("pos/BookingSnack2.jsp");
            //rd.include(request, response);
            response.sendRedirect("pos/SnackBooking2.jsp");
            }
           out.println("<hr/>");
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
