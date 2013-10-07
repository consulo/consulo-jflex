package org.intellij.lang.jflex.options;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import org.jetbrains.annotations.NonNls;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.ui.StateRestoringCheckBox;

/**
 * JFlex options.
 *
 * @author Alexey Efimov
 */
public final class JFlexSettingsForm implements PersistentStateComponent<JFlexSettings>
{
	@NonNls
	private static final String JFLEX_ENABLED_EMBED_JAVA_KEY = "JFlex.EnabledEmbedJava";
	private final JFlexSettings settings = new JFlexSettings();
	private JPanel formComponent;
	private JCheckBox enabledEmbedJavaCheckBox;

	public JFlexSettingsForm(JFlexSettings settings)
	{
		loadState(settings);
	}

	private void createUIComponents()
	{
		enabledEmbedJavaCheckBox = new StateRestoringCheckBox(JFLEX_ENABLED_EMBED_JAVA_KEY, true);
	}

	public JComponent getFormComponent()
	{
		return formComponent;
	}

	public boolean isModified(JFlexSettings state)
	{
		return enabledEmbedJavaCheckBox.isSelected() != state.ENABLED_EMBED_JAVA;
	}

	@Override
	public final JFlexSettings getState()
	{
		settings.ENABLED_EMBED_JAVA = enabledEmbedJavaCheckBox.isSelected();
		return settings;
	}

	@Override
	public final void loadState(JFlexSettings state)
	{
		settings.loadState(state);
		enabledEmbedJavaCheckBox.setSelected(state.ENABLED_EMBED_JAVA);
	}
}
