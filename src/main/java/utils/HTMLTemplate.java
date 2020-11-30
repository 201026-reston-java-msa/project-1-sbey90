package utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HTMLTemplate {
	
	public static void goBack(PrintWriter pw) {
		pw.println("<hr><input type='button' value='BACK'"
				+"onclick='goBack()'> "
				+ "<script>"
				+ "function goBack() = { window.history.back(); }"
				+ "</script>" );
	}
	
	public static PrintWriter getHtmlWriter(HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		return res.getWriter();
	}
	
	public static void printTableHeaders(PrintWriter pw, String...headers) {
		pw.println("<table border=2px<tr>");
		
		for(String h : headers) {
			pw.println("<th>" + h + "</th>");
		}
		pw.println("</tr></table>");
	}
	

}
