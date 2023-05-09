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
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet
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
	     
	     
	    out.println("<a href='AdminDashbord.html'>Add New Dealer</a>");  
		out.println("<h1>Dealer List</h1>");  
			          
	    List<Emp> list=EmpDao.getAllEmployees();  
			          
	    out.print("<table border='1' width='100%'");  
	    out.print("<tr><th>FirstName</th><th>LastName</th><th>MobileNumber</th><th>Email</th><th>Gender</th><th>City</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
	    
		for(Emp e:list)
		{  
			 out.print("<tr><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getMobileNumber()+"</td><td>"+e.getEmail()+"</td><td>"+e.getGender()+"</td><td>"+e.getCity()+"</td><td>"+e.getPassword()+"</td><td><a href='EditServlet?MobileNumber="+e.getMobileNumber()+"'>edit</a></td><td><a href='DeleteServlet?MobileNumber="+e.getMobileNumber()+"'>delete</a></td></tr>");  
		}  
		out.print("</table>");  
		RequestDispatcher rd=request.getRequestDispatcher("view.html");  
        rd.include(request, response); 
			          
	    out.close();  

	}

}
