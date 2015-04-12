package kr.ac.shinhanaclass;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class registMember extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		String catok = req.getParameter("catok");
		String cip = req.getParameter("cip");
		String gitid = req.getParameter("gitid");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		TeamMember m = MemberManager.addTeamMember(name, id, tel, mail, catok,cip, gitid);

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");

		resp.getWriter().println("이름: " + m.getName() + "</br>");
		resp.getWriter().println("학번: " + m.getid() + "</br>");
		resp.getWriter().println("전화번호: " + m.gettel() + "</br>");
		resp.getWriter().println("메일주소: " + m.getmail() + "</br>");
		resp.getWriter().println("카톡이이디: " + m.getcatok() + "</br>");

		if (m.getcip() == null)
			resp.getWriter().println("팀장 아님" + "</br>");
		else
			resp.getWriter().println("팀장" + "</br>");

		resp.getWriter().println("GitHub ID: " + m.getgitid() + "</br>");
		resp.getWriter().println("<form method='Get' action='/index.html'>");
		resp.getWriter().println("<td> <input type='submit' value='처음으로!' </td>");
		resp.getWriter().println("</from>");

		resp.getWriter().println("</html>");
		resp.getWriter().println("</body>");

	}
}
