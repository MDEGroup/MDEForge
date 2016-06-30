package org.mdeforge.presentation.backend;

import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("workspaceList")
public class WorkspaceTilesController implements ViewPreparer {

	@Autowired
	private WorkspaceService workspaceService;
	@Autowired
	private User user;

	public void execute(Request tilesRequest, AttributeContext attributeContext)
			throws PreparerException {
		List<Workspace> wl = workspaceService.findByUser(user);
		attributeContext.putAttribute("logged_user", new Attribute(user));
		attributeContext.putAttribute("workspaces_list", new Attribute(wl));
	}

}
