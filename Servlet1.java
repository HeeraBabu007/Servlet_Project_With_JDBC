import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet1() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("uname");
		String upin = request.getParameter("upin");
		
		//out.print("Uname is "+uname+" and UPIN is "+upin);
		
//		if(uname.equals("heera") && upin.equals("123456")) {
//			//out.print("login successful");
//			RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
//			rd.forward(request, response);
//		}else {
//			//out.print("login not successful");
//			RequestDispatcher rd = request.getRequestDispatcher("Servlet3");
//			rd.forward(request, response);
//		}
		
		
	  ServletConfig config=	getServletConfig();
	  Enumeration<String> e = config.getInitParameterNames();
	  while(e.hasMoreElements()) {
		  out.print(e.nextElement());
	  }
	}

}
