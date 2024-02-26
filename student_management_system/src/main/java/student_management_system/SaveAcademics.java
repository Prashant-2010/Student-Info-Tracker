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
 * Servlet implementation class SaveAcademics
 */
@WebServlet("/SaveAcademics")
public class SaveAcademics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAcademics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("save academics");
		 PrintWriter out = response.getWriter();
	     String academicid = request.getParameter("id");
	     String userName = request.getParameter("username");
	     String coursename = request.getParameter("course");
	     String branchname = request.getParameter("branch");
	     String grade = request.getParameter("grade");
	     String semester = request.getParameter("semester");
	     String sub1grade = request.getParameter("subject1");
	     String sub2grade = request.getParameter("subject2");
	     String sub3grade = request.getParameter("subject3");
	     String sub4grade = request.getParameter("subject4");
	     String sub5grade = request.getParameter("subject5");

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
	             String sql = "INSERT INTO student_academic (academic_id, userName, course_name, branch_name, grade, semester, subject1_grade, subject2_grade, subject3_grade, subject4_grade, subject5_grade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";;
	             try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	                 preparedStatement.setString(1,academicid);
	                 preparedStatement.setString(2, userName);
	                 preparedStatement.setString(3,coursename);
	                 preparedStatement.setString(4, branchname);
	                 preparedStatement.setString(5, grade);
	                 preparedStatement.setString(6, semester);
	                 preparedStatement.setString(7, sub1grade);
	                 preparedStatement.setString(8, sub2grade);
	                 preparedStatement.setString(9, sub3grade);
	                 preparedStatement.setString(10, sub4grade);
	                 preparedStatement.setString(11, sub5grade);

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
