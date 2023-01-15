package org.intellij.lang.jflex.parser;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.ast.ASTNode;
import consulo.language.ast.IElementType;
import consulo.language.ast.IFileElementType;
import consulo.language.ast.TokenSet;
import consulo.language.file.FileViewProvider;
import consulo.language.lexer.Lexer;
import consulo.language.parser.ParserDefinition;
import consulo.language.parser.PsiParser;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiFile;
import consulo.language.util.LanguageUtil;
import consulo.language.version.LanguageVersion;
import consulo.language.version.LanguageVersionUtil;
import org.intellij.lang.jflex.JFlexElementTypes;
import org.intellij.lang.jflex.JFlexLanguage;
import org.intellij.lang.jflex.lexer.JFlexParsingLexer;
import org.intellij.lang.jflex.psi.impl.*;

import javax.annotation.Nonnull;

/**
 * JFlex parser.
 *
 * @author Alexey Efimov
 */
@ExtensionImpl
public class JFlexParserDefinition implements ParserDefinition {
    @Nonnull
    @Override
    public Language getLanguage() {
        return JFlexLanguage.INSTANCE;
    }

    @Nonnull
    public Lexer createLexer(@Nonnull LanguageVersion languageVersion) {
        return new JFlexParsingLexer();
    }

    @Nonnull
    public PsiParser createParser(@Nonnull LanguageVersion languageVersion) {
        return new JFlexParser();
    }

    @Nonnull
    public IFileElementType getFileNodeType() {
        return JFlexElementTypes.FILE;
    }

    @Nonnull
    public TokenSet getWhitespaceTokens(@Nonnull LanguageVersion languageVersion) {
        return JFlexElementTypes.WHITE_SPACES;
    }

    @Nonnull
    public TokenSet getCommentTokens(LanguageVersion languageVersion) {
        return JFlexElementTypes.COMMENTS;
    }

    @Nonnull
    public PsiElement createElement(ASTNode node) {
        IElementType type = node.getElementType();
        if (type == JFlexElementTypes.CLASS_STATEMENT) {
            return new JFlexClassStatementImpl(node);
        }
        else if (type == JFlexElementTypes.STATE_STATEMENT) {
            return new JFlexStateStatementImpl(node);
        }
        else if (type == JFlexElementTypes.STATE_DEFINITION) {
            return new JFlexStateDefinitionImpl(node);
        }
        else if (type == JFlexElementTypes.STATE_REF) {
            return new JFlexStateReferenceImpl(node);
        }
        else if (type == JFlexElementTypes.MACRO_DEFINITION) {
            return new JFlexMacroDefinitionImpl(node);
        }
        else if (type == JFlexElementTypes.IMPLEMENTS_STATEMENT) {
            return new JFlexImplementsStatementImpl(node);
        }
        else if (type == JFlexElementTypes.TYPE_STATEMENT) {
            return new JFlexTypeStatementImpl(node);
        }
        else if (type == JFlexElementTypes.JAVA_CODE) {
            return new JFlexJavaCodeImpl(node);
        }
        else if (type == JFlexElementTypes.REGEXP_MACROS_REF) {
            return new JFlexMacroReferenceImpl(node);
        }
        else if (type == JFlexElementTypes.SECTION) {
            return new JFlexSectionImpl(node);
        }
        else if (type == JFlexElementTypes.REGEXP) {
            return new JFlexRegexpImpl(node);
        }
        return new JFlexExpressionImpl(node);
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new JFlexPsiFileImpl(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        final Lexer lexer = createLexer(LanguageVersionUtil.findDefaultVersion(JFlexLanguage.INSTANCE));
        return LanguageUtil.canStickTokensTogetherByLexer(left, right, lexer);
    }

    @Nonnull
    public TokenSet getStringLiteralElements(LanguageVersion languageVersion) {
        return JFlexElementTypes.COMMENTS;
    }

}
