package org.intellij.lang.jflex.parser;

import javax.annotation.Nonnull;

import org.intellij.lang.jflex.JFlexElementTypes;
import org.intellij.lang.jflex.JFlexLanguage;
import org.intellij.lang.jflex.lexer.JFlexParsingLexer;
import org.intellij.lang.jflex.psi.impl.*;
import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageUtil;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import consulo.lang.LanguageVersion;
import consulo.lang.util.LanguageVersionUtil;

/**
 * JFlex parser.
 *
 * @author Alexey Efimov
 */
public class JFlexParserDefinition implements ParserDefinition
{
	@Nonnull
	public Lexer createLexer(@Nonnull LanguageVersion languageVersion)
	{
		return new JFlexParsingLexer();
	}

	@Nonnull
	public PsiParser createParser(@Nonnull LanguageVersion languageVersion)
	{
		return new JFlexParser();
	}

	@Nonnull
	public IFileElementType getFileNodeType()
	{
		return JFlexElementTypes.FILE;
	}

	@Nonnull
	public TokenSet getWhitespaceTokens(@Nonnull LanguageVersion languageVersion)
	{
		return JFlexElementTypes.WHITE_SPACES;
	}

	@Nonnull
	public TokenSet getCommentTokens(LanguageVersion languageVersion)
	{
		return JFlexElementTypes.COMMENTS;
	}

	@Nonnull
	public PsiElement createElement(ASTNode node)
	{
		IElementType type = node.getElementType();
		if(type == JFlexElementTypes.CLASS_STATEMENT)
		{
			return new JFlexClassStatementImpl(node);
		}
		else if(type == JFlexElementTypes.STATE_STATEMENT)
		{
			return new JFlexStateStatementImpl(node);
		}
		else if(type == JFlexElementTypes.STATE_DEFINITION)
		{
			return new JFlexStateDefinitionImpl(node);
		}
		else if(type == JFlexElementTypes.STATE_REF)
		{
			return new JFlexStateReferenceImpl(node);
		}
		else if(type == JFlexElementTypes.MACRO_DEFINITION)
		{
			return new JFlexMacroDefinitionImpl(node);
		}
		else if(type == JFlexElementTypes.IMPLEMENTS_STATEMENT)
		{
			return new JFlexImplementsStatementImpl(node);
		}
		else if(type == JFlexElementTypes.TYPE_STATEMENT)
		{
			return new JFlexTypeStatementImpl(node);
		}
		else if(type == JFlexElementTypes.JAVA_CODE)
		{
			return new JFlexJavaCodeImpl(node);
		}
		else if(type == JFlexElementTypes.REGEXP_MACROS_REF)
		{
			return new JFlexMacroReferenceImpl(node);
		}
		else if(type == JFlexElementTypes.SECTION)
		{
			return new JFlexSectionImpl(node);
		}
		else if(type == JFlexElementTypes.REGEXP)
		{
			return new JFlexRegexpImpl(node);
		}
		return new JFlexExpressionImpl(node);
	}

	public PsiFile createFile(FileViewProvider viewProvider)
	{
		return new JFlexPsiFileImpl(viewProvider);
	}

	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right)
	{
		final Lexer lexer = createLexer(LanguageVersionUtil.findDefaultVersion(JFlexLanguage.INSTANCE));
		return LanguageUtil.canStickTokensTogetherByLexer(left, right, lexer);
	}

	@Nonnull
	public TokenSet getStringLiteralElements(LanguageVersion languageVersion)
	{
		return JFlexElementTypes.COMMENTS;
	}

}
