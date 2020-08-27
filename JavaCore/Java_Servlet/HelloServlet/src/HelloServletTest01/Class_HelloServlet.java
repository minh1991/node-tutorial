package HelloServletTest01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Class_HelloServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Bat dau Servlet");
	}

	@Override
	public void destroy() {
		System.out.println("Ket thuc Servlet");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("Phuong thuc request: " + req.getMethod());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		writer.println("<H1>Hello Word Servlet</H1>");
		writer.close();

	}

}
