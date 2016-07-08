package org.intellij.lang.jflex.options;

import consulo.lombok.annotations.ProjectService;
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
				@Storage(file = StoragePathMacros.WORKSPACE_FILE, scheme = StorageScheme.DIRECTORY_BASED)
		}
)
public final class JFlexSettings implements PersistentStateComponent<JFlexSettings>
{
	public boolean ENABLED_EMBED_JAVA = true;

	public JFlexSettings getState()
	{
		return this;
	}

	public void loadState(JFlexSettings state)
	{
		XmlSerializerUtil.copyBean(state, this);
	}
}
