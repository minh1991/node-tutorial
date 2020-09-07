package PAK_JavaServlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servletContext_resp" })
public class ServletContext_resp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();

		String nameString = (String) getServletContext().getAttribute("nameAttr");
		printWriter.println("Hello " + nameString);

		String jdbcString = getServletContext().getInitParameter("jdbc");
		printWriter.println("From to " + jdbcString);
	}
}
