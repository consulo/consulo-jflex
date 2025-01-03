package org.intellij.lang.jflex.psi.impl;

import consulo.language.ast.ASTNode;
import org.intellij.lang.jflex.JFlexElementTypes;
import org.intellij.lang.jflex.psi.JFlexExpression;
import org.intellij.lang.jflex.psi.JFlexOptionStatement;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 17.03.2008
 * Time: 23:21:47
 */
public abstract class JFlexOptionStatementBase extends JFlexElementImpl implements JFlexOptionStatement {

    public JFlexOptionStatementBase(@Nonnull ASTNode node) {
        super(node);
    }

    @Nullable
    public JFlexExpression getValue() {
        final ASTNode node = getNode().findChildByType(JFlexElementTypes.EXPRESSIONS);
        return (JFlexExpression) (node != null ? node.getPsi() : null);
    }

}
