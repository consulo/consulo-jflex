package org.intellij.lang.jflex.vfs.backgroundTask;

import org.consulo.java.platform.module.extension.JavaModuleExtension;
import org.consulo.vfs.backgroundTask.BackgroundTaskByVfsChangeProvider;
import org.consulo.vfs.backgroundTask.BackgroundTaskByVfsParameters;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.SdkTable;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * @author VISTALL
 * @since 07.10.13.
 */
public class JFlexBackgroundTaskByVfsChangeProvider implements BackgroundTaskByVfsChangeProvider
{
	@Override
	public boolean validate(@NotNull Project project, @NotNull VirtualFile virtualFile)
	{
		return true;
	}

	@Override
	public void setDefaultParameters(@NotNull Project project, @NotNull VirtualFile virtualFile, @NotNull BackgroundTaskByVfsParameters backgroundTaskByVfsParameters)
	{
		Sdk sdk = null;
		Module module = ModuleUtilCore.findModuleForFile(virtualFile, project);
		if(module != null) {
			sdk = ModuleUtilCore.getSdk(module, JavaModuleExtension.class);
		}

		if(sdk == null) {
			sdk = SdkTable.getInstance().findBundleSdkByType(JavaSdk.class);
		}

		if(sdk == null) {
			sdk = SdkTable.getInstance().findMostRecentSdkOfType(JavaSdk.getInstance());
		}

		if(sdk != null) {
			String vmExecutablePath = JavaSdk.getInstance().getVMExecutablePath(sdk);
			backgroundTaskByVfsParameters.setExePath(vmExecutablePath);
		}
		else {
			backgroundTaskByVfsParameters.setExePath(SystemInfo.isWindows ? "java.exe" : "java");
		}

		backgroundTaskByVfsParameters.setProgramParameters("-jar jflex/lib/jflex.jar --charat --nobak --skel idea-flex.skeleton $FilePath$");
		backgroundTaskByVfsParameters.setWorkingDirectory("$FileParentPath$");
		backgroundTaskByVfsParameters.setOutPath("$FileParentPath$");
	}

	@NotNull
	@Override
	public String getName()
	{
		return "JFlex";
	}
}
