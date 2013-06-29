package org.intellij.lang.jflex.options;

import java.io.File;

import org.consulo.lombok.annotations.ProjectService;
import org.jetbrains.annotations.NonNls;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.components.StorageScheme;
import com.intellij.util.xmlb.XmlSerializerUtil;

/**
 * Options of JFlex.
 *
 * @author Alexey Efimov
 */
@ProjectService
@State(
		name = "JFlexSettings",
		storages = {
				@Storage(file = StoragePathMacros.PROJECT_FILE),
				@Storage(file = StoragePathMacros.PROJECT_CONFIG_DIR + "/compiler.xml", scheme = StorageScheme.DIRECTORY_BASED)
		}
)
public final class JFlexSettings implements PersistentStateComponent<JFlexSettings>
{
	@NonNls
	static final String TOOLS_DIR = "tools";
	@NonNls
	static final String IDEA_FLEX_SKELETON = "idea-flex.skeleton";
	@NonNls
	static final String DEFAULT_OPTIONS_CHARAT_NOBAK = "--charat --nobak";

	public boolean ENABLED_COMPILATION = true;
	public String JFLEX_HOME = getDefaultJFlexHome();
	public String SKELETON_PATH = getDefaultSkeletonPath(JFLEX_HOME);
	public String COMMAND_LINE_OPTIONS = DEFAULT_OPTIONS_CHARAT_NOBAK;
	public boolean ENABLED_EMBED_JAVA = true;

	public JFlexSettings getState()
	{
		return this;
	}

	public void loadState(JFlexSettings state)
	{
		XmlSerializerUtil.copyBean(state, this);
	}

	public static String getDefaultSkeletonPath(String jFlexHome)
	{
		return new File(jFlexHome, IDEA_FLEX_SKELETON).getPath();
	}

	public static String getDefaultJFlexHome()
	{
		return new File(new File(PathManager.getHomePath(), TOOLS_DIR), "jflex").getPath();
	}
}
