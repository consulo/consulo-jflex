package org.intellij.lang.jflex;

import javax.annotation.Nonnull;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.intellij.lang.jflex.lexer.JFlexMergingLexer;
import org.intellij.lang.jflex.psi.JFlexMacroDefinition;
import org.intellij.lang.jflex.psi.JFlexStateDefinition;

import javax.annotation.Nullable;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 01.04.2008
 * Time: 23:31:29
 */
public class JFlexFindUsagesProvider implements FindUsagesProvider {

    public boolean canFindUsagesFor(@Nonnull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nonnull
    public String getDescriptiveName(@Nonnull PsiElement element) {
        String name = ((PsiNamedElement) element).getName();
        return name != null ? name : "";
    }

    @Nullable
    public String getHelpId(@Nonnull PsiElement psiElement) {
        return null;
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

    @Nullable
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new JFlexMergingLexer(), JFlexElementTypes.IDENTIFIERS, JFlexElementTypes.COMMENTS, JFlexElementTypes.REGEXP_SCOPE);
    }
}
