package org.mdeforge.client;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;

public class UserTest {

	private static ATLTransformationService atlTransformationService;
	private static ETLTransformationService etlTransformationService;
	private static EcoreMetamodelService ecoreMetamodelService;
	private static ProjectService projectService;
	private static WorkspaceService workspaceService;
	private static UserService userService;

	@BeforeClass
	public static void setup() throws Exception {
		atlTransformationService = new ATLTransformationService(
				"http://localhost:8080/mdeforge/", "Admin", "test123");
		etlTransformationService = new ETLTransformationService(
				"http://localhost:8080/mdeforge/", "Admin", "test123");
		ecoreMetamodelService = new EcoreMetamodelService(
				"http://localhost:8080/mdeforge/", "Admin", "test123");
		projectService = new ProjectService("http://localhost:8080/mdeforge/",
				"Admin", "test123");
		workspaceService = new WorkspaceService(
				"http://localhost:8080/mdeforge/", "Admin", "test123");
		userService = new UserService("http://localhost:8080/mdeforge/",
				"Admin", "test123");
	}

	@Test
	public void getUsers() throws Exception {
		List<User> userList = userService.getUsers();
		for (User user : userList) {
			System.out.println(user.getFirstname());
		}
	}

	@Test
	public void getUser() throws Exception {
		User user = userService.getUser("5514b943d4c6c379396fe8b7");
		System.out.println(user.getFirstname());
		user = userService.getUser("55ae5947d4c677485a267bca");
		System.out.println(user.getFirstname());
	}
}
