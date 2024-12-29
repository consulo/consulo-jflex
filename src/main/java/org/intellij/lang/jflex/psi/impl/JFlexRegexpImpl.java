package org.intellij.lang.jflex.psi.impl;

import consulo.language.ast.ASTNode;
import org.intellij.lang.jflex.psi.JFlexRegexp;

import jakarta.annotation.Nonnull;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 22.03.2008
 * Time: 23:18:54
 */
public class JFlexRegexpImpl extends JFlexElementImpl implements JFlexRegexp {

    public JFlexRegexpImpl(@Nonnull ASTNode node) {
        super(node);
    }

}
