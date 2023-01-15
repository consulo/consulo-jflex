package org.intellij.lang.jflex.psi.impl;

import consulo.language.ast.ASTNode;
import org.intellij.lang.jflex.psi.JFlexSection;

import javax.annotation.Nonnull;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 19.03.2008
 * Time: 22:45:06
 */
public class JFlexSectionImpl extends JFlexElementImpl implements JFlexSection {

    public JFlexSectionImpl(@Nonnull ASTNode node) {
        super(node);
    }

}
