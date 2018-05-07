package org.intellij.lang.jflex.psi.impl;

import com.intellij.lang.ASTNode;
import org.intellij.lang.jflex.psi.JFlexTypeStatement;
import javax.annotation.Nonnull;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 17.03.2008
 * Time: 23:19:57
 */
public class JFlexTypeStatementImpl extends JFlexOptionStatementBase implements JFlexTypeStatement {

    public JFlexTypeStatementImpl(@Nonnull ASTNode node) {
        super(node);
    }

}
