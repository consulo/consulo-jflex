package org.intellij.lang.jflex;

import consulo.jflex.localize.JFlexLocalize;
import consulo.language.Language;
import consulo.localize.LocalizeValue;
import jakarta.annotation.Nonnull;

/**
 * JFlex language.
 *
 * @author Alexey Efimov
 */
public class JFlexLanguage extends Language {
    public static final JFlexLanguage INSTANCE = new JFlexLanguage();

    public JFlexLanguage() {
        super("JFLEX");
    }

    @Nonnull
    @Override
    public LocalizeValue getDisplayName() {
        return JFlexLocalize.jflex();
    }
}
