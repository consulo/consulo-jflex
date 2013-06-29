package org.intellij.lang.jflex.parser;

import org.intellij.lang.jflex.JFlexElementTypes;
import org.intellij.lang.jflex.lexer.JFlexParsingLexer;
import org.intellij.lang.jflex.psi.impl.*;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageUtil;
import com.intellij.lang.LanguageVersion;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;

/**
 * JFlex parser.
 *
 * @author Alexey Efimov
 */
public class JFlexParserDefinition implements ParserDefinition
{
	@NotNull
	public Lexer createLexer(Project project, @NotNull LanguageVersion languageVersion)
	{
		return new JFlexParsingLexer();
	}

	@NotNull
	public PsiParser createParser(Project project, @NotNull LanguageVersion languageVersion)
	{
		return new JFlexParser();
	}

	@NotNull
	public IFileElementType getFileNodeType()
	{
		return JFlexElementTypes.FILE;
	}

	@NotNull
	public TokenSet getWhitespaceTokens(@NotNull LanguageVersion languageVersion)
	{
		return JFlexElementTypes.WHITE_SPACES;
	}

	@NotNull
	public TokenSet getCommentTokens(LanguageVersion languageVersion)
	{
		return JFlexElementTypes.COMMENTS;
	}

	@NotNull
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
		final Lexer lexer = createLexer(null, Language.UNKNOWN_VERSION);
		return LanguageUtil.canStickTokensTogetherByLexer(left, right, lexer);
	}

	@NotNull
	public TokenSet getStringLiteralElements(LanguageVersion languageVersion)
	{
		return JFlexElementTypes.COMMENTS;
	}

}
