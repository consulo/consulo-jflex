package org.intellij.lang.jflex.fileTypes;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import javax.annotation.Nonnull;

/**
 * JFlex file type factory, tells IDEA about new file type
 *
 * @author Jan Dolecek
 */
public final class JFlexFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@Nonnull FileTypeConsumer consumer) {
        consumer.consume(JFlexFileType.INSTANCE, JFlexFileType.DEFAULT_EXTENSION);
    }
}
