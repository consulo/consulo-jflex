package org.intellij.lang.jflex.psi.impl;

import consulo.language.ast.ASTNode;
import org.intellij.lang.jflex.psi.JFlexStatement;

import javax.annotation.Nonnull;

/**
 * JFlex statement implementation
 *
 * @author Alexey Efimov
 */
public class JFlexStatementImpl extends JFlexElementImpl implements JFlexStatement {
    public JFlexStatementImpl(@Nonnull ASTNode node) {
        super(node);
    }

}
