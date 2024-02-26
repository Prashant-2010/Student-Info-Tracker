package student_management_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * Servlet implementation class saveloginServlet
 */
@WebServlet("/saveloginServlet")
public class saveloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("welcome to save servlet ");
		BufferedReader br=request.getReader();
		String s=br.readLine();
		ObjectMapper o=new ObjectMapper();
		Login lg=o.readValue(s,Login.class);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system","root","Prashant@123");
			PreparedStatement ps=con.prepareStatement("insert into register(userName,userEmail,userPassword) values(?,?,?)");
			ps.setString(1, lg.name);
			ps.setString(2, lg.email);
			ps.setString(3, lg.pass);
			
			ps.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	}
class Login{
	String name;
	String email;
	String pass;
	public Login(String name, String email, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}

