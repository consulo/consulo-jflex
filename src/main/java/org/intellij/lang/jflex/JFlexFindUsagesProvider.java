package org.intellij.lang.jflex;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.findUsage.FindUsagesProvider;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiNamedElement;
import org.intellij.lang.jflex.psi.JFlexMacroDefinition;
import org.intellij.lang.jflex.psi.JFlexStateDefinition;

import javax.annotation.Nonnull;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 01.04.2008
 * Time: 23:31:29
 */
@ExtensionImpl
public class JFlexFindUsagesProvider implements FindUsagesProvider {

    public boolean canFindUsagesFor(@Nonnull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nonnull
    public String getDescriptiveName(@Nonnull PsiElement element) {
        String name = ((PsiNamedElement) element).getName();
        return name != null ? name : "";
    }

    @Nonnull
    public String getNodeText(@Nonnull PsiElement element, boolean useFullName) {
        return getDescriptiveName(element);
    }

    @Nonnull
    public String getType(@Nonnull PsiElement element) {
        if (element instanceof JFlexStateDefinition) return "State";
        if (element instanceof JFlexMacroDefinition) return "Macro";
        return "";
    }

    @Nonnull
    @Override
    public Language getLanguage() {
        return JFlexLanguage.INSTANCE;
    }
}
