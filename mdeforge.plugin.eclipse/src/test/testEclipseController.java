package test;

import static org.junit.Assert.*;
import mdeforge.plugin.eclipse.eclipsecontrol.EclipseController;

import org.eclipse.core.runtime.CoreException;
import org.junit.Test;

public class testEclipseController {

	@Test
	public void testDownloadProject() throws CoreException {
		
		EclipseController.downloadProject("test_auto", null);
		
	}

}
