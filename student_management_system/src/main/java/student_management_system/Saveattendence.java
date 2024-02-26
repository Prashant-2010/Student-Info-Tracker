package student_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saveattendence
 */
@WebServlet("/Saveattendence")
public class Saveattendence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saveattendence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  PrintWriter out = response.getWriter();
		     String attendenceId = request.getParameter("id");
		     String userName = request.getParameter("username");
		     String month1 = request.getParameter("month1");
		     String month2 = request.getParameter("month2");
		     String month3 = request.getParameter("month3");
		     String month4 = request.getParameter("month4");
		     String total = request.getParameter("total");
		     String sub1 = request.getParameter("subject1");
		     String sub2 = request.getParameter("subject2");
		     String sub3 = request.getParameter("subject3");
		     String sub4 = request.getParameter("subject4");
		     String sub5 = request.getParameter("subject5");
		     // JDBC database connection details
		     String jdbcUrl = "jdbc:mysql://localhost:3306/Student_management_system";
		     String dbUser = "root";
		     String dbPassword = "Prashant@123";

		     try {
		         // Load the JDBC driver
		         Class.forName("com.mysql.cj.jdbc.Driver");

		         // Establish the database connection
		         try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
		             // SQL query to insert form data into the database
		             String sql = "INSERT INTO student_attendance (attendance_id,userName, month_1_attendance, month_2_attendance, month_3_attendance, month_4_attendance, total_attendance, subject_1_attendance, subject_2_attendance, subject_3_attendance, subject_4_attendance, subject_5_attendance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		             try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		                 preparedStatement.setString(1, attendenceId);
		                 preparedStatement.setString(2, userName);
		                 preparedStatement.setString(3, month1);
		                 preparedStatement.setString(4, month2);
		                 preparedStatement.setString(5, month3);
		                 preparedStatement.setString(6, month4);
		                 preparedStatement.setString(7, total);
		                 preparedStatement.setString(8, sub1);
		                 preparedStatement.setString(9, sub2);
		                 preparedStatement.setString(10, sub3);
		                 preparedStatement.setString(11, sub4);
		                 preparedStatement.setString(12, sub5);

		                 // Execute the insert statement
		                 int rowsAffected = preparedStatement.executeUpdate();

		                 if (rowsAffected > 0) {
		                     // Data successfully inserted
		                     out.println("<script>alert('Form data saved successfully')</script>");
		                     RequestDispatcher rd = request.getRequestDispatcher("NewFile.html");
		                     rd.forward(request, response);
		                 } else {
		                     // Failed to insert data
		                     out.println("<font color=red size=18> Failed!! to insert form data<br>");
		                     out.println("<a href=index.html>Try Again!!</a>");
		                 }
		             }
		         }
		     } catch (ClassNotFoundException | SQLException e) {
		         e.printStackTrace();
		         response.getWriter().println("Error: " + e.getMessage());
		     }
		 }
		}
