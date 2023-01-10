//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/SaveEmployee")
//public class SaveEmployee2 extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    public SaveEmployee2() {
//        super();
//    }
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		String name = request.getParameter("username");
//		String pass = request.getParameter("password");
//		String fullname = request.getParameter("fullname");
//		String email = request.getParameter("email");
//		pw.println("<!DOCTYPE html><html><head><style>table, th, td {border: 1px solid black; background-color: #96D4D4; border-radius: 10px;}</style></head>");
//		pw.println("<body>");
//		pw.println("<table>");
//		
//		pw.println("<tr>");
//		pw.println("<th>username</th>"
//				+  "<th>password</th>"
//				+  "<th>fullname</th>"
//				+  "<th>email</th>"
//				);
//		pw.println("</tr>");
//		
//		pw.println("<tr>");
//		pw.println("<th>"+name+"</th>");
//		pw.println("<th>"+pass+"</th>");
//		pw.println("<th>"+fullname+"</th>");
//		pw.println("<th>"+email+"</th>");
//		pw.println("</tr>");
//		
//		pw.println("</table>");
//		pw.println("</body>");
//		pw.println("</html>");
//		
//		//pw.println("Welcome "+name+", your's password: "+pass+" and FullName: "+fullname+" and email:"+email);	
//	}
//}
