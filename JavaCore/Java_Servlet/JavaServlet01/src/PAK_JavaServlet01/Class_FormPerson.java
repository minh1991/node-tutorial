package PAK_JavaServlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/form-user"})
public class Class_FormPerson extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.println("<FORM action='/JavaServlet01/add-user' method='post'>");
		printWriter.println("Ten:<INPUT type= 'text' name='nameUser'>");
		printWriter.println("Tuoi:<INPUT type= 'text' name='ageUser'>");
		printWriter.println("Dia chi:<INPUT type= 'text' name='directoryUser'>");
		printWriter.println("<INPUT type= 'submit' value='Submit'>");
		printWriter.println("</FORM>");
		
	}
}
