package org.intellij.lang.jflex.lexer;

import org.intellij.lang.jflex.JFlexElementTypes;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;

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
