
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
import dao.UserMasterBean;
import javax.servlet.RequestDispatcher;


@WebServlet(name = "ChangePasswordController", urlPatterns = {"/ChangePasswordController"})
public class ChangePasswordController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePasswordController</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ChangePasswordController at " + request.getContextPath() + "</h1>");
            HttpSession session=request.getSession();
            String newpassword=request.getParameter("txtpassword");
            Map<String, String> user=(Map<String,String>)session.getAttribute("user");
            String username=user.get("USERNAME");
            
            int usertype=Integer.parseInt(user.get("USERTYPE"));
            
            UserMasterBean obuser=new UserMasterBean();
            String res=obuser.changePasswordByUserName(username, newpassword);
           
            obuser.setUsername(username);
            obuser.setUsertype(usertype);
            obuser.setPassword(newpassword);
           Map<String, String> newmap= obuser.getOneRecordValue();
           
           session.setAttribute("user", newmap);
            session.setAttribute("result", res);
            
//            if(usertype==0)
//                response.sendRedirect("admin/AdminMenu.jsp");
//            else if(usertype==1)
//                response.sendRedirect("pos/POSMenu.jsp");
            RequestDispatcher rd=request.getRequestDispatcher("LogoutController");
                rd.forward(request, response);
            
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
