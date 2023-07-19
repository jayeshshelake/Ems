

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter out =res.getWriter();
		String  id=req.getParameter("id");
		String name=req.getParameter("name");
		String position=req.getParameter("position");
		String department=req.getParameter("department");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/project";
			String username="root";
			String password="Jayesh@2107";
			Connection con=DriverManager.getConnection(url,username,password);
			String str="insert into addEmployee values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(str);
			ps.setString(1, id);
			ps.setString(2,name);
			ps.setString(3, position);
			ps.setString(4,department);
			int p=ps.executeUpdate();
			
			
			if(p>0) {
				out.println("Employee Added Sucessfully");
			}
		
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		
	}

}
