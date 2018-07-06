
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.SnackModel;


@WebServlet(name = "SnackEditDeleteController", urlPatterns = {"/SnackEditDeleteController"})
public class SnackEditDeleteController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SnackEditDeleteController</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet SnackEditDeleteController at " + request.getContextPath() + "</h1>");
            String op = request.getParameter("operation");
            int scode = Integer.parseInt(request.getParameter("id"));
            SnackModel obs=new SnackModel();
            if(op.equals("delete"))
            {
                obs.deleteRecordsBySnackCode(scode);
                response.sendRedirect("admin/NewSnack2.jsp");
               
            }
            else if(op.equals("edit"))
            {
                Map<String, String> map=obs.getOneRecordsBySnackCode(scode);
                out.println("<form name='form1' method='post' action='EditSnackController'>");
                   out.println("<input type='hidden' name='txtscode' value='"+scode+"'/>");
                   String form="<table border='1' table-align='auto'>";
                  form+="<tr>";
                   form+="<td>Snack name</td>";
                   form+="<td><input type='text' name='txtsnackname' value='"+map.get("NAME")+"'/></td>";
                  form+="</tr>";
                  form+="<tr>";
                   form+="<td>Price </td>";
                   form+="<td><input type='text' name='txtprice' value='"+map.get("PRICE")+"'/></td>";
                  form+="</tr>";
                  form+="<tr>";
                  form+="<td align='center'><input type='submit' name='btnsubmit' value='Modify Snack'/></td>";
                  form+="</tr>";
                   form+="</table>";
                   
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
