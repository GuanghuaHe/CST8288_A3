/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.FileDetail;
import dto.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.FileDetailLogic;
import logic.StudentLogic;

/**
 *
 * @author rainy
 */
@WebServlet(name = "FileDetailServlet", urlPatterns = {"/FileDetailServlet"})
public class FileDetailServlet extends HttpServlet {
       
	private FileDetailLogic fileDetailLogic = new FileDetailLogic();
        List<FileDetail> fileDetails;
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
            out.println("<title>Students table</title>");            
            out.println("</head>");
            out.println("<body>");
            
           
          
            out.println("<table border=\"1\" cellpadding=\"3\" cellspacing=\"5\" style=\"width: 60%;margin:auto\">");
            out.println("<caption>Students</caption>");
            out.println("<tr>");
            out.println("<th>FILE ID</th>");
            out.println("<th>FILE Name</th>");
            out.println("<th>FILE TYPE</th>");
            out.println("<th>CREATE TIME</th>");
            out.println("<th>FILE SIZE</th>");
              
             
            out.println("</tr>");
            fileDetails = fileDetailLogic.getAllFileDetail();
            fileDetails.forEach((fd) -> {
                out.printf("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                        fd.getFile_id(), fd.getName(),fd.getType(),fd.getDate(),fd.getSize());
            });
            
            out.println("</table>");
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
