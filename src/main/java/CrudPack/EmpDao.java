package CrudPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;





public class EmpDao
{
	public static Connection getConnection()
	{  
	        Connection con=null;  
	        try
	        {  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
		        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pass");  
		    }
	        catch(Exception e){System.out.println(e);}  
		        return con;  
		    }  
		    public static int save(Emp e)
		    {  
		        int status=0;  
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement( "insert into DealerRegistration1(FirstName,LastName,MobileNumber,Email,Gender,City,Password) values (?,?,?,?,?,?,?)");  
		            ps.setString(1,e.getFirstName());
		            ps.setString(2,e.getLastName());  
		            ps.setString(3,e.getMobileNumber());  
		            ps.setString(4,e.getEmail());  
		            ps.setString(5,e.getGender()); 
		            ps.setString(6,e.getCity());  
		            ps.setString(7,e.getPassword()); 
		              
	                status=ps.executeUpdate();  
		              
		            con.close();  
		        }
		        catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        }  
		          
		        return status;  
		    }  
	       public static int update(Emp e)
		    {  
		        int status=0;  
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement( "update DealerRegistration1 set FirstName=?,LastName=?,Password=?,Email=?,Gender=?,City=? where MobileNumber=?");  
		            
		            ps.setString(1,e.getFirstName());
		            ps.setString(2,e.getLastName());  
		            ps.setString(3,e.getPassword());  
		            ps.setString(4,e.getEmail());  
		            ps.setString(5,e.getGender()); 
		            ps.setString(6,e.getCity());  
		            ps.setString(7,e.getMobileNumber()); 
		            
		            
			              
			        status=ps.executeUpdate();  
			              
			            con.close();  
			    }
		        catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        }  
			          
			        return status;  
		    }  
		    public static int delete(String MobileNumber)
		    {  
		        int status=0;  
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("delete from DealerRegistration1 where MobileNumber=?");  
		            ps.setString(1,MobileNumber);  
		            status=ps.executeUpdate();  
		              
		            con.close();  
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }  
		          
		        return status;  
		    }  
		    public static boolean validate(Emp e)
		    {  
		    	boolean status=false;
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from UserRegistration1 where mobileNumber=? and password=?");
		            
		            System.out.println("email "+e.getMobileNumber());              //show on console to check
		    		System.out.println("password "+e.getPassword());
		    		
		    		ps.setString(1,e.getMobileNumber());
		    		ps.setString(2,e.getPassword());
		    		
		    		ResultSet rs=ps.executeQuery();
		    		status=rs.next();
		    		
		           
		            con.close();  
		        }
		        catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        }  
		        System.out.println(status);   //  //show on console to check
		    	return status; 
		        
		    }  
		    
		    public static Emp getEmployeeById(String MobileNumber)
		    {  
	            Emp e=new Emp();  
		          
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from DealerRegistration1  where MobileNumber=?");  
		            ps.setString(1,MobileNumber);  
		            ResultSet rs=ps.executeQuery();  
		            if(rs.next())
		            {  
		                  
		                e.setFirstName(rs.getString(1));  
		                e.setLastName(rs.getString(2)); 
		                e.setMobileNumber(rs.getString(3));
		                e.setEmail(rs.getString(4));  
		                e.setGender(rs.getString(5));  
		                e.setCity(rs.getString(6));  
		                e.setPassword(rs.getString(7));  
		            }  
		            con.close();  
		        }
		        catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        }  
		          
		        return e;  
		    }  
		    public static List<Emp> getAllEmployees()
		    {  
		        List<Emp> list=new ArrayList<Emp>();  
		          
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from DealerRegistration1");  
		            ResultSet rs=ps.executeQuery();  
		            while(rs.next())
		            {  
		                Emp e=new Emp();  
		                e.setFirstName(rs.getString(1));  
		                e.setLastName(rs.getString(2));  
		                e.setMobileNumber(rs.getString(3));  
		                e.setEmail(rs.getString(4));  
		                e.setGender(rs.getString(5));  
		                e.setCity(rs.getString(6));  
		                e.setPassword(rs.getString(7)); 
		                list.add(e);  
		            }  
			            con.close();  
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }  
		        return list;     
			    
		 }
		    public static List<Emp> getAllEmployees1()
		    {  
		        List<Emp> list=new ArrayList<Emp>();  
		          
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from UserRegistration1");  
		            ResultSet rs=ps.executeQuery();  
		            while(rs.next())
		            {  
		                Emp e=new Emp();  
		                e.setFirstName(rs.getString(1));  
		                e.setLastName(rs.getString(2));  
		                e.setMobileNumber(rs.getString(3));  
		                e.setEmail(rs.getString(4));  
		                e.setGender(rs.getString(5));  
		                e.setCity(rs.getString(6));  
		                e.setPassword(rs.getString(7)); 
		                list.add(e);  
		            }  
			            con.close();  
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }  
		        return list;     
	       }
		    public static int delete1(String MobileNumber)
		    {  
		        int status=0;  
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("delete from UserRegistration1 where MobileNumber=?");  
		            ps.setString(1,MobileNumber);  
		            status=ps.executeUpdate();  
		              
		            con.close();  
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }  
		          
		        return status;  
		    }  
		    public static int save1(Emp e)
		    {  
		        int status=0;  
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement( "insert into OrderRegistration(FirstName,LastName,MobileNumber,Email,Gender,City,Password) values (?,?,?,?,?,?,?)");  
		            ps.setString(1,e.getFirstName());
		            ps.setString(2,e.getLastName());  
		            ps.setString(3,e.getMobileNumber());  
		            ps.setString(4,e.getEmail());  
		            ps.setString(5,e.getGender()); 
		            ps.setString(6,e.getCity());  
		            ps.setString(7,e.getPassword()); 
		              
	                status=ps.executeUpdate();  
		              
		            con.close();  
		        }
		        catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        }  
		          
		        return status;  
		    }  
		    public static boolean validate1(Emp e)
		    {  
		    	boolean status=false;
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from DealerRegistration1 where mobileNumber=? and password=?");
		            
		            System.out.println("email "+e.getMobileNumber());              //show on console to check
		    		System.out.println("password "+e.getPassword());
		    		
		    		ps.setString(1,e.getMobileNumber());
		    		ps.setString(2,e.getPassword());
		    		
		    		ResultSet rs=ps.executeQuery();
		    		status=rs.next();
		    		
		           
		            con.close();  
		        }
		        catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        }  
		        System.out.println(status);   //  //show on console to check
		    	return status; 
		        
		    } 
		    public static List<Emp> getAllEmployees2()
		    {  
		        List<Emp> list=new ArrayList<Emp>();  
		          
		        try
		        {  
		            Connection con=EmpDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement("select * from OrderRegistration");  
		            ResultSet rs=ps.executeQuery();  
		            while(rs.next())
		            {  
		                Emp e=new Emp();  
		                e.setFirstName(rs.getString(1));  
		                e.setLastName(rs.getString(2));  
		                e.setMobileNumber(rs.getString(3));  
		                e.setEmail(rs.getString(4));  
		                e.setGender(rs.getString(5));  
		                e.setCity(rs.getString(6));  
		                e.setPassword(rs.getString(7)); 
		                list.add(e);  
		            }  
			            con.close();  
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }  
		        return list;     
	       }
		   
   
}
