package student_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchAcademics
 */
@WebServlet("/FetchAcademics")
public class FetchAcademics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchAcademics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system","root","Prashant@123");
			String currentUsername=request.getParameter("userName");
			PreparedStatement ps = con.prepareStatement("select * from student_academic where userName=?");
			
			ps.setString(1,currentUsername);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			
		
			
			out.println("<html><body>");

			while (rs.next()) {
			    out.println("<div >");
			    out.println("<table  border='2'style='font-size:30px; background-color:cyan; color:black;' cellspacing='0' align='center'  height='150px'>");
			    out.println("<tr><td>ID: </td><td>" + rs.getString("academic_id") + "</td></tr>");
			    out.println("<tr><td>Username: </td><td>" + rs.getString("userName") + "</td></tr>");
			    out.println("<tr><td>Course Name: </td><td>" + rs.getString("course_name") + "</td></tr>");
			    out.println("<tr><td>Branch Name: </td><td>" + rs.getString("branch_name") + "</td></tr>");
			    out.println("<tr><td>Grade: </td><td>" + rs.getString("grade") + "</td></tr>");
			    out.println("<tr><td>Semester: </td><td>" + rs.getString("semester") + "</td></tr>");
			    out.println("<tr><td>Subject 1 Grade: </td ><td>" + rs.getString("subject1_grade") + "</td></tr>");
			    out.println("<tr><td>Subject 2 Grade: </td><td>" + rs.getString("subject2_grade") + "</td></tr>");
			    out.println("<tr><td>Subject 3 Grade: </td><td>" + rs.getString("subject3_grade") + "</td></tr>");
			    out.println("<tr><td>Subject 4 Grade: </td><td>" + rs.getString("subject4_grade") + "</td></tr>");
			    out.println("<tr><td>Subject 5 Grade: </td><td>" + rs.getString("subject5_grade") + "</td></tr>");
                out.println("</table>");
			    out.println("</div>");
			}

			out.println("</body></html>");
			
		}catch (Exception e) {
			//to do auto generated catch box
			
			e.printStackTrace();
		}
	}
}