package org.intellij.lang.jflex;

import java.util.List;

import org.intellij.lang.jflex.psi.JFlexMacroDefinition;
import javax.annotation.Nullable;
import com.intellij.lang.ASTNode;
import com.intellij.lang.documentation.DocumentationProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;

/**
 * Created by IntelliJ IDEA.
 * User: Max
 * Date: 01.04.2008
 * Time: 23:25:17
 */
public class JFlexDocumentationProvider implements DocumentationProvider
{
	@Nullable
	public String getQuickNavigateInfo(PsiElement element)
	{
		return null;
	}

	@Override
	@Nullable
	public List<String> getUrlFor(PsiElement element, PsiElement originalElement)
	{
		return null;
	}

	@Override
	@Nullable
	public String generateDoc(PsiElement element, PsiElement originalElement)
	{
		if(element instanceof JFlexMacroDefinition)
		{
			ASTNode astNode = element.getNode();
			ASTNode regexp = astNode != null ? astNode.findChildByType(JFlexElementTypes.REGEXP) : null;
			return regexp != null ? regexp.getText() : "No regexp found.";
		}
		return null;
	}

	@Override
	@Nullable
	public PsiElement getDocumentationElementForLookupItem(PsiManager psiManager, Object object, PsiElement element)
	{
		return null;
	}

	@Override
	@Nullable
	public PsiElement getDocumentationElementForLink(PsiManager psiManager, String link, PsiElement context)
	{
		return null;
	}

	@Override
	@Nullable
	public String getQuickNavigateInfo(PsiElement element, PsiElement originalElement)
	{
		return null;
	}
}
