package org.intellij.lang.jflex.psi.impl;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import org.intellij.lang.jflex.JFlexElementTypes;
import org.intellij.lang.jflex.psi.JFlexExpression;
import org.intellij.lang.jflex.psi.JFlexImplementsStatement;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 18.03.2008
 * Time: 23:53:42
 */
public class JFlexImplementsStatementImpl extends JFlexElementImpl implements JFlexImplementsStatement {

    public JFlexImplementsStatementImpl(@Nonnull ASTNode node) {
        super(node);
    }

    public JFlexExpression[] getInterfaces() {
        ASTNode[] nodes = getNode().getChildren(JFlexElementTypes.EXPRESSIONS);
        JFlexExpression[] result = new JFlexExpression[nodes.length];
        int i = 0;
        for (ASTNode node : nodes) {
            result[i++] = (JFlexExpression) node.getPsi();
        }
        return result;
    }

}
