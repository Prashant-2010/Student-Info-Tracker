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
 * Servlet implementation class DisplayAdminAcadem
 */
@WebServlet("/DisplayAdminAcadem")
public class DisplayAdminAcadem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAdminAcadem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("AdminAcademic servlet");
		try {
    response.setContentType("text/html");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "Prashant@123");

    PreparedStatement ps = con.prepareStatement("select * from student_academic");
    ResultSet rs = ps.executeQuery();
    PrintWriter out = response.getWriter();

    out.println("<html><body>");
    out.println("<div>");

    out.println("<table border='1' style='background-color:cyan; color:black; padding-top:2%;margin:3%;' cellspacing='0'>");
    out.println("<tr><th>Academic ID</th><th>Username</th><th>Course Name</th><th>Branch Name</th><th>Grade</th><th>Semester</th><th>Subject 1 Grade</th><th>Subject 2 Grade</th><th>Subject 3 Grade</th><th>Subject 4 Grade</th><th>Subject 5 Grade</th></tr>");

    while (rs.next()) {
        out.println("<tr>");
        out.println("<td>" + rs.getInt("academic_id") + "</td>");
        out.println("<td>" + rs.getString("userName") + "</td>");
        out.println("<td>" + rs.getString("course_name") + "</td>");
        out.println("<td>" + rs.getString("branch_name") + "</td>");
        out.println("<td>" + rs.getString("grade") + "</td>");
        out.println("<td>" + rs.getInt("semester") + "</td>");
        out.println("<td>" + rs.getString("subject1_grade") + "</td>");
        out.println("<td>" + rs.getString("subject2_grade") + "</td>");
        out.println("<td>" + rs.getString("subject3_grade") + "</td>");
        out.println("<td>" + rs.getString("subject4_grade") + "</td>");
        out.println("<td>" + rs.getString("subject5_grade") + "</td>");
        out.println("</tr>");
    }

    out.println("</table>");
    out.println("</div>");
    out.println("</body></html>");
} catch (Exception e) {
    e.printStackTrace();
}

}	
}