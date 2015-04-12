package kr.ac.shinhanaclass;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TeamMember {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String id;

	@Persistent
	private String name;

	@Persistent
	private String tel;

	@Persistent
	private String mail;

	@Persistent
	private String catok;

	@Persistent
	private String cip;

	@Persistent
	private String gitid;

	public TeamMember(String name, String id, String tel, String mail, String catok, String cip, String gitid) 
	{
		super();

		this.name = name;
		this.id = id;
		this.tel = tel;
		this.mail = mail;
		this.catok = catok;
		this.cip = cip;
		this.gitid = gitid;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getid()
	{
		return id;
	}

	public void setid(String id) 
	{
		this.id = id;
	}

	public String gettel() 
	{
		return tel;
	}

	public void settel(String tel) 
	{
		this.tel = tel;
	}

	public String getmail()
	{
		return mail;
	}

	public void setmail(String mail)
	{
		this.mail = mail;
	}

	public String getcatok()
	{
		return catok;
	}

	public void setcatok(String catok)
	{
		this.catok = catok;
	}

	public String getcip()
	{

		return cip;
	}

	public void setcip(String cip)
	{
		this.cip = cip;
	}

	public String getgitid()
	{
		return gitid;
	}

	public void setgitid(String gitid)
	{
		this.gitid = gitid;
	}

}
