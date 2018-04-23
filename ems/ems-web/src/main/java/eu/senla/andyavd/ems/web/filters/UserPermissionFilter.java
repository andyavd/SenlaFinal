package eu.senla.andyavd.ems.web.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.RequestContextFilter;

import eu.senla.andyavd.ems.utils.supporters.ICurrentUserSupporter;
import eu.senla.andyavd.ems.web.permissions.PermissionManager;

public class UserPermissionFilter extends RequestContextFilter implements ICurrentUserSupporter {
	private static final Integer STATUS_CODE_FORBIDDEN = 403;

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String path = request.getServletPath();
		if (PermissionManager.checkPrivilegie(path.replaceAll("[0-9]+", "*"), getCurrentUser().getRole())) {
			chain.doFilter(request, response);
		} else {
			response.setContentLength(0);
			response.setStatus(STATUS_CODE_FORBIDDEN);
		}
	}
}
