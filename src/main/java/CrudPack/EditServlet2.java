package CrudPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 response.setContentType("text/html");  
	     PrintWriter out=response.getWriter();  
	       
	     String FirstName=request.getParameter("FirstName");  
	     String LastName=request.getParameter("LastName"); 
	     String MobileNumber=request.getParameter("MobileNumber"); 
	     String Email=request.getParameter("Email"); 
	     String Gender=request.getParameter("Gender");  
	     String City=request.getParameter("City");  
	     String Password=request.getParameter("Password"); 
	      
	       
	     Emp e=new Emp(); 
	     
	       
	     e.setFirstName(FirstName);  
	     e.setLastName(LastName); 
	     e.setMobileNumber(MobileNumber);
	     e.setEmail(Email);  
	     e.setGender(Gender);
	     e.setCity(City);  
	     e.setPassword(Password); 
	       
	     int status=EmpDao.update(e);  
	     if(status>0){  
	         response.sendRedirect("ViewServlet");  
	     }else{  
	         out.println("Sorry! unable to update record");  
	     }  
	       
	     out.close();  
	}

}
