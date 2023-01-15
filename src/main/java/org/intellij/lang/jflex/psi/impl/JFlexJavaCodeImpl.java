package org.intellij.lang.jflex.psi.impl;

import consulo.document.util.TextRange;
import consulo.language.ast.ASTNode;
import consulo.language.inject.InjectedLanguageManager;
import consulo.language.psi.LiteralTextEscaper;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiLanguageInjectionHost;
import consulo.util.lang.Pair;
import org.intellij.lang.jflex.JFlexElementTypes;
import org.intellij.lang.jflex.injection.EmbeddedJavaLiteralTextEscaper;
import org.intellij.lang.jflex.psi.JFlexJavaCode;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 15.03.2008
 * Time: 18:51:14
 */
public class JFlexJavaCodeImpl extends JFlexElementImpl implements JFlexJavaCode {

    public JFlexJavaCodeImpl(@Nonnull ASTNode node) {
        super(node);
    }

    @Override
    public boolean isValidHost() {
        return true;
    }

    public boolean isMatchAction() {
        ASTNode prev = getNode().getTreePrev();
        return prev != null && prev.getElementType() == JFlexElementTypes.LEFT_BRACE;
    }

    @Nullable
    @Deprecated
    public List<Pair<PsiElement, TextRange>> getInjectedPsi() {
        return InjectedLanguageManager.getInstance(getProject()).getInjectedPsiFiles(this);
    }

    public PsiLanguageInjectionHost updateText(@Nonnull String text) {
        return this;
    }

    @Nonnull
    public LiteralTextEscaper<JFlexJavaCode> createLiteralTextEscaper() {
        return new EmbeddedJavaLiteralTextEscaper(this);
    }
}
