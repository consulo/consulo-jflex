package org.intellij.lang.jflex.psi;

import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiNamedElement;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 20.03.2008
 * Time: 22:42:53
 */
public interface JFlexMacroDefinition extends JFlexElement, PsiNamedElement {

    PsiElement getNameElement();

}
