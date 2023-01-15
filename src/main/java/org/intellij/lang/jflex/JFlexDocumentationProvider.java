package org.intellij.lang.jflex;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.ast.ASTNode;
import consulo.language.editor.documentation.LanguageDocumentationProvider;
import consulo.language.psi.PsiElement;
import org.intellij.lang.jflex.psi.JFlexMacroDefinition;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 01.04.2008
 * Time: 23:25:17
 */
@ExtensionImpl
public class JFlexDocumentationProvider implements LanguageDocumentationProvider {
    @Override
    @Nullable
    public String generateDoc(PsiElement element, PsiElement originalElement) {
        if (element instanceof JFlexMacroDefinition) {
            ASTNode astNode = element.getNode();
            ASTNode regexp = astNode != null ? astNode.findChildByType(JFlexElementTypes.REGEXP) : null;
            return regexp != null ? regexp.getText() : "No regexp found.";
        }
        return null;
    }

    @Nonnull
    @Override
    public Language getLanguage() {
        return JFlexLanguage.INSTANCE;
    }
}
