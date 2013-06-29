package org.intellij.lang.jflex.injection;

import org.intellij.lang.jflex.options.JFlexSettings;
import org.intellij.lang.jflex.psi.JFlexElement;
import org.intellij.lang.jflex.psi.JFlexJavaCode;
import org.intellij.lang.jflex.psi.JFlexPsiFile;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.InjectedLanguagePlaces;
import com.intellij.psi.LanguageInjector;
import com.intellij.psi.PsiLanguageInjectionHost;

public class JFlexJavaInjector implements LanguageInjector
{
	public static final String DEFCLASS = "Yylex";
	public static final String DEFTYPE = "int";

	public JFlexJavaInjector()
	{
	}

	public void getLanguagesToInject(@NotNull PsiLanguageInjectionHost tempHost, @NotNull InjectedLanguagePlaces registrar)
	{

		if(tempHost instanceof JFlexJavaCode)
		{
			final JFlexSettings instance = JFlexSettings.getInstance(tempHost.getProject());

			if(!instance.ENABLED_EMBED_JAVA)
			{
				return;
			}

			JFlexJavaCode host = (JFlexJavaCode) tempHost;

			assert host.getContainingFile() instanceof JFlexPsiFile;
			JFlexPsiFile file = (JFlexPsiFile) host.getContainingFile();

			JFlexJavaCode importSection = file.getImports();
			//processing imports and package section
			if(importSection == host)
			{
				registrar.addPlace(JavaLanguage.INSTANCE, new TextRange(0, host.getTextLength()), null, "\npublic class a{}");
				return;
			}

			StringBuilder prefix = new StringBuilder();

			//let's add some imports and package statements from flex file header
			if(importSection != null)
			{
				prefix.append(importSection.getText());
			}

			String classnamestr = DEFCLASS;
			JFlexElement classname = file.getClassname();
			if(classname != null)
			{
				classnamestr = classname.getText();
			}

			String returntypestr = DEFTYPE;
			JFlexElement returntype = file.getReturnType();
			if(returntype != null)
			{
				returntypestr = returntype.getText();
			}

			StringBuilder implementedstr = new StringBuilder();
			JFlexElement[] implemented = file.getImplementedInterfaces();
			//what a lousy piece of code.
			if(implemented.length > 0)
			{
				implementedstr.append(" implements ");
				for(int i = 0; i < implemented.length; i++)
				{
					JFlexElement jFlexElement = implemented[i];
					implementedstr.append(jFlexElement.getText());
					if(i < implemented.length - 1)
					{
						implementedstr.append(",");
					}
				}
			}

			prefix.append("\npublic class ").append(classnamestr).append(implementedstr.toString()).append("{");

			StringBuilder suffix = new StringBuilder();

			if(host.isMatchAction())
			{
				prefix.append("public ").append(returntypestr).append(" yylex(){");
				suffix.append("}}");
			}
			else
			{
				suffix.append("}");
			}

			registrar.addPlace(JavaLanguage.INSTANCE, new TextRange(0, host.getTextLength()), prefix.toString(), suffix.toString());
		}
	}
}