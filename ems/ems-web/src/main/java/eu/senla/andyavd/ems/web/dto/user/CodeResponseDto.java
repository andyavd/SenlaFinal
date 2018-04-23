package eu.senla.andyavd.ems.web.dto.user;

import eu.senla.andyavd.ems.model.entities.enums.LoginCode;

public class CodeResponseDto {

	private Integer code;
	private String token;

	public CodeResponseDto() {

	}

	public CodeResponseDto(LoginCode code) {
		this(code, null);
	}

	public CodeResponseDto(LoginCode code, String token) {
		this.code = code.getCode();
		this.token = token;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
