/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.LoggerModel;
import models.SnackPaymentModel;
import dao.ClassDb;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Dear Kallu
 */
@WebServlet(name = "SnackPaymentController", urlPatterns = {"/SnackPaymentController"})
public class SnackPaymentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SnackPaymentController</title>");            
            out.println("</head>");
            out.println("<body>");
            
            SnackPaymentModel obspm = new SnackPaymentModel();
            HttpSession session = request.getSession();
            int bcode = (Integer)session.getAttribute("bookingcode");
            String ccHolderName = request.getParameter("txtccholdername");
            String ccnumber=request.getParameter("txtccnumber");
            String cvnumber=request.getParameter("txtcvvnumber");
            String validupto=request.getParameter("txtdate");
            int amount=Integer.parseInt(request.getParameter("txtamount"));
            obspm.setBookingcode(bcode);
            obspm.setCardholder(ccHolderName);
            obspm.setCcno(ccnumber);
            obspm.setCvno(cvnumber);
            obspm.setValidupto(validupto);
            obspm.setAmount(amount);
            String res = obspm.insert();
            res+=obspm.getRecordsByBookingCode(bcode);
            
            ClassDb obj=new ClassDb();
            res+="<br/>"+
                    obj.transferSnackRecordsFromTempToOriginalTableByBookingCode(bcode);


            LoggerModel oblog=new LoggerModel();
            oblog.insertFromWebpage(session, "snackpayment,"+bcode+","+amount);
            
            
            out.println("<center><br/>"+res);
            out.println("</center></body>");
            out.println("</html>");
            RequestDispatcher rd=request.getRequestDispatcher("pos/Menu.jsp");
            rd.include(request, response);
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
