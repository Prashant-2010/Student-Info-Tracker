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
 * Servlet implementation class DisplayAdminAttend
 */
@WebServlet("/DisplayAdminAttend")
public class DisplayAdminAttend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAdminAttend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AdminAttend servlet");
		try {
    response.setContentType("text/html");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "Prashant@123");

    PreparedStatement ps = con.prepareStatement("select * from student_attendance");
    ResultSet rs = ps.executeQuery();
    PrintWriter out = response.getWriter();

    out.println("<html><body>");
    out.println("<div>");

    out.println("<table border='1' style='background-color:cyan; color:black; padding-top:2%;margin:3%;' cellspacing='0'>");
    out.println("<tr><th>Username</th><th>Month 1 Attendance</th><th>Month 2 Attendance</th><th>Month 3 Attendance</th><th>Month 4 Attendance</th><th>Total Attendance</th><th>Subject 1 Attendance</th><th>Subject 2 Attendance</th><th>Subject 3 Attendance</th><th>Subject 4 Attendance</th><th>Subject 5 Attendance</th></tr>");

    // Assuming 'rs' is the ResultSet from executing the SELECT query for student_attendance
    while (rs.next()) {
        out.println("<tr>");
        out.println("<td>" + rs.getInt("attendance_id") + "</td>");
        out.println("<td>" + rs.getString("userName") + "</td>");
        out.println("<td>" + rs.getInt("month_1_attendance") + "</td>");
        out.println("<td>" + rs.getInt("month_2_attendance") + "</td>");
        out.println("<td>" + rs.getInt("month_3_attendance") + "</td>");
        out.println("<td>" + rs.getInt("month_4_attendance") + "</td>");
        out.println("<td>" + rs.getInt("total_attendance") + "</td>");
        out.println("<td>" + rs.getInt("subject_1_attendance") + "</td>");
        out.println("<td>" + rs.getInt("subject_2_attendance") + "</td>");
        out.println("<td>" + rs.getInt("subject_3_attendance") + "</td>");
        out.println("<td>" + rs.getInt("subject_4_attendance") + "</td>");
        out.println("<td>" + rs.getInt("subject_5_attendance") + "</td>");
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