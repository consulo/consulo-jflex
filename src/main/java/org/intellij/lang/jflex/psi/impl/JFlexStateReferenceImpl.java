package org.intellij.lang.jflex.psi.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.intellij.lang.jflex.psi.JFlexPsiFile;
import org.intellij.lang.jflex.psi.JFlexStateDefinition;
import org.intellij.lang.jflex.psi.JFlexStateReference;
import org.intellij.lang.jflex.psi.JFlexStateStatement;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 28.03.2008
 * Time: 9:11:25
 */
public class JFlexStateReferenceImpl extends JFlexElementImpl implements JFlexStateReference {

    public JFlexStateReferenceImpl(@Nonnull ASTNode node) {
        super(node);
    }

    public PsiElement bindToElement(@Nonnull PsiElement element) throws IncorrectOperationException {
        throw new IncorrectOperationException();
    }

    public PsiReference getReference() {
        return this;
    }

    public String getCanonicalText() {
        return getText();
    }

    public PsiElement getElement() {
        return this;
    }

    public TextRange getRangeInElement() {
        return new TextRange(0, getTextLength());
    }

    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        throw new IncorrectOperationException();
    }

    public boolean isReferenceTo(PsiElement element) {
        return element instanceof JFlexStateDefinition && ((JFlexStateDefinition) element).getName().equals(getText());
    }


    public boolean isSoft() {
        return false;
    }

    @Nullable
    public PsiElement resolve() {
        //todo: do the right way
        JFlexPsiFile file = (JFlexPsiFile) this.getContainingFile();
        JFlexStateStatement[] macroses = file.getStateStatements();
        List<JFlexStateDefinition> suspects = new ArrayList<JFlexStateDefinition>();
        for (JFlexStateStatement macros : macroses) {
            suspects.addAll(Arrays.asList(macros.getStateDefinitions()));
        }
        for (JFlexStateDefinition suspect : suspects) {
            if (suspect.getName().equals(getText())) {
                return suspect;
            }
        }
        return null;
    }
}
