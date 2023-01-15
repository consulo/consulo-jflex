package org.intellij.lang.jflex;

import consulo.language.ast.IElementType;
import org.jetbrains.annotations.NonNls;

import javax.annotation.Nonnull;

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
}
