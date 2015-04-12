package kr.ac.shinhanaclass;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadMemberServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String name = req.getParameter("name");

		List<TeamMember> namedMemberList = MemberManager.getMemberByName(name);
		TeamMember m = namedMemberList.get(0);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		
		resp.getWriter().println("이름 : " + m.getName() + "</br>");
		resp.getWriter().println("학번 : " + m.getid() + "</br>");
		resp.getWriter().println("전화 : " + m.gettel() + "</br>");
		resp.getWriter().println("메일 : " + m.getmail() + "</br>");
		resp.getWriter().println("카톡 ID : " + m.getcatok() + "</br>");

		if (m.getcip() == null)
			resp.getWriter().println("팀장 아님" + "</br>");
		else
			resp.getWriter().println("팀장" + "</br>");

		resp.getWriter().println("GitHub ID : " + m.getgitid() + "</br>");
		resp.getWriter().println("<form method='Post' action='/index.html'>");
		resp.getWriter().println("<td> <input type='submit' value='처음으로!' </td>");
		resp.getWriter().println("</from>");
		
		resp.getWriter().println("</html>");
		resp.getWriter().println("</body>");

	}

}
