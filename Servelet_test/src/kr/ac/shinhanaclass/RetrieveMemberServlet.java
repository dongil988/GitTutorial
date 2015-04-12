package kr.ac.shinhanaclass;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetrieveMemberServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		List<TeamMember> memberList = MemberManager.getAllMembers();

		resp.getWriter().println("<HTML>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<table border = 1>");
		for (TeamMember m : memberList) {
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td>" + "<a href = '/ReadMemberServlet?name="
							+ m.getName() + "'>" + m.getName() + "</a>"
							+ "</td><td>" + m.getid() + "</td>" + "</td><td>"
							+ m.gettel() + "</td>" + "</td><td>" + m.getmail()
							+ "</td>" + "</td><td>" + m.getcatok() + "</td>");
			
			if (m.getcip() == null) {
				resp.getWriter().println("<td>not'cip</td>");
			} else {
				resp.getWriter().println("<td>cip</td>");
			}
			
			resp.getWriter().println("</td>" + "</td><td>" + m.getgitid() + "</td>"
										+ "</td><td>" + "<a href = '/deleteTeam?id="
										+ m.getid() + "'>" + "del" + "</td>");
			resp.getWriter().println("<td>" + "<a href = '/updateTeam?id=" + m.getid() + "'>"
										+ "update" + "</td>");
			resp.getWriter().println("</tr>");
		}
		
		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</HTML>");

	}
}
