package PAK_JavaServlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servletContext" })
public class ServletContext extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();

		printWriter.println("Hello ServletContext-------");
		String jdbcString = getServletContext().getInitParameter("jdbc");
		printWriter.println("From to " + jdbcString);
		getServletContext().setAttribute("nameAttr", "Minh");
	}
}
