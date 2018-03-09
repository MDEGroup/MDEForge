package org.mdeforge.business.model;

public class Role implements java.io.Serializable {

	public static final Role ADMIN;
	public static final Role USER;
	static {
		ADMIN = new Role();
		ADMIN.setName("admin");

		USER = new Role();
		USER.setName("user");
		
	}
	private static final long serialVersionUID = 4824076783845229081L;

	private String name = null;

	private String id;

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getId() {
		return id;
	}

	public void setId(String newId) {
		id = newId;
	}
	@Override

	public String toString() {
		return "Role " + " [name: " + getName() + "]" + " [id: " + getId()
				+ "]";
	}
}
