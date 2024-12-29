package org.intellij.lang.jflex.psi.impl;

import consulo.language.ast.ASTNode;
import org.intellij.lang.jflex.psi.JFlexExpression;

import jakarta.annotation.Nonnull;

/**
 * JFlex expression implmentation.
 *
 * @author Alexey Efimov
 */
public class JFlexExpressionImpl extends JFlexElementImpl implements JFlexExpression {

    public JFlexExpressionImpl(@Nonnull ASTNode node) {
        super(node);
    }

}
