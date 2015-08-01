package mdeforge.plugin.ui.decorators;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


public class ProjectDecorator extends LabelProvider implements ILightweightLabelDecorator {

	public static final String ICON = "/icons/logo-decorator.gif";
	private static Font font = new Font(null, "Arial", 10, 0);
	private static Color color = new Color(null, 0, 0, 255);
	
	@Override
	public void decorate(Object element, IDecoration decoration) {
		
		decoration.addOverlay(ImageDescriptor.createFromFile(ProjectDecorator.class, ICON), IDecoration.TOP_RIGHT);
		decoration.addPrefix("<T> ");
		decoration.addSuffix(" marker(s)");
		decoration.setFont(font);
		decoration.setForegroundColor(color);
	}

}
