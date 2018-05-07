package org.intellij.lang.jflex.psi.impl;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import org.intellij.lang.jflex.psi.JFlexStatement;

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
