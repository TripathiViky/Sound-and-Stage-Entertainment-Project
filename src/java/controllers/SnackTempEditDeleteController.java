
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.BookingSnackTempModel;


@WebServlet(name = "SnackTempEditDeleteController", urlPatterns = {"/SnackTempEditDeleteController"})
public class SnackTempEditDeleteController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SnackTempEditDeleteController</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet SnackTempEditDeleteController at " + request.getContextPath() + "</h1>");
            String op = request.getParameter("operation");
            int tempid = Integer.parseInt(request.getParameter("id"));
            
            out.println(op+", "+tempid);
            
            if(op.equals("delete"))
            {
                new BookingSnackTempModel().deleteRecordsByTempId(tempid);
                response.sendRedirect("pos/SnackBooking2.jsp");
                
            }
            else if(op.equals("edit"))
            {
                HttpSession session=request.getSession();
                int bookingcode=(Integer)session.getAttribute("bookingcode");
                BookingSnackTempModel obstm=new BookingSnackTempModel();
                Map<String, String> map=obstm.getOneRecordsByTempId(tempid);
                out.println("<form name='form1' method='post' action='EditSnackTempController'>");
                   out.println("<input type='hidden' name='txttid' value='"+tempid+"'/>");
                   out.println("<input type='hidden' name='txtprice' value='"+map.get("PRICE")+"'/>");
                   String form="<table border='1'>";
                  
                  form+="<tr>";
                   form+="<td>Quantity</td>";
                   
                   form+="<td><input type='text' name='txtquantity' value='"+map.get("QUANTITY")+"'/></td>";
                  form+="</tr>";
                  
                  form+="<tr>";
                  form+="<td align='center'><input type='submit' name='btnsubmit' value='Modify '/></td>";
                  form+="</tr>";
                   form+="</table>";
                   form+="</form>";
                   out.println(form);
                
          
            }
            
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
