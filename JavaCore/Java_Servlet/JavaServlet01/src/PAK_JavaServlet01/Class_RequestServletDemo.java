package PAK_JavaServlet01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/request-demo" })
public class Class_RequestServletDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Phuong thuc cua request: " + req.getMethod());
		System.out.println("getContentType: " + req.getContentType());
		System.out.println("getContextPath: " + req.getContextPath());
		System.out.println("getServerName: " + req.getServerName());
		System.out.println("getServletPath: " + req.getServletPath());
		System.out.println("getCookies: " + req.getCookies());
		System.out.println("getSession: " + req.getSession());
		
		Enumeration<String> keys = req.getHeaderNames();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			System.out.println(key + " : " + req.getHeader(key));
		}
	}
}
