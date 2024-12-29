package org.intellij.lang.jflex.fileTypes;

import consulo.annotation.component.ExtensionImpl;
import consulo.virtualFileSystem.fileType.FileTypeConsumer;
import consulo.virtualFileSystem.fileType.FileTypeFactory;

import jakarta.annotation.Nonnull;

/**
 * JFlex file type factory, tells IDEA about new file type
 *
 * @author Jan Dolecek
 */
@ExtensionImpl
public final class JFlexFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@Nonnull FileTypeConsumer consumer) {
        consumer.consume(JFlexFileType.INSTANCE, JFlexFileType.DEFAULT_EXTENSION);
    }
}
