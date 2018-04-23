package eu.senla.andyavd.ems.web.permissions;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.senla.andyavd.ems.model.entities.enums.Role;

public class PermissionManager {
	static {
		permissionMap = new HashMap<String, Set<Role>>();
		loadMapForPath("permission.properties");
	}
	private static Map<String, Set<Role>> permissionMap;
	private static Logger logger = LogManager.getLogger(PermissionManager.class);

	public static void loadMapForPath(String path) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try (InputStream fis = loader.getResourceAsStream(path)) {
			Properties props = new Properties();
			props.load(fis);
			for (String key : props.stringPropertyNames()) {
				Set<Role> rolesSet = new HashSet<Role>();
				String roles = props.getProperty(key);
				for (String role : roles.split(",")) {
					if (role.equals("student")) {
						rolesSet.add(Role.STUDENT);
					} else if (role.equals("lecturer")) {
						rolesSet.add(Role.TEACHER);
					} else if (role.equals("admin")) {
						rolesSet.add(Role.ADMIN);
					}
				}
				permissionMap.put(key, rolesSet);
			}
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public static boolean checkPrivilegie(String path, Role role) {
		Set<Role> roles = permissionMap.get(path);
		if (roles != null) {
			return roles.contains(role);

		} else {
			return true;
		}
	}
}
