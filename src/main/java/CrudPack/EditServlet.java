package CrudPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");  
	     PrintWriter out=response.getWriter(); 
	     
	     RequestDispatcher rd=request.getRequestDispatcher("view.html");  
	     rd.include(request, response);
	        
	     out.println("<h1>Update Dealer</h1>");  
	     String sid=request.getParameter("MobileNumber");  
	     
	       
	     Emp e=EmpDao.getEmployeeById(sid);  
	       
	     out.print("<form action='EditServlet2' method='post'>");
	     
	     out.print("<table>");  
	     out.print("<tr><td></td><td><input type='hidden' name='MobileNumber' value='"+e.getMobileNumber()+"'/></td></tr>") ; 
	     out.print("<tr><td>FirstName:</td><td><input type='text' name='FirstName' value='"+e.getFirstName()+"'/></td></tr>");  
	     out.print("<tr><td>LastName:</td><td><input type='text' name='LastName' value='"+e.getLastName()+"'/></td></tr>"); 
	     out.print("<tr><td>Email:</td><td><input type='text' name='Email' value='"+e.getEmail()+"'/></td></tr>"); 
	     out.print("<tr><td>Gender:</td><td><input type='text' name='Gender' value='"+e.getGender()+"'/></td></tr>");
	      
	     out.print("<tr><td>City:</td><td><input type='text' name='City' value='"+e.getCity()+"'/></td></tr>"); 
	     out.print("<tr><td>Password:</td><td><input type='password' name='Password' value='"+e.getPassword()+"'/></td></tr>");  
	     
	     
	     
	     
	     out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	     out.print("</table>");  
	     out.print("</form>");  
	       
	     out.close();  

		
	}

}
