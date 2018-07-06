
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "BookingCrashedController", urlPatterns = {"/BookingCrashedController"})
public class BookingCrashedController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingCrashedController</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet BookingCrashedController at " + request.getContextPath() + "</h1>");
            out.println("<label id='label1' />");
            out.flush();
            ServletContext sc = getServletContext();
            sc.setAttribute("bookingpageopened", "false");
            int i=1, j=3;
            while(i<=3)
            {
                out.println("redirecting to start page...");
                out.flush();
                out.println("<script type='text/javascript'>");
                out.println("document.getElementById('label1').value='redirecting to start page in ..."+j+"' ");
                out.flush();
                out.println("</script>");
                out.flush();
                try
                {
                    Thread.sleep(1000);
                    j--;
                }
                catch(Exception e)
                {
                    out.println(e);
                    out.flush();
                }
                i++;
            }
            response.sendRedirect("index.jsp");
            
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
