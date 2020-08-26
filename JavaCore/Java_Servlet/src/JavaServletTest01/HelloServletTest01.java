package JavaServletTest01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServletTest01 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("bat dau servlet");
	}

	@Override
	public void destroy() {
		System.out.println("Ket thuc servlet");
	}

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("Phuong thuc cua request: " + req.getMethod());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<H1>Xin chao Servlet Test01</H1>");
		writer.close();
	}
}
