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
 * Servlet implementation class Student_Attendence
 */
@WebServlet("/Student_Attendence")
public class Student_Attendence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_Attendence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try {
			
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system","root","Prashant@123");
			String currentUsername=request.getParameter("userName");
			PreparedStatement ps = con.prepareStatement("select * from student_attendance where userName=?");
			
			ps.setString(1,currentUsername);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			
		
			
			out.println("<html><body>");

			while (rs.next()) {
			    out.println("<div >");
			    out.println("<table border='2'style='font-size:30px; background-color:cyan; color:black;' cellspacing='0' align='center'  height='150px'>");
			    out.println("<tr><td>ID: </td><td>" + rs.getString("attendance_id") + "</td></tr>");
			    out.println("<tr><td>Username: </td><td>" + rs.getString("userName") + "</td></tr>");
			    out.println("<tr><td>Month 1 Attendance: </td><td>" + rs.getString("month_1_attendance") + "</td></tr>");
			    out.println("<tr><td>Month 2 Attendance: </td><td>" + rs.getString("month_2_attendance") + "</td></tr>");
			    out.println("<tr><td>Month 3 Attendance: </td><td>" + rs.getString("month_3_attendance") + "</td></tr>");
			    out.println("<tr><td>Month 4 Attendance: </td><td>" + rs.getString("month_4_attendance") + "</td></tr>");
			    out.println("<tr><td>Total Attendance: </td><td>" + rs.getString("total_attendance") + "</td></tr>");
			    out.println("<tr><td>Subject 1 Attendance: </td><td>" + rs.getString("subject_1_attendance") + "</td></tr>");
			    out.println("<tr><td>Subject 2 Attendance: </td><td>" + rs.getString("subject_2_attendance") + "</td></tr>");
			    out.println("<tr><td>Subject 3 Attendance: </td><td>" + rs.getString("subject_3_attendance") + "</td></tr>");
			    out.println("<tr><td>Subject 4 Attendance: </td><td>" + rs.getString("subject_4_attendance") + "</td></tr>");
			    out.println("<tr><td>Subject 5 Attendance: </td><td>" + rs.getString("subject_5_attendance") + "</td></tr>");

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