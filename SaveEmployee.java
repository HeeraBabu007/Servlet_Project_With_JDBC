
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveEmployee")
public class SaveEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SaveEmployee() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		
		//jdbc
		String dbURL = "jdbc:mysql://localhost:3306/myoffice_db";
		String username = "root";
		String password = "root";

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, pass);
			statement.setString(3, fullname);
			statement.setString(4, email);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				pw.println("<h1>A new user was inserted successfully!</h1>");
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
