package org.intellij.lang.jflex;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import org.intellij.lang.jflex.fileTypes.JFlexSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

/**
 * JFlex language.
 *
 * @author Alexey Efimov
 */
public class JFlexLanguage extends Language {
    public static final JFlexLanguage INSTANCE = new JFlexLanguage();

    public JFlexLanguage() {
        super("JFLEX");

        //somehow lang.syntaxHighlighterFactory extension won't work for me
        SyntaxHighlighterFactory.LANGUAGE_FACTORY.addExplicitExtension(this, new SingleLazyInstanceSyntaxHighlighterFactory() {
            @NotNull
            protected SyntaxHighlighter createHighlighter() {
                return new JFlexSyntaxHighlighter();
            }
        });
    }

}
