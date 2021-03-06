package PAK_JavaServlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/welcome" })
public class FormLogin_Welcome extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String nameUser_respString = "";
		
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("userName")) {
				nameUser_respString = c.getValue();
			}
		}
		//
		if (nameUser_respString.equals("")) {
			resp.sendRedirect("/JavaServlet01/login-cookie");
		}
		printWriter.println("Hello " + nameUser_respString);
	}
}
