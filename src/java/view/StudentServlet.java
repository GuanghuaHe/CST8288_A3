package view;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Student;
import java.io.PrintWriter;


import logic.StudentLogic;

@SuppressWarnings("serial")
@WebServlet(name="studentServlet",urlPatterns= {"/student"},loadOnStartup=1)
public class StudentServlet extends HttpServlet{
	private String errorMessage = null;
	private StudentLogic studentLogic = new StudentLogic();
        List<Student> students;
        
        
        
        
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
            out.println("<th>Student ID</th>");
            out.println("<th>Student FirstName</th>");
              out.println("<th>Student LastName</th>");
             out.println("<th>Edit Student</th>");
             out.println("<th>Delete Student</th>");
            out.println("</tr>");
            students.forEach((student) -> {
                out.printf("<tr><td>%s</td><td>%s</td><td>%s</td>"
                        + "<td><a href='/Assignment3/StudentUpdate?type=edit&studentID=%S'>Edit</a></td>"
                        +"<td><a href='/Assignment3/Student?type=delete&studentID=%S'>Delete</a></td>"
                        + "</tr>",
                        student.getId(), student.getFirstName(),student.getLastName(),student.getId(),student.getId());
            });
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           
            String groupId=req.getParameter("id");
            String type = req.getParameter("type");
          String studentID = req.getParameter("studentID");
        // resp.getWriter().print("groupID=" + groupId + "  type=" +type+"    studentID=" + studentID);
            if(groupId != null && groupId.length()>0){
                 
               students = studentLogic.getAllStudentByGroupId(Integer.parseInt(groupId));
               
                processRequest(req,resp);
            }else if(type != null && type.equals("delete")){
                studentLogic.deleteStudent(Integer.parseInt(studentID));
                students = studentLogic.getAllStudent();
            processRequest(req,resp);
            }
            else{
            students = studentLogic.getAllStudent();
            req.setAttribute("students", students);
            req.getRequestDispatcher("/WEB-INF/student.jsp").forward(req, resp);
//            processRequest(req,resp);
            }
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
            
		 doGet(req,resp);
	}

	
	
}
