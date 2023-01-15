package org.intellij.lang.jflex.fileTypes;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.editor.highlight.SingleLazyInstanceSyntaxHighlighterFactory;
import consulo.language.editor.highlight.SyntaxHighlighter;
import org.intellij.lang.jflex.JFlexLanguage;

import javax.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 2019-02-25
 */
@ExtensionImpl
public class JFlexSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
    @Nonnull
    @Override
    protected SyntaxHighlighter createHighlighter() {
        return new JFlexSyntaxHighlighter();
    }

    @Nonnull
    @Override
    public Language getLanguage() {
        return JFlexLanguage.INSTANCE;
    }
}
