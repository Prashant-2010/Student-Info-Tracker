package student_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		// database connecting
				try {
					
					System.out.println("hello");
					PrintWriter out=response.getWriter();
				    response.setContentType("text/html");
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Management_system","root","Prashant@123");
					String n=request.getParameter("userEmail");
					String p=request.getParameter("userPassword");
					
					PreparedStatement ps =con.prepareStatement("select UserName from register where userEmail=? and userPassword=?");
					ps.setString(1,n);
					ps.setString(2,p);
					ResultSet rs = ps.executeQuery();
					
					if(rs.next())
					{
						//RequestDispatcher rd=request.getRequestDispatcher("sign.html");
						//rd.forward(request, response);
						String userName = rs.getString("UserName");
		                request.getSession().setAttribute("userName", userName);
		                RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		                rd.forward(request, response);
					}
					
					else {
						
						out.println("<font color=red size=18>Login Failed!!<br>");
						out.println("<a href=sign.html>Try Again!!</a>");
						
						
					}
					
				}catch (ClassNotFoundException e) {
					//to do auto generated catch box
					
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
	}
}