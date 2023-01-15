package org.intellij.lang.jflex;

import consulo.language.Language;

/**
 * JFlex language.
 *
 * @author Alexey Efimov
 */
public class JFlexLanguage extends Language
{
	public static final JFlexLanguage INSTANCE = new JFlexLanguage();

	public JFlexLanguage()
	{
		super("JFLEX");
	}
}
