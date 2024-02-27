package in.neuralnet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ConsoleApp.App;



@WebServlet("/wish")
public class WishServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		LocalDateTime dt = LocalDateTime.now();
		int hour = dt.getHour();
		
		String s = new App().window();
		
		pw.println("<h1 style='color:red;text-align:center;'><center>Today date and time is :: " + dt + "</center></h1>");
		if (hour < 12)
			pw.println("<h2><center>Good Morning:"+s+ "</center></h2>");
		else if (hour < 16)
			pw.println("<h2><center>Good Afternoon: "+s+"</center></h2>");
		else if (hour < 20)
			pw.println("<h2><center>Good Evening: "+s+"</center></h2>");
		else
			pw.println("<h2 style='color:red; text-align:center;'><center>Good night</center></h2>");


		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
