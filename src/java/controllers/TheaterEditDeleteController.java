
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
import javax.servlet.http.HttpSession;
import models.TheaterModel;


@WebServlet(name = "TheaterEditDeleteController", urlPatterns = {"/TheaterEditDeleteController"})
public class TheaterEditDeleteController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TheaterEditDeleteController</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String operation = request.getParameter("operation");
            int id = Integer.parseInt(request.getParameter("id"));
            out.println("<br/>operation="+operation+","+id);
            if(operation.equals("delete"))
            {
                TheaterModel obt = new TheaterModel();
                String result = obt.deleteByTheaterCode(id);
                HttpSession session = request.getSession();
                session.setAttribute("result", result);
                response.sendRedirect("admin/NewTheatre.jsp");            
            }
            else if(operation.equals("edit"))
            {
                out.println("operation="+operation);
                TheaterModel obt=new TheaterModel();
                Map<String, String> map=obt.getOneRecordByTheaterCode(id);
                String form = "<form name='form1' method='post' action='TheaterEditController'>";
                form+="<input type='hidden' name='txttheatercode' value='"+id+"'/>";
                form +="<style>"
                   + "#customers {\n" +
"    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
"    border-collapse: collapse;\n" +
"    width: 100%;\n" +
"}\n" +
"\n" +
"#customers td, #customers th {\n" +
"    border: 1px solid #ddd;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
"#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
"\n" +
"\n" +
"\n" +
"#customers th {\n" +
"    padding-top: 30px;\n" +
"    padding-bottom: 8px;\n" +
"    text-align: center;\n" +
"    background-color: #4CAF50;\n" +
"    color: white;\n" +
"}"
                   + "</style>"
                   + "<table id='customers' border='1' align='center'> " +
                "<tr>" +
                "<td>Theater Name :</td> " +
                "<td><input type='text' name='txtname' required value='"+ map.get("NAME") +"' /></td> " +
                "</tr> " +
                "<tr> " +
                "<td>Theater Location :</td> " +
                "<td><input type='text' name='txtlocation' required value='"+map.get("LOCATION")+"' /></td> " +
                "</tr> " +
                "<tr> " +
                "<td colspan='2' align='center'><input type='submit' value='Modify'/></td> " +
                "</tr> " +
                "</table>"+
                        "</form>";
                
                
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
