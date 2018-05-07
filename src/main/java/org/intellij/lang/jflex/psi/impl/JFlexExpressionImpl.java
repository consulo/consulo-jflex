package org.intellij.lang.jflex.psi.impl;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import org.intellij.lang.jflex.psi.JFlexExpression;

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
