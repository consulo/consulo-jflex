/**
 * @author VISTALL
 * @since 15/01/2023
 */
module consulo.jflex {
    requires consulo.ide.api;

    requires consulo.java;
    
    exports consulo.jflex.localize;
    exports consulo.jflex.vfs.backgroundTask;
    exports org.intellij.lang.jflex;
    exports org.intellij.lang.jflex.editor;
    exports org.intellij.lang.jflex.editor.colors;
    exports org.intellij.lang.jflex.fileTypes;
    exports org.intellij.lang.jflex.injection;
    exports org.intellij.lang.jflex.lexer;
    exports org.intellij.lang.jflex.parser;
    exports org.intellij.lang.jflex.psi;
    exports org.intellij.lang.jflex.psi.impl;
    exports org.intellij.lang.jflex.util;
    exports org.intellij.lang.jflex.validation;
}