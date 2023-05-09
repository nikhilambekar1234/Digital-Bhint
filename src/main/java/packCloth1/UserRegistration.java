package packCloth1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String a=request.getParameter("FirstName");
		String b=request.getParameter("LastName");
		String c=request.getParameter("MobileNumber");
		String d=request.getParameter("Email");
		String e=request.getParameter("Gender");
		String f=request.getParameter("City");
		String g=request.getParameter("Password");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pass"); 
		    PreparedStatement stmt=con.prepareStatement("insert into UserRegistration1 values(?,?,?,?,?,?,?)");
		   
			stmt.setString(1,a);
			stmt.setString(2,b);
			stmt.setString(3,c);
			stmt.setString(4,d);
			stmt.setString(5,e);
			stmt.setString(6,f);
			stmt.setString(7,g);
			
			
			int i=stmt.executeUpdate();
			if(i>0)
			{
				 out.print ("you are succefully registered");
			     RequestDispatcher rd=request.getRequestDispatcher("/Registration.html");  
			     rd.include(request, response); 
			}
			
			
			
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		out.close();
	}

}
