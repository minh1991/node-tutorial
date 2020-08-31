package PAK_JavaServlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test-config"}, initParams = {
		@WebInitParam(name = "name", value = "Luu Minh")
})
public class Class_ServletConfig extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nameString = super.getServletConfig().getInitParameter("name");
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Xin Chao: " + nameString);
	}
}
