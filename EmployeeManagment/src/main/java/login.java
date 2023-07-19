import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class login extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		HttpSession session=req.getSession();
		RequestDispatcher dis=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Jayesh@2107");
			PreparedStatement ps=con.prepareStatement("select * from Register where email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
//				dis=req.getRequestDispatcher("Dashbpard.html");
//				out.println("You are successfully registered.....");
				res.sendRedirect("Dashboard.html"); 
				
			}
			else {
				
				out.println("<h1> Sorry, Incorrect username or password </h1>");
				
			}
//			dis.forward(req, res);
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
	}
}