package org.intellij.lang.jflex.options;

import javax.swing.JComponent;

import org.intellij.lang.jflex.util.JFlexBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;

/**
 * Configurable for JFlex.
 *
 * @author Alexey Efimov
 */
public final class JFlexConfigurable implements Configurable
{
	private JFlexSettingsForm settingsForm;
	private JFlexSettings myJFlexSettings;

	public JFlexConfigurable(Project project)
	{
		myJFlexSettings = JFlexSettings.getInstance(project);
	}

	@Nls
	public String getDisplayName()
	{
		return JFlexBundle.message("jflex");
	}

	@Nullable
	@NonNls
	public String getHelpTopic()
	{
		return null;
	}

	public JComponent createComponent()
	{
		if(settingsForm == null)
		{
			settingsForm = new JFlexSettingsForm(myJFlexSettings);
		}
		return settingsForm.getFormComponent();
	}

	public boolean isModified()
	{
		return settingsForm != null && settingsForm.isModified(myJFlexSettings);
	}

	public void apply() throws ConfigurationException
	{
		if(settingsForm != null)
		{
			myJFlexSettings.loadState(settingsForm.getState());
		}
	}

	public void reset()
	{
		if(settingsForm != null)
		{
			settingsForm.loadState(myJFlexSettings);
		}
	}

	public void disposeUIResources()
	{
		settingsForm = null;
	}
}
