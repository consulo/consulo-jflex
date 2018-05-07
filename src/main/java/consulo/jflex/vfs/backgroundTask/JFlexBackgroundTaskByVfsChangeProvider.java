package consulo.jflex.vfs.backgroundTask;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.intellij.lang.jflex.fileTypes.JFlexFileType;
import org.intellij.lang.jflex.psi.JFlexElement;
import org.intellij.lang.jflex.psi.JFlexPsiFile;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.projectRoots.JavaSdkType;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.SdkTable;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.util.ArrayUtil;
import consulo.backgroundTaskByVfsChange.BackgroundTaskByVfsChangeProvider;
import consulo.backgroundTaskByVfsChange.BackgroundTaskByVfsParameters;
import consulo.java.module.extension.JavaModuleExtension;

/**
 * @author VISTALL
 * @since 07.10.13.
 */
public class JFlexBackgroundTaskByVfsChangeProvider extends BackgroundTaskByVfsChangeProvider.ByFileType
{
	public JFlexBackgroundTaskByVfsChangeProvider()
	{
		super(JFlexFileType.INSTANCE);
	}

	@Override
	public void setDefaultParameters(@Nonnull Project project, @Nonnull VirtualFile virtualFile, @Nonnull BackgroundTaskByVfsParameters
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
			sdk = SdkTable.getInstance().findPredefinedSdkByType(JavaSdk.getInstance());
		}

		if(sdk == null)
		{
			sdk = SdkTable.getInstance().findMostRecentSdkOfType(JavaSdk.getInstance());
		}

		List<String> parameters = new ArrayList<String>();
		if(sdk != null)
		{
			GeneralCommandLine generalCommandLine = new GeneralCommandLine();

			((JavaSdkType) sdk.getSdkType()).setupCommandLine(generalCommandLine, sdk);
			parameters.addAll(generalCommandLine.getParametersList().getList());
		}
		else
		{
			backgroundTaskByVfsParameters.setExePath(SystemInfo.isWindows ? "java.exe" : "java");
		}

		parameters.add("-jar");
		parameters.add("jflex/lib/jflex.jar");
		parameters.add("$FilePath$");

		backgroundTaskByVfsParameters.setProgramParameters(StringUtil.join(parameters, " "));
		backgroundTaskByVfsParameters.setWorkingDirectory("$FileParentPath$");
		backgroundTaskByVfsParameters.setOutPath("$FileParentPath$");
	}

	@Nonnull
	@Override
	public String getTemplateName()
	{
		return "JFlex";
	}

	@Nonnull
	@Override
	public String[] getGeneratedFiles(@Nonnull PsiFile psiFile)
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
}
