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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchData
 */
@WebServlet("/FetchData")
public class FetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchData() {
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
			PreparedStatement ps = con.prepareStatement("select * from Studentbiodata where userName=?");
			
			ps.setString(1,currentUsername);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			
			   out.println("<html><body>");

	           
	                while (rs.next()) {
	                	  out.println("<div >");
	      			    out.println("<table border='3'  style='font-size:30px;background-color:cyan; color:black;' cellspacing='0' align='center'  height='150px'>");
	      			 
	      			  out.println("<tr><td>ID: </td><td>" + rs.getString("student_id") + "</td></tr>");
	      		    out.println("<tr><td>Username: </td><td>" + rs.getString("first_name") + " " + rs.getString("last_name") + "</td></tr>");
	      		    out.println("<tr><td>Date of Birth: </td><td>" + rs.getString("date_of_birth") + "</td></tr>");
	      		    out.println("<tr><td>Gender: </td><td>" + rs.getString("gender") + "</td></tr>");
	      		    out.println("<tr><td>Address: </td><td>" + rs.getString("address") + "</td></tr>");
	      		    out.println("<tr><td>Phone Number: </td><td>" + rs.getString("phone_number") + "</td></tr>");
	      		    out.println("<tr><td>Email: </td><td>" + rs.getString("email") + "</td></tr>");
                     

	      		  out.println("</div >");

	            }

	            out.println("</body></html>");
			
		}catch (Exception e) {
			//to do auto generated catch box
			
			e.printStackTrace();
		}
	}
}