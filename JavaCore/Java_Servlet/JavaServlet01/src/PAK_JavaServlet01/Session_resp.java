package PAK_JavaServlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/session-req" })
public class Session_resp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		HttpSession httpSession = req.getSession();

		String nameString = "";
		Object obj = httpSession.getAttribute("userName");

		if (obj != null) {
			nameString = String.valueOf(obj);
		} else {
			resp.sendRedirect("/JavaServlet01/session-set");
		}

		printWriter.println("Hello: " + nameString);
	}
}
