package org.intellij.lang.jflex.lexer;

import consulo.language.ast.TokenSet;
import consulo.language.lexer.MergingLexerAdapter;
import org.intellij.lang.jflex.JFlexElementTypes;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 15.03.2008
 * Time: 15:36:05
 */
public class JFlexMergingLexer extends MergingLexerAdapter {

    public static final TokenSet mergeme = TokenSet.create(JFlexElementTypes.JAVA_CODE);

    public JFlexMergingLexer() {
        super(new _JFlexLexer(), mergeme);
    }
}
