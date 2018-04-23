package eu.senla.andyavd.ems.model.entities.enums;

public enum Role {

	ADMIN(Values.ADMIN), TEACHER(Values.TEACHER), STUDENT(Values.STUDENT);

	private String value;

	Role(String role) {
		this.value = role;
	}

	public String getValue() {
		return this.value;
	}

	public static class Values {
		public static final String ADMIN = "ADMIN";
		public static final String TEACHER = "TEACHER";
		public static final String STUDENT = "STUDENT";
	}
}
