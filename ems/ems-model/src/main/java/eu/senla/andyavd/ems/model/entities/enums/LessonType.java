package eu.senla.andyavd.ems.model.entities.enums;

public enum LessonType {

	LECTURE(Values.LECTURE), SEMINAR(Values.SEMINAR), TEST(Values.TEST);

	private String value;

	LessonType(String lessonType) {
		this.value = lessonType;
	}

	public String getValue() {
		return this.value;
	}

	public static class Values {
		public static final String LECTURE = "LECTURE";
		public static final String SEMINAR = "SEMINAR";
		public static final String TEST = "TEST";
	}
}
