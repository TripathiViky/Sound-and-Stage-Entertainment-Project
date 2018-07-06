
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


@WebServlet(name = "LayoutPlanController", urlPatterns = {"/LayoutPlanController"})
public class LayoutPlanController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LayoutPlanController</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session=request.getSession();
            
            int hallcode=(Integer)session.getAttribute("hallcode");
            String plandate=(String) session.getAttribute("plandate");
            double starttime=(Double)session.getAttribute("starttime");
            double endtime=(Double)session.getAttribute("endtime");
            int moviecode=(Integer)session.getAttribute("moviecode");
            
            models.LayoutPlanModel obPlan=new models.LayoutPlanModel();
            
            
            String[] arr=request.getParameterValues("chk");
            int[] validseatcode=new int[arr.length];
            
            for(int i=0;i<arr.length;i++)
            {
                validseatcode[i]=Integer.parseInt(arr[i]);
            }
            
            obPlan.setPlandate(plandate);
            obPlan.setStarttime(starttime);
            obPlan.setEndtime(endtime);
            obPlan.setMoviecode(moviecode);
            
            String result=obPlan.insert(hallcode, validseatcode);
            result+="<br/>";
            result+=obPlan.getLastPlanByHallCode(hallcode);
            //out.println(result);
            
            session.removeAttribute("hallcode");
            session.removeAttribute("plandate");
            session.removeAttribute("starttime");
            session.removeAttribute("endtime");
            session.removeAttribute("moviecode");
            
            request.setAttribute("result", result);
            RequestDispatcher rd=request.getRequestDispatcher("admin/NewShowPlanResult.jsp");
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
