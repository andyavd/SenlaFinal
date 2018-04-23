package eu.senla.andyavd.ems.web.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.RequestContextFilter;

import eu.senla.andyavd.ems.model.entities.User;
import eu.senla.andyavd.ems.utils.holders.CurrentUserHolder;
import eu.senla.andyavd.ems.utils.providers.ApplicationContextProvider;
import eu.senla.andyavd.ems.web.permissions.JWTManager;

public class JWTFilter extends RequestContextFilter {

	private static final int STATUS_CODE_UNAUTHORISED = 401;
	private static final String REQUEST_AUTH_HEADER = "Auth";

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String token = request.getHeader(REQUEST_AUTH_HEADER);
		if (JWTManager.verifyToken(token)) {
			User user = JWTManager.getCurrentUserByToken(token);
			setCurrentUser(user);
			chain.doFilter(request, response);
		} else {
			response.setContentLength(0);
			response.setStatus(STATUS_CODE_UNAUTHORISED);
		}
	}

	private void setCurrentUser(User user) {
		CurrentUserHolder PersonHolder = ApplicationContextProvider.getApplicationContext()
				.getBean(CurrentUserHolder.class);
		PersonHolder.setCurrentUser(user);
	}
}
