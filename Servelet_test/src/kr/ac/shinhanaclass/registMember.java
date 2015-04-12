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

		resp.getWriter().println("�̸�: " + m.getName() + "</br>");
		resp.getWriter().println("�й�: " + m.getid() + "</br>");
		resp.getWriter().println("��ȭ��ȣ: " + m.gettel() + "</br>");
		resp.getWriter().println("�����ּ�: " + m.getmail() + "</br>");
		resp.getWriter().println("ī�����̵�: " + m.getcatok() + "</br>");

		if (m.getcip() == null)
			resp.getWriter().println("���� �ƴ�" + "</br>");
		else
			resp.getWriter().println("����" + "</br>");

		resp.getWriter().println("GitHub ID: " + m.getgitid() + "</br>");
		resp.getWriter().println("<form method='Get' action='/index.html'>");
		resp.getWriter().println("<td> <input type='submit' value='ó������!' </td>");
		resp.getWriter().println("</from>");

		resp.getWriter().println("</html>");
		resp.getWriter().println("</body>");

	}
}
