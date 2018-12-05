package view;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FileDetail;
import javax.servlet.annotation.WebServlet;
import logic.FileDetailLogic;
import logic.FileLogic;


/**
 *
 * @author Shawn
 */
@MultipartConfig
@WebServlet(name="FileForm",urlPatterns= {"/FileForm"},loadOnStartup=1)
public class FileForm extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage = null;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>File Form</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\"text-align: center;\">");
            out.println("<div style=\"display: inline-block; text-align: left;\">");
            out.println("<form action=\"FileForm\" method=\"post\" enctype=\"multipart/form-data\">");
            out.println("Name:<br>");
            out.printf("<input type=\"text\" name=\"%s\" value=\"\"><br>",FileDetail.COL_NAME);
            out.println("Type:<br>");
            out.printf("<input type=\"text\" name=\"%s\" value=\"\"><br><br>",FileDetail.COL_TYPE);
            out.println("<input type=\"file\" name=\"file\" /><br>");
            out.println("<input type=\"submit\" name=\"view\" value=\"Upload and View\">");
            out.println("<input type=\"submit\" name=\"upload\" value=\"Upload\">");
            out.println("</form>");
            if(errorMessage!=null&&!errorMessage.isEmpty()){
                out.println("<p color=red>");
                out.println("<font color=red size=4px>");
                out.println(errorMessage);
                out.println("</font>");
                out.println("</p>");
            }
            out.println("<pre>");
            out.println("Submitted keys and values:");
            out.println(toStringMap(request.getParameterMap()));
            out.println("</pre>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String toStringMap(Map<String, String[]> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach((k, v) -> builder.append("Key=").append(k)
                .append(", ")
                .append("Value/s=").append(Arrays.toString(v))
                .append(System.lineSeparator()));
        return builder.toString();
    }
    
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
//        processRequest(request, response);
          request.getRequestDispatcher("/WEB-INF/fileForm.jsp").forward(request, response);
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
        if( request.getParameter("upload")!=null){
			int generatedKey = addFile(request);
        FileDetailLogic dLogic = new FileDetailLogic();
            processRequest(request, response);
        }else if (request.getParameter("view")!=null) {
            int generatedKey = addFile(request);
            response.sendRedirect("FileTableFancy");
        }else{
            processRequest(request, response);
        }
    }
    
    private int addFile( HttpServletRequest request) throws IOException, ServletException{
        FileLogic fLogic = new FileLogic();
         
        return fLogic.addFile( request.getPart("file").getInputStream());
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
