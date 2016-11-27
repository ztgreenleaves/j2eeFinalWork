package DAO;

/**
 * Info entity. @author MyEclipse Persistence Tools
 */

public class Info implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String iclass;
	private String sex;
	private String iadd;

	// Constructors

	/** default constructor */
	public Info() {
	}

	/** minimal constructor */
	public Info(String id, String name, String iclass, String sex) {
		this.id = id;
		this.name = name;
		this.iclass = iclass;
		this.sex = sex;
	}

	/** full constructor */
	public Info(String id, String name, String iclass, String sex, String iadd) {
		this.id = id;
		this.name = name;
		this.iclass = iclass;
		this.sex = sex;
		this.iadd = iadd;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIclass() {
		return this.iclass;
	}

	public void setIclass(String iclass) {
		this.iclass = iclass;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIadd() {
		return this.iadd;
	}

	public void setIadd(String iadd) {
		this.iadd = iadd;
	}

}