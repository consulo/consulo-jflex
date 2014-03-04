package org.intellij.lang.jflex.vfs.backgroundTask;

import org.consulo.java.module.extension.JavaModuleExtension;
import org.consulo.vfs.backgroundTask.BackgroundTaskByVfsChangeProvider;
import org.consulo.vfs.backgroundTask.BackgroundTaskByVfsParameters;
import org.intellij.lang.jflex.psi.JFlexElement;
import org.intellij.lang.jflex.psi.JFlexPsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.generate.tostring.util.StringUtil;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.SdkTable;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.util.ArrayUtil;

/**
 * @author VISTALL
 * @since 07.10.13.
 */
public class JFlexBackgroundTaskByVfsChangeProvider extends BackgroundTaskByVfsChangeProvider
{
	@Override
	public void setDefaultParameters(@NotNull Project project, @NotNull VirtualFile virtualFile, @NotNull BackgroundTaskByVfsParameters
			backgroundTaskByVfsParameters)
	{
		Sdk sdk = null;
		Module module = ModuleUtilCore.findModuleForFile(virtualFile, project);
		if(module != null)
		{
			sdk = ModuleUtilCore.getSdk(module, JavaModuleExtension.class);
		}

		if(sdk == null)
		{
			sdk = SdkTable.getInstance().findBundleSdkByType(JavaSdk.class);
		}

		if(sdk == null)
		{
			sdk = SdkTable.getInstance().findMostRecentSdkOfType(JavaSdk.getInstance());
		}

		if(sdk != null)
		{
			String vmExecutablePath = JavaSdk.getInstance().getVMExecutablePath(sdk);
			backgroundTaskByVfsParameters.setExePath(vmExecutablePath);
		}
		else
		{
			backgroundTaskByVfsParameters.setExePath(SystemInfo.isWindows ? "java.exe" : "java");
		}

		backgroundTaskByVfsParameters.setProgramParameters("-jar jflex/lib/jflex.jar --charat --nobak --skel idea-flex.skeleton $FilePath$");
		backgroundTaskByVfsParameters.setWorkingDirectory("$FileParentPath$");
		backgroundTaskByVfsParameters.setOutPath("$FileParentPath$");
	}

	@NotNull
	@Override
	public String[] getGeneratedFiles(@NotNull PsiFile psiFile)
	{
		if(!(psiFile instanceof JFlexPsiFile))
		{
			return ArrayUtil.EMPTY_STRING_ARRAY;
		}
		JFlexElement classname = ((JFlexPsiFile) psiFile).getClassname();
		if(classname == null)
		{
			return ArrayUtil.EMPTY_STRING_ARRAY;
		}
		String text = classname.getText();
		if(StringUtil.isEmpty(text))
		{
			return ArrayUtil.EMPTY_STRING_ARRAY;
		}
		return new String[] {"$OutPath$/" + text + JavaFileType.DOT_DEFAULT_EXTENSION};
	}

	@NotNull
	@Override
	public String getName()
	{
		return "JFlex";
	}
}
