package org.intellij.lang.jflex.validation;

import com.intellij.java.language.psi.PsiReferenceExpression;
import consulo.language.editor.annotation.AnnotationHolder;
import consulo.language.editor.annotation.Annotator;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiElementVisitor;
import org.intellij.lang.jflex.psi.JFlexMacroReference;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 22.03.2008
 * Time: 17:19:55
 */
public class JFlexAnnotatingVisitor extends PsiElementVisitor implements Annotator {

    public void annotate(PsiElement psiElement, AnnotationHolder holder) {
        psiElement.accept(this);
    }

    public void visitReferenceExpression(PsiReferenceExpression expression) {
    }

    public void visitMacroReference(JFlexMacroReference expression) {

    }
}
