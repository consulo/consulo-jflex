package consulo.jflex.vfs.backgroundTask;

import com.intellij.java.language.impl.JavaFileType;
import com.intellij.java.language.projectRoots.JavaSdkType;
import consulo.annotation.component.ExtensionImpl;
import consulo.application.util.SystemInfo;
import consulo.content.bundle.Sdk;
import consulo.content.bundle.SdkTable;
import consulo.java.language.module.extension.JavaModuleExtension;
import consulo.language.psi.PsiFile;
import consulo.language.util.ModuleUtilCore;
import consulo.module.Module;
import consulo.process.cmd.GeneralCommandLine;
import consulo.project.Project;
import consulo.util.collection.ArrayUtil;
import consulo.util.lang.StringUtil;
import consulo.virtualFileSystem.VirtualFile;
import consulo.virtualFileSystem.fileWatcher.BackgroundTaskByVfsChangeProvider;
import consulo.virtualFileSystem.fileWatcher.BackgroundTaskByVfsParameters;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import org.intellij.lang.jflex.fileTypes.JFlexFileType;
import org.intellij.lang.jflex.psi.JFlexElement;
import org.intellij.lang.jflex.psi.JFlexPsiFile;

import jakarta.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VISTALL
 * @since 07.10.13.
 */
@ExtensionImpl
public class JFlexBackgroundTaskByVfsChangeProvider extends BackgroundTaskByVfsChangeProvider.ByFileType
{
	private final Provider<SdkTable> mySdkTable;

	@Inject
	public JFlexBackgroundTaskByVfsChangeProvider(Provider<SdkTable> sdkTable)
	{
		super(JFlexFileType.INSTANCE);
		mySdkTable = sdkTable;
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

		SdkTable sdkTable = mySdkTable.get();
		if(sdk == null)
		{
			sdk = sdkTable.findMostRecentSdk(it -> it.getSdkType() instanceof JavaSdkType);
		}

		List<String> parameters = new ArrayList<>();
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
