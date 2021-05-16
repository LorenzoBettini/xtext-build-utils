package io.github.lorenzobettini.tychoxbasetestlanguage.swtbot.tests;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.root;
import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.waitForBuild;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Lorenzo Bettini
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class TychoxbasetestlanguageSWTBotTest {

	private static final String TEST_PROJECT = "io.github.lorenzobettini.tychoxbasetestlanguage.example";

	private static final String PROJECT_EXPLORER = "Project Explorer";

	private static SWTWorkbenchBot bot = new SWTWorkbenchBot();

	@Test
	public void canBuildExampleProject() throws Exception {
		closeWelcomePage();
		bot.menu("Window").menu("Show View").menu(PROJECT_EXPLORER).click();
		importProject(TEST_PROJECT);
		waitForBuild();
		assertErrorsInProject(0);
		isFileCreated(TEST_PROJECT, "src-gen", "example", "World.java");
	}


	private static void closeWelcomePage() {
		Display.getDefault().syncExec(() -> {
			IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
			if (introManager.getIntro() != null) {
				introManager.closeIntro(introManager.getIntro());
			}
		});
	}

	/**
	 * Imports an existing project into the running workspace for SWTBot tests.
	 * 
	 * IMPORTANT: projects to be imported are expected to be located in the
	 * "testprojects" folder, which is expected to be found in the parent folder of
	 * this project.
	 * 
	 * @param projectName
	 * @return
	 * @throws CoreException
	 * @throws InterruptedException 
	 * @throws InvocationTargetException 
	 */
	private static IProject importProject(String projectName) throws CoreException, InvocationTargetException, InterruptedException {
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String projectToImportPath = path + "/../" +  projectName;
		IProject project = importProject(new File(projectToImportPath), projectName);
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		return project;
	}

	private static IProject importProject(final File projectPath, final String projectName) throws CoreException, InvocationTargetException, InterruptedException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		ImportOperation importOperation = new ImportOperation(
				project.getFullPath(), // relative to the workspace
				projectPath, // absolute path
				FileSystemStructureProvider.INSTANCE,
				s -> IOverwriteQuery.ALL);
		// this means: copy the imported project into workspace
		importOperation.setCreateContainerStructure(false);
		importOperation.run(new NullProgressMonitor());
		return project;
	}

	private static void assertErrorsInProject(int numOfErrors) throws CoreException {
		IMarker[] markers = root().findMarkers(IMarker.PROBLEM, true,
				IResource.DEPTH_INFINITE);
		List<IMarker> errorMarkers = new LinkedList<IMarker>();
		for (int i = 0; i < markers.length; i++) {
			IMarker iMarker = markers[i];
			if (iMarker.getAttribute(IMarker.SEVERITY).toString()
					.equals("" + IMarker.SEVERITY_ERROR)) {
				errorMarkers.add(iMarker);
			}
		}
		assertEquals(
				"error markers: " + printMarkers(errorMarkers), numOfErrors,
				errorMarkers.size());
	}

	private static String printMarkers(List<IMarker> errorMarkers) {
		StringBuilder builder = new StringBuilder();
		for (IMarker iMarker : errorMarkers) {
			try {
				builder.append(iMarker.getAttribute(IMarker.MESSAGE) + "\n");
				builder.append(iMarker.getAttribute(IMarker.SEVERITY) + "\n");
			} catch (CoreException e) {
			}
		}
		return builder.toString();
	}

	private static void isFileCreated(String project, String... filePath) {
		getProjectTreeItem(project).expand().expandNode(filePath);
	}

	private static SWTBotTree getProjectTree() {
		SWTBotView packageExplorer = getProjectExplorer();
		SWTBotTree tree = packageExplorer.bot().tree();
		return tree;
	}

	private static SWTBotView getProjectExplorer() {
		SWTBotView view = bot.viewByTitle(PROJECT_EXPLORER);
		return view;
	}

	private static SWTBotTreeItem getProjectTreeItem(String myTestProject) {
		return getProjectTree().getTreeItem(myTestProject);
	}
}
