import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RetriveEmployeeList")
public class RetriveEmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RetriveEmployeeList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String dbURL = "jdbc:mysql://localhost:3306/myoffice_db";
		String username = "root";
		String password = "root";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			String sql = "SELECT * FROM Users";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			pw.println("<!DOCTYPE html><html><head><style>table, th, td {border: 1px solid black; background-color: #96D4D4; border-radius: 10px;}</style></head>");
			pw.println("<body>");
			pw.println("<table>");
			
			pw.println("<tr>");
			pw.println("<th><p>User Name</p></th>"
					+  "<th><p>Password</p></th>"
					+  "<th><p>Full Name</p></th>"
					+  "<th><p>Email</p></th>"
					);
			pw.println("</tr>");
			
			while (result.next()){
				String name = result.getString(2);
				String pass = result.getString(3);
				String fullname = result.getString("fullname");
				String email = result.getString("email");
				
				pw.println("<tr>");
				pw.println("<th><p>"+name+"</p></th>");
				pw.println("<th><p>"+pass+"</p></th>");
				pw.println("<th><p>"+fullname+"</p></th>");
				pw.println("<th><p>"+email+"</p></th>");
				pw.println("</tr><br/>");				
			}
			
			
			pw.println("</table>");
			pw.println("</body>");
			pw.println("</html>");
			
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}