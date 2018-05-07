package org.intellij.lang.jflex.psi.impl;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.intellij.lang.jflex.psi.JFlexStateDefinition;
import org.jetbrains.annotations.NonNls;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 24.03.2008
 * Time: 23:34:47
 */
public class JFlexStateDefinitionImpl extends JFlexElementImpl implements JFlexStateDefinition {

    public JFlexStateDefinitionImpl(@Nonnull ASTNode node) {
        super(node);
    }

    public String getName() {
        return getText();
    }

    public PsiElement setName(@NonNls @Nonnull String name) throws IncorrectOperationException {
        throw new IncorrectOperationException();
    }

}
