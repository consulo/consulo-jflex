package org.intellij.lang.jflex.editor;

import java.awt.Color;
import java.awt.Font;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;

/**
 * JFlex highlighter colors.
 *
 * @author Alexey Efimov
 */
public interface JFlexHighlighterColors
{
	TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("JFLEX.COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
	TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("JFLEX.STRING", DefaultLanguageHighlighterColors.STRING);
	TextAttributesKey COMMA = TextAttributesKey.createTextAttributesKey("JFLEX_COMMA", DefaultLanguageHighlighterColors.COMMA);
	TextAttributesKey OPERATION_SIGN = TextAttributesKey.createTextAttributesKey("JFLEX_OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);
	TextAttributesKey BRACES = TextAttributesKey.createTextAttributesKey("JFLEX_BRACES", DefaultLanguageHighlighterColors.BRACES);
	TextAttributesKey BRACKETS = TextAttributesKey.createTextAttributesKey("JFLEX_BRACES", DefaultLanguageHighlighterColors.BRACKETS);
	TextAttributesKey ANGLE_BRACKETS = TextAttributesKey.createTextAttributesKey("JFLEX_ANGLE_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
	TextAttributesKey PARENTHS = TextAttributesKey.createTextAttributesKey("JFLEX_PARENTHS", DefaultLanguageHighlighterColors.PARENTHESES);
	TextAttributesKey SECTION_SIGN = TextAttributesKey.createTextAttributesKey("JFLEX.SECTION_SIGN", new TextAttributes(new Color(0, 0x80, 0), new Color(0xed, 0xff, 0xed), null, null, Font.BOLD));
	TextAttributesKey OPTION_KEYWORD = TextAttributesKey.createTextAttributesKey("JFLEX.OPTION_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
	TextAttributesKey OPTION_SIGN = TextAttributesKey.createTextAttributesKey("JFLEX.OPTION_SIGN", new TextAttributes(new Color(0, 0, 0x80), null, null, null, 0));
	TextAttributesKey OPTION_PARAMETER = TextAttributesKey.createTextAttributesKey("JFLEX.OPTION_PARAMETER", new TextAttributes(new Color(0, 0, 0x80), null, null, null, 0));
	TextAttributesKey OPTION_BACKGROUND = TextAttributesKey.createTextAttributesKey("JFLEX_OPTION_BACKGROUND", new TextAttributes(null, new Color(0xed, 0xff, 0xed), null, null, 0));
	TextAttributesKey JAVA_CODE = TextAttributesKey.createTextAttributesKey("JFLEX.JAVA_CODE", new TextAttributes(null, new Color(0xff, 0xfc, 0xe4), null, null, 0));
	TextAttributesKey REGEXP_BACKGROUND = TextAttributesKey.createTextAttributesKey("JFLEX_REGEXP_BACKGROUND", new TextAttributes(null, new Color(0xef, 0xef, 0xef), null, null, 0));
	TextAttributesKey REGEXP_SYMBOL = TextAttributesKey.createTextAttributesKey("JFLEX_REGEXP_SYMBOL", new TextAttributes(Color.BLUE, null, null, null, 0));
	TextAttributesKey REGEXP_CLASS_SYMBOL = TextAttributesKey.createTextAttributesKey("JFLEX_REGEXP_CLASS_SYMBOL", new TextAttributes(Color.BLUE, null, null, null, Font.BOLD));
	TextAttributesKey MACROS = TextAttributesKey.createTextAttributesKey("JFLEX_MACROS", new TextAttributes(new Color(0, 0, 0x80), null, null, null, Font.BOLD));
	TextAttributesKey MACROS_REF = TextAttributesKey.createTextAttributesKey("JFLEX_MACROS_REF", new TextAttributes(new Color(0, 0, 0x80), null, null, null, 0));
	TextAttributesKey STATE_REF = TextAttributesKey.createTextAttributesKey("JFLEX_STATE_REF", new TextAttributes(new Color(0x66, 0x0e, 0x7a), null, null, null, Font.BOLD));

	TextAttributesKey BAD_CHARACTER = HighlighterColors.BAD_CHARACTER;
}
