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
 * Servlet implementation class DisplayAdminBio
 */
@WebServlet("/DisplayAdminBio")
public class DisplayAdminBio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAdminBio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			System.out.println("AdminBio servlet");
			try {
	    response.setContentType("text/html");
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "Prashant@123");

	    PreparedStatement ps = con.prepareStatement("select * from studentbiodata");
	    ResultSet rs = ps.executeQuery();
	    PrintWriter out = response.getWriter();

	    out.println("<html><body>");
	    out.println("<div>");

	    out.println("<table border='1' style='background-color:cyan; color:black; padding-top:2%;margin:3%;' cellspacing='0'  >");
	    out.println("<tr><th>ID</th><th>Username</th><th>Date of Birth</th><th>Gender</th><th>Address</th><th>Phone Number</th><th>Email</th></tr>");

	    while (rs.next()) {
	        out.println("<tr>");
	        out.println("<td>" + rs.getString("student_id") + "</td>");
	        out.println("<td>" + rs.getString("first_name") + " " + rs.getString("last_name") + "</td>");
	        out.println("<td>" + rs.getString("date_of_birth") + "</td>");
	        out.println("<td>" + rs.getString("gender") + "</td>");
	        out.println("<td>" + rs.getString("address") + "</td>");
	        out.println("<td>" + rs.getString("phone_number") + "</td>");
	        out.println("<td>" + rs.getString("email") + "</td>");
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