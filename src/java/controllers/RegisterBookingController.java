
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.BookingSeatDetailModel;
import models.BookingSeatModel;
import models.LayoutPlanHallViewModel;
import models.LayoutPlanModel;


@WebServlet(name = "RegisterBookingController", urlPatterns = {"/RegisterBookingController"})
public class RegisterBookingController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterBookingController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterBookingController at " + request.getContextPath() + "</h1>");
            ServletContext application=getServletContext();
            application.setAttribute("bookingpageopened", "false");
            
            HttpSession session=request.getSession();
            //String[] arrUniqueCode=(String[])session.getAttribute("seatsselected");
            String[] arrUniqueCode=request.getParameterValues("chkseat");
            
            int[] arrucode=new int[arrUniqueCode.length];
            for(int i=0;i<arrUniqueCode.length;i++)
            {
                arrucode[i]=Integer.parseInt(arrUniqueCode[i]);
            }
            String custname=request.getParameter("txtcustname");
            String contactno=request.getParameter("txtcontactno");
            String idprooftype=request.getParameter("cmbidprooftype");
            String idproofno=request.getParameter("txtidproofno");
            
            BookingSeatModel obbs=new BookingSeatModel();
            obbs.setCustname(custname);
            obbs.setContactno(contactno);
            obbs.setIdprooftype(idprooftype);
            obbs.setIdproofno(idproofno);
            
            String res=obbs.insert();
            
            res+="<br/>your booking code is: <font size='100'><b>"+obbs.getBookingcode()+"</b></font>";
            res+="<h2>please bring your booking id to Hall POS</h2>";
            res+="<hr/>";
            
            BookingSeatDetailModel objbsd=new BookingSeatDetailModel();
            
            models.LayoutPlanHallViewModel oblphvm=new LayoutPlanHallViewModel();
            
            models.LayoutPlanModel oblpm=new LayoutPlanModel();
            
            for(int i=0;i<arrucode.length;i++)
            {
                objbsd.setBookingcode(obbs.getBookingcode());
                objbsd.setUniquelayoutplancode(arrucode[i]);
                int price=oblphvm.getSeatPriceByUniqueLayoutPlanCode(arrucode[i]);
                objbsd.setPrice(price);
                res+="<br/>"+objbsd.insert();
                res+="<br/>"+oblpm.updateBookingStatusByUniqueLayoutPlanCode(arrucode[i], 1);
                
                
            }
            /*
            session.removeAttribute("seatsselected");
            session.removeAttribute("moviecode");
            session.removeAttribute("bookingdate");
            */
           session.setAttribute("bookingcode", obbs.getBookingcode());
            
            request.setAttribute("result", res);
            
            RequestDispatcher rd=request.getRequestDispatcher("BookingForm5.jsp");
           rd.forward(request, response);
            
            out.println("<br/>ok");
            
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
