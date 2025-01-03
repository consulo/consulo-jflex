package org.intellij.lang.jflex.psi.impl;

import consulo.language.Language;
import consulo.language.ast.ASTNode;
import consulo.language.impl.psi.ASTWrapperPsiElement;
import org.intellij.lang.jflex.JFlexLanguage;
import org.intellij.lang.jflex.psi.JFlexElement;
import org.jetbrains.annotations.NonNls;

import jakarta.annotation.Nonnull;

/**
 * JFlex base element.
 *
 * @author Alexey Efimov
 */
public class JFlexElementImpl extends ASTWrapperPsiElement implements JFlexElement {

    @NonNls
    private static final String IMPL = "Impl";

    public JFlexElementImpl(@Nonnull ASTNode node) {
        super(node);
    }

    public String toString() {
        String classname = getClass().getName();
        if (classname.endsWith(IMPL)) {
            classname = classname.substring(0, classname.length() - IMPL.length());
        }

        classname = classname.substring(classname.lastIndexOf(".") + 1);
        return classname;
    }
}
