package PAK_JavaServlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet(urlPatterns = { "/login-cookie" })
public class Cookie_Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();

		printWriter.println("<FORM action='/JavaServlet01/login-cookie' method='post'>");
		printWriter.println("User:<INPUT type= 'text' name='nameUser'>");
		printWriter.println("</br>");
		printWriter.println("Pass:<INPUT type= 'password' name='passwordUser'>");
		printWriter.println("</br>");
		printWriter.println("<INPUT type= 'submit' value='Submit'>");
		printWriter.println("</FORM>");

		printWriter.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String userNameString = req.getParameter("nameUser");
		String userPassString = req.getParameter("passwordUser");

		if (isNullOrEmpty(userNameString)) {
			printWriter.println("phai nhap userName");
		} else if (isNullOrEmpty(userPassString)) {
			printWriter.println("phai nhap PassWord");
		} else {
			// userName
			Cookie cookie_userName = new Cookie("userName", userNameString);
			cookie_userName.setMaxAge(5);
			resp.addCookie(cookie_userName);
			// Pass
			Cookie cookie_passwordUser = new Cookie("passwordUser", userPassString);
			cookie_passwordUser.setMaxAge(5);
			resp.addCookie(cookie_passwordUser);

			resp.sendRedirect("/JavaServlet01/welcome");
		}
	}

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}
}
