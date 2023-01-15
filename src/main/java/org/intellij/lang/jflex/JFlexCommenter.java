package org.intellij.lang.jflex;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Commenter;
import consulo.language.Language;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 01.04.2008
 * Time: 23:39:04
 */
@ExtensionImpl
public class JFlexCommenter implements Commenter {
    @Nullable
    public String getBlockCommentPrefix() {
        return null;
    }

    @Nullable
    public String getBlockCommentSuffix() {
        return null;
    }

    @Nullable
    public String getLineCommentPrefix() {
        return "//";
    }

    public String getCommentedBlockCommentSuffix() {
        return null;
    }

    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Nonnull
    @Override
    public Language getLanguage() {
        return JFlexLanguage.INSTANCE;
    }
}
