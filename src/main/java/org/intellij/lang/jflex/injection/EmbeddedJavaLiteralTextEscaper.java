package org.intellij.lang.jflex.injection;

import javax.annotation.Nonnull;

import org.intellij.lang.jflex.psi.JFlexJavaCode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 15.03.2008
 * Time: 21:01:02
 */
public class EmbeddedJavaLiteralTextEscaper extends LiteralTextEscaper<JFlexJavaCode> {

    public EmbeddedJavaLiteralTextEscaper(@Nonnull JFlexJavaCode host) {
        super(host);
    }

    public boolean decode(@Nonnull TextRange textrange, @Nonnull StringBuilder stringbuilder) {
        stringbuilder.append(myHost.getText(), textrange.getStartOffset(), textrange.getEndOffset());
        return true;
    }

    public int getOffsetInHost(int i, @Nonnull TextRange textrange) {
        int j = i + textrange.getStartOffset();
        if (j < textrange.getStartOffset())
            j = textrange.getStartOffset();
        if (j > textrange.getEndOffset())
            j = textrange.getEndOffset();
        return j;
    }

    public boolean isOneLine() {
        return false;
    }

}
