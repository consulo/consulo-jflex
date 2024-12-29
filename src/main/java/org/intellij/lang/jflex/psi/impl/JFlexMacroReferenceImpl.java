package org.intellij.lang.jflex.psi.impl;

import consulo.application.util.query.Query;
import consulo.document.util.TextRange;
import consulo.language.ast.ASTNode;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiElementVisitor;
import consulo.language.psi.PsiReference;
import consulo.language.psi.search.ReferencesSearch;
import consulo.language.util.IncorrectOperationException;
import org.intellij.lang.jflex.psi.JFlexMacroDefinition;
import org.intellij.lang.jflex.psi.JFlexMacroReference;
import org.intellij.lang.jflex.psi.JFlexPsiFile;
import org.intellij.lang.jflex.validation.JFlexAnnotatingVisitor;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 19.03.2008
 * Time: 23:22:03
 */
public class JFlexMacroReferenceImpl extends JFlexElementImpl implements JFlexMacroReference {

    public JFlexMacroReferenceImpl(@Nonnull ASTNode node) {
        super(node);
    }

    public PsiReference getReference() {
        return this;
    }

    public void accept(@Nonnull PsiElementVisitor visitor) {
        if (visitor instanceof JFlexAnnotatingVisitor) {
            ((JFlexAnnotatingVisitor) visitor).visitMacroReference(this);
        }
    }

    public PsiElement getElement() {
        return this;
    }

    public TextRange getRangeInElement() {
        return new TextRange(0, getTextLength());
    }

    @Nullable
    public PsiElement resolve() {
        //Is it the correct way?
        JFlexPsiFile file = (JFlexPsiFile) this.getContainingFile();
        JFlexMacroDefinition[] macroses = file.getDeclaredMacroses();
        for (JFlexMacroDefinition m : macroses) {
            if (getText().equals(m.getName())) {
                return m;
            }
        }
        return null;
    }

    public int getTextOffset() {
        return super.getTextOffset();
    }

    public String getCanonicalText() {
        return getText();
    }

    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        throw new IncorrectOperationException();
    }

    public PsiElement bindToElement(@Nonnull PsiElement element) throws IncorrectOperationException {
        throw new IncorrectOperationException();
    }

    public boolean isReferenceTo(PsiElement element) {
        return element instanceof JFlexMacroDefinition && ((JFlexMacroDefinition) element).getName().equals(getText());
    }

    public Object[] getVariants() {
        Query query = ReferencesSearch.search(this);
        return query.findAll().toArray();
    }

    public boolean isSoft() {
        return false;
    }
}
