/**
 * @author VISTALL
 * @since 15/01/2023
 */
module consulo.jflex {
    requires consulo.application.api;
    requires consulo.application.content.api;
    requires consulo.code.editor.api;
    requires consulo.color.scheme.api;
    requires consulo.component.api;
    requires consulo.document.api;
    requires consulo.language.api;
    requires consulo.language.impl;
    requires consulo.language.editor.api;
    requires consulo.localize.api;
    requires consulo.logging.api;
    requires consulo.module.api;
    requires consulo.process.api;
    requires consulo.project.api;
    requires consulo.ui.api;
    requires consulo.virtual.file.system.api;
    requires consulo.virtual.file.watcher.api;
    requires consulo.util.collection;
    requires consulo.util.lang;

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