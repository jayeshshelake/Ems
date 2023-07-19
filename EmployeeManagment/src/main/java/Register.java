import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Register extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) 
	throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		String name =req.getParameter("name");
		String email =req.getParameter("email");
		String pass =req.getParameter("pass");
		
	

	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Jayesh@2107");
		PreparedStatement ps=con.prepareStatement("insert into Register values(?,?,?)");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, pass);
		int p=ps.executeUpdate();
	
	
	if(p>0)
	{
		out.println("You are successfully registered");
	}
	}
	catch(Exception e) {
		System.out.println(e);
		
	}
}
}