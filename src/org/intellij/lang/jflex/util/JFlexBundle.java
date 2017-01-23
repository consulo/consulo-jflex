package org.intellij.lang.jflex.util;

import org.jetbrains.annotations.PropertyKey;
import com.intellij.AbstractBundle;

public final class JFlexBundle extends AbstractBundle
{
	private static final String BUNDLE = "org.intellij.lang.jflex.util.JFlexBundle";
	private static final JFlexBundle ourInstance = new JFlexBundle();

	private JFlexBundle()
	{
		super(BUNDLE);
	}

	public static String message(@PropertyKey(resourceBundle = BUNDLE) String key)
	{
		return ourInstance.getMessage(key);
	}

	public static String message(@PropertyKey(resourceBundle = BUNDLE) String key, Object... params)
	{
		return ourInstance.getMessage(key, params);
	}
}
