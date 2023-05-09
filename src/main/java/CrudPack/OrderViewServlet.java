package CrudPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderViewServlet
 */
@WebServlet("/OrderViewServlet")
public class OrderViewServlet extends HttpServlet
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
	     
	     
	    
		out.println("<h1>User Requested List</h1>");
		out.print("<a href='LogoutServlet'>Click here to Logout session</a>");
		
			          
	    List<Emp> list=EmpDao.getAllEmployees2();  
			          
	    out.print("<table border='1' width='100%'");  
	    out.print("<tr><th>FirstName</th><th>LastName</th><th>MobileNumber</th><th>Date</th><th>Items</th><th>City</th><th>Dealer</th></tr>");
	    
		for(Emp e:list)
		{  
			 out.print("<tr><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getMobileNumber()+"</td><td>"+e.getEmail()+"</td><td>"+e.getGender()+"</td><td>"+e.getCity()+"</td><td>"+e.getPassword()+"</td></tr>");  
		}  
		out.print("</table>");  
		RequestDispatcher rd=request.getRequestDispatcher("view.html");  
        rd.include(request, response); 
			          
	    out.close();  
	}

}
