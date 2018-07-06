
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.SeatModel;


@WebServlet(name = "DeleteSeatController", urlPatterns = {"/DeleteSeatController"})
public class DeleteSeatController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteSeatController</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet DeleteSeatController at " + request.getContextPath() + "</h1>");
           String str=request.getParameter("operation");
           if(str.equals("delete"))
           {
           
           int seatcode=Integer.parseInt(request.getParameter("id"));
           out.println("seatcode="+seatcode);
           
            SeatModel obseat=new SeatModel();
            String result=obseat.deleteRecordBySeatCode(seatcode);
            out.println(result);
               response.sendRedirect("admin/NewSeat2.jsp");
           }
           else if(str.equals("edit"))
           {
               
                   int seatcode=Integer.parseInt(request.getParameter("id"));
                   out.println("<center>seatcode to modify: "+seatcode+ "</center>");
                   SeatModel obseat=new SeatModel();
                   Map<String, String> map=obseat.getOneRecordBySeatCode(seatcode);
                   out.println("<form name='form1' method='post' action='EditSeatController'>");
                   out.println("<input type='hidden' name='txtseatcode' value='"+seatcode+"'/>");
                   String form="<table border='1' align='center' margin='1em auto'>";
                  form+="<tr>";
                   form+="<td>seat name</td>";
                   form+="<td><input type='text' name='txtseatname' value='"+map.get("SEATNAME")+"'/></td>";
                  form+="</tr>";
                  form+="<tr>";
                   form+="<td>seat price</td>";
                   form+="<td><input type='text' name='txtprice' value='"+map.get("PRICE")+"'/></td>";
                  form+="</tr>";
                  form+="<tr>";
                  form+="<td colspan='2'><input type='submit' name='btnsubmit' value='Modify Seat'/></td>";
                  form+="</tr>";
                   form+="</table>";
                   
                   out.println(form);
                   out.println("</form>");
               
           }
           
            
            //RequestDispatcher rd=request.getRequestDispatcher("admin/CreateSeat2.jsp");
            //rd.include(request, response);
           // rd.forward(request, response);
           
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
