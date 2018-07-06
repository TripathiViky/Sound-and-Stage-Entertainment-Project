
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
import models.SeatModel;


@WebServlet(name = "SeatController", urlPatterns = {"/SeatController"})
public class SeatController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SeatController</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet SeatController at " + request.getContextPath() + "</h1>");
            HttpSession session=request.getSession();
            int hallcode = (Integer)session.getAttribute("hallcode");
            String seatname= request.getParameter("txtseatname");

            String res="";
            SeatModel objseatm = new SeatModel();
            if(seatname!=null || seatname.length()>0)
            {
            int seatprice = Integer.parseInt(request.getParameter("txtprice"));
            
            objseatm.setHallcode(hallcode);
            objseatm.setSeatname(seatname);
            objseatm.setPrice(seatprice);
            res = objseatm.insert();
            res+="<hr/>";
                
            }
           // res+=objseatm.getRecordsByHallCode(hallcode);
            
            out.println(res);
            //out.println("<hr/>");
            //RequestDispatcher rd=request.getRequestDispatcher("admin/CreateSeat2.jsp");
            //rd.include(request, response);
            response.sendRedirect("admin/NewSeat2.jsp");
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
