package org.intellij.lang.jflex.psi.impl;

import consulo.language.ast.ASTNode;
import org.intellij.lang.jflex.psi.JFlexClassStatement;

import jakarta.annotation.Nonnull;

/**
 * Implementation of JFlex class statement.
 *
 * @author Alexey Efimov
 */
public class JFlexClassStatementImpl extends JFlexOptionStatementBase implements JFlexClassStatement {

    public JFlexClassStatementImpl(@Nonnull ASTNode node) {
        super(node);
    }

    public String toString() {
        return super.toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
