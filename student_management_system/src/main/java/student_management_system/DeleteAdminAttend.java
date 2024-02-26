package student_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAdminAttend
 */
@WebServlet("/DeleteAdminAttend")
public class DeleteAdminAttend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminAttend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("admin attendnce delete");
		 String idToDelete1 = request.getParameter("deleteId1");

	        Connection conn = null;
	        PreparedStatement stmt = null;
	        PrintWriter out = response.getWriter();

	        try {
	            // Replace the following with your database connection details
	            String jdbcUrl = "jdbc:mysql://localhost:3306/student_management_system";
	            String dbUser = "root";
	            String dbPassword = "Prashant@123";

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

	            // Assuming you have a table named 'your_table' with a column 'id'
	            String sql = "DELETE FROM student_attendance WHERE attendance_id = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, idToDelete1);

	            int rowsAffected = stmt.executeUpdate();

	            if (rowsAffected > 0) {
	                out.println("Record with ID " + idToDelete1 + " deleted successfully.");
	            } else {
	                out.println("No record found with ID " + idToDelete1);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            out.println("Error: " + e.getMessage());
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	}