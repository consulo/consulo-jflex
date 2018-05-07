package org.intellij.lang.jflex.psi.impl;

import java.util.List;

import javax.annotation.Nonnull;

import org.intellij.lang.jflex.JFlexElementTypes;
import org.intellij.lang.jflex.injection.EmbeddedJavaLiteralTextEscaper;
import org.intellij.lang.jflex.psi.JFlexJavaCode;

import javax.annotation.Nullable;
import com.intellij.lang.ASTNode;
import com.intellij.lang.injection.InjectedLanguageManager;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.impl.source.tree.injected.InjectedLanguageUtil;

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

    public void processInjectedPsi(@Nonnull InjectedPsiVisitor visitor) {
        InjectedLanguageUtil.enumerate(this, visitor);
    }

    public PsiLanguageInjectionHost updateText(@Nonnull String text) {
        return this;
    }

    public void fixText(@Nonnull String text) {
    }

    @Nonnull
    public LiteralTextEscaper<JFlexJavaCode> createLiteralTextEscaper() {
        return new EmbeddedJavaLiteralTextEscaper(this);
    }
}
