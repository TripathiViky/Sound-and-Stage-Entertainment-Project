
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.LoggerModel;


@WebServlet(name = "LoggerDeleteController", urlPatterns = {"/LoggerDeleteController"})
public class LoggerDeleteController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoggerDeleteController</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet LoggerDeleteController at " + request.getContextPath() + "</h1>");
            
            out.println("<script type='text/javascript'> ");
            
            out.println("var myVar=setInterval(function () {myTimer()}, 1000);");
            out.println("var counter = 0;");
            
            out.println("function myTimer() {");
            out.println("counter = counter+1;");
            
            out.println("document.getElementById('lbl11').innerHTML =counter");
            out.println("if(counter==3)");
            out.println("{window.location='login.jsp'; }");
            out.println("}");
            out.println("</script>");
            
            out.flush();
            
            LoggerModel oblog=new LoggerModel();
            String msg=oblog.deleteAllLogs();
            out.println("<br/>"+msg);
            
            out.flush();
            out.println("<br/>");
            out.println("<font>Delete in <label id='lbl11' Style='font-weight: bold; '  ></label></font> <font>seconds..</font>");
            //out.println("</div>");
            out.flush();
            try
            {
                
                
                Thread.sleep(3000);
                
            }
            catch(Exception e)
            {
                out.println(e);
                out.flush();
            }
            
            
            //out.println("<script>");
            //out.println(" window.location='login.jsp';  ");
            //out.println("</script>");
           out.flush();
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
