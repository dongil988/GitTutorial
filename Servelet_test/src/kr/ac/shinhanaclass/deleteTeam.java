package kr.ac.shinhanaclass;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class deleteTeam extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String id = req.getParameter("id");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("조회" + "</br>");
		resp.getWriter().println("<form method='Post' action='/index.html'>");
		resp.getWriter().println("<td> <input type='submit' value='삭제' </td>");
		resp.getWriter().println("</from>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

		MemberManager.deleteMember(id);

	}
}
