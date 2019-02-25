package org.intellij.lang.jflex;

import com.intellij.lang.Language;

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
