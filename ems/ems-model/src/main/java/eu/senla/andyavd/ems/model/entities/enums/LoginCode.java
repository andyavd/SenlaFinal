package eu.senla.andyavd.ems.model.entities.enums;

public enum LoginCode {
	
	SUCCESSFULL_AUTHENTIFICATION(3000), WRONG_PASSWORD(3001), LOGIN_DOESNOT_EXIST(3002), LOGIN_EXISTS(3003), INVALID_INPUT(3004);
	int code;

	LoginCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}