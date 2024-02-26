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



@WebServlet("/SavebiodataData")
public class SavebiodataData extends HttpServlet {
 private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     // Retrieve form data from request parameters
     PrintWriter out = response.getWriter();
     String studentId = request.getParameter("student_id");
     String userName = request.getParameter("userName");
     String firstName = request.getParameter("first_name");
     String lastName = request.getParameter("last_name");
     String dateOfBirth = request.getParameter("date_of_birth");
     String gender = request.getParameter("gender");
     String address = request.getParameter("address");
     String phoneNumber = request.getParameter("phone_number");
     String email = request.getParameter("email");

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
             String sql = "INSERT INTO studentbiodata (student_id, username, first_name, last_name, date_of_birth, gender, address, phone_number, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
             try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                 preparedStatement.setString(1, studentId);
                 preparedStatement.setString(2, userName);
                 preparedStatement.setString(3, firstName);
                 preparedStatement.setString(4, lastName);
                 preparedStatement.setString(5, dateOfBirth);
                 preparedStatement.setString(6, gender);
                 preparedStatement.setString(7, address);
                 preparedStatement.setString(8, phoneNumber);
                 preparedStatement.setString(9, email);

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
