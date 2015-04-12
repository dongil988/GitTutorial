package kr.ac.shinhanaclass;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class MemberManager {

	public static TeamMember addTeamMember(String name, String id, String tel, String mail, String catok, String cip, String gitid)
	{

		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = new TeamMember(name, id, tel, mail, catok, cip, gitid);
		pm.makePersistent(m);
		
		return m;
	}

	public static TeamMember getMember(String key) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = pm.getObjectById(TeamMember.class, key);

		return m;
	}

	public static void updateMember(TeamMember newMember) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember memberObject = MemberManager.getMember(newMember.getid() +"");
		memberObject.setName(newMember.getName());
		memberObject.setid(newMember.getid());
		memberObject.settel(newMember.gettel());
		memberObject.setmail(newMember.getmail());
		memberObject.setcatok(newMember.getcatok());
		memberObject.setcip(newMember.getcip());
		memberObject.setgitid(newMember.getgitid());

		pm.close();

	}

	public static void deleteMember(String key) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = MemberManager.getMember(key);

		pm.deletePersistent(pm.getObjectById(TeamMember.class, key));

	}

	public static List<TeamMember> getMemberByName(String name) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(TeamMember.class);
		qry.setFilter("name == nameParam");
		qry.declareParameters("String nameParam");

		List<TeamMember> memberList = (List<TeamMember>) qry.execute(name);

		return memberList;
	}

	public static List<TeamMember> getAllMembers() {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(TeamMember.class);
		List<TeamMember> memberList = (List<TeamMember>) qry.execute();

		return memberList;
	}

}
