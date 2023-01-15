package org.intellij.lang.jflex.fileTypes;

import consulo.application.AllIcons;
import consulo.jflex.localize.JFlexLocalize;
import consulo.language.file.LanguageFileType;
import consulo.localize.LocalizeValue;
import consulo.ui.image.Image;
import org.intellij.lang.jflex.JFlexLanguage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * JFlex file type.
 *
 * @author Alexey Efimov
 */
public final class JFlexFileType extends LanguageFileType {
    public static final JFlexFileType INSTANCE = new JFlexFileType();

    public static final String DEFAULT_EXTENSION = "flex";

    public JFlexFileType() {
        super(JFlexLanguage.INSTANCE);
    }

    @Nonnull
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nonnull
    public LocalizeValue getDescription() {
        return JFlexLocalize.jflexFiletypeDescription();
    }

    @Nullable
    public Image getIcon() {
        return AllIcons.FileTypes.Text;
    }

    @Nonnull
    public String getId() {
        return "JFlex";
    }
}
