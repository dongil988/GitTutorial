package kr.ac.shinhanaclass;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class updateTeam extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String id = req.getParameter("id");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		TeamMember m = MemberManager.getMember(id);

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1> Update Member </h1>");
		resp.getWriter().println("<form method='Get' action='/updateMember'>");
		resp.getWriter().println("<tr> 이름 : </tr> <tr> <input type='text' name='name' value="
									+ m.getName() + "> </tr> </br>");
	
		resp.getWriter().println("<tr> 학번 : </tr> <tr> <input type='text' name='id' value="
									+ m.getid() + "> </tr> </br>");
		
		resp.getWriter().println("<tr> 전화번호 : </tr> <tr> <input type='text' name='tel' value="
									+ m.gettel() + "> </tr> </br>");
		
		resp.getWriter().println("<tr> 메일 : </tr> <tr> <input type='text' name='mail' value="
									+ m.getmail() + "> </tr> </br>");
		
		resp.getWriter().println("<tr> 카톡 ID : </tr> <tr> <input type='text' name='catok' value="
									+ m.getcatok() + "> </tr> </br>");
		
		if (m.getcip() == null) 
		{
			resp.getWriter().println("<tr> 팀장여부 : </tr> <tr> <input type='checkbox' name='cip'> </tr> </br>");
		} 
		else 
		{
			resp.getWriter().println("<tr> 팀장여부 : </tr> <tr> <input type='checkbox' name='cip' checked='checked'> </tr> </br>");
		}
		
		resp.getWriter().println("<tr> GitID : </tr> <tr> <input type='text' name='gitid' value="
									+ m.getgitid() + "> </tr> </br>");
		
		resp.getWriter().println("<td> <input type='submit' value='정보수정' </td>");
		resp.getWriter().println("</from>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}

}
