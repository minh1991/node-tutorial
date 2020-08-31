package PAK_JavaServlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/add-user"})
public class Class_PersonServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String nameString = req.getParameter("nameUser");
		String ageString	= req.getParameter("ageUser");
		String directoryString = req.getParameter("directoryUser");
		
		printWriter.println("///Ten: "+ nameString + "///Tuoi: " + ageString + "///Dia chi: " + directoryString);
	}
}
