package org.intellij.lang.jflex.fileTypes;

import javax.swing.Icon;

import org.intellij.lang.jflex.JFlexLanguage;
import org.intellij.lang.jflex.util.JFlexBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;

/**
 * JFlex file type.
 *
 * @author Alexey Efimov
 */
public final class JFlexFileType extends LanguageFileType
{
	public static final JFlexFileType INSTANCE = new JFlexFileType();

	@NonNls
	public static final String DEFAULT_EXTENSION = "flex";

	public JFlexFileType()
	{
		super(JFlexLanguage.INSTANCE);
	}

	@NotNull
	@NonNls
	public String getDefaultExtension()
	{
		return DEFAULT_EXTENSION;
	}

	@NotNull
	public String getDescription()
	{
		return JFlexBundle.message("jflex.filetype.description");
	}

	@Nullable
	public Icon getIcon()
	{
		return IconLoader.getIcon("/fileTypes/jflex.png");
	}

	@NotNull
	@NonNls
	public String getId()
	{
		return "JFlex";
	}
}
