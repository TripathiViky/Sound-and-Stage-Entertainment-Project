
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.LayoutPlanHallViewModel;
import models.SnackModel;


@WebServlet(name = "BookingController", urlPatterns = {"/BookingController"})
public class BookingController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingController at " + request.getContextPath() + "</h1>");
            String[] seatsuniquecode=request.getParameterValues("chkseat");
            if(seatsuniquecode==null)
            {
                out.println("no seats booked");
                return;
            }
            LayoutPlanHallViewModel oblpvm=new LayoutPlanHallViewModel();
            for(int i=0;i<seatsuniquecode.length;i++)
            {
                int seatuniquelayoutplancode=Integer.parseInt(seatsuniquecode[i]);
                int price=oblpvm.getSeatPriceByUniqueLayoutPlanCode(seatuniquelayoutplancode);
                out.println("<br/>"+seatuniquelayoutplancode+", "+price);
            }
            
            String chksnackstatus=request.getParameter("chkwantsnacks");
            if(chksnackstatus!=null)
            {
                int snackcode=Integer.parseInt(request.getParameter("cmbsnackcode"));
                int quantity=Integer.parseInt(request.getParameter("txtsnackquantity"));
                SnackModel obsm=new SnackModel();
                int price=obsm.getPriceBySnackCode(snackcode);
                int total=price*quantity;
                out.println(snackcode+", "+quantity+", unitprice="+price+", total Rs."+total+"/=");
            }
            else
                out.println("<br/>snacks NOT selected");
            
            
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
