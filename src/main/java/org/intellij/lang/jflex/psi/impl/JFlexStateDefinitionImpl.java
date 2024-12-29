package org.intellij.lang.jflex.psi.impl;

import consulo.language.ast.ASTNode;
import consulo.language.psi.PsiElement;
import consulo.language.util.IncorrectOperationException;
import org.intellij.lang.jflex.psi.JFlexStateDefinition;
import org.jetbrains.annotations.NonNls;

import jakarta.annotation.Nonnull;

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
