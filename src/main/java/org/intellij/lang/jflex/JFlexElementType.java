package org.intellij.lang.jflex;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import javax.annotation.Nonnull;

import java.text.MessageFormat;

public class JFlexElementType extends IElementType {
    private final IElementType parsedType;

    public JFlexElementType(@Nonnull @NonNls String debugName, IElementType parsedType) {
        super(debugName, JFlexLanguage.INSTANCE);
        this.parsedType = parsedType;
    }

    public JFlexElementType(@Nonnull @NonNls String debugName) {
        this(debugName, null);
    }

    public IElementType getParsedType() {
        return parsedType != null ? parsedType : this;
    }

    @SuppressWarnings({"HardCodedStringLiteral"})
    public String toString() {
        return MessageFormat.format("JFlex:{0}", super.toString());
    }
}
