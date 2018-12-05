package view;

import dto.Group;
import dto.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.GroupLogic;
import logic.StudentLogic;

/**
 * Servlet implementation class GroupServlet
 */
@WebServlet(name="GroupServlet",urlPatterns= {"/group"},loadOnStartup=1)
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String errorMessage = null;
	private GroupLogic logic = new GroupLogic();

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Group table</title>");            
            out.println("</head>");
            out.println("<body>");
            
           
         List<Group> groups = logic.getAllGroup();
            out.println("<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" style=\"width: 60%;margin:auto\">");
            out.println("<caption>Groups</caption>");
            out.println("<tr>");
            out.println("<th>Group ID</th>");
            out.println("<th>Group Name</th>");
           out.println("<th>Action</th>");
            out.println("</tr>");
            groups.forEach((group) -> {
                out.println("<tr><td>"+group.getId()+"</td><td>"+group.getName()+"</td>"
                        + "<td><a href='/Assignment3/Student?id="+ group.getId()+"'>show students</a></td></tr>"
                        );
            });
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }


	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
