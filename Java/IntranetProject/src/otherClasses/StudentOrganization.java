package otherClasses;

import enums.RoleInOrganization;

public class StudentOrganization {

	private String organizationName;

	private RoleInOrganization role;

	public StudentOrganization() {

	}

	public StudentOrganization(String organizationName, RoleInOrganization role) {
		this.setOrganizationName(organizationName);
		this.setRole(role);
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public RoleInOrganization getRole() {
		return role;
	}

	public void setRole(RoleInOrganization role) {
		this.role = role;
	}

}
