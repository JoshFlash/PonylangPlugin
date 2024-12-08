package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyTokenSets
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.psi.tree.IElementType

class PonySyntaxHighlighter : SyntaxHighlighter {

    companion object {
        val KEYWORD: TextAttributesKey =
            createTextAttributesKey("PONY_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val STRING: TextAttributesKey =
            createTextAttributesKey("PONY_STRING", DefaultLanguageHighlighterColors.STRING)
        val COMMENT: TextAttributesKey =
            createTextAttributesKey("PONY_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val NUMBER: TextAttributesKey =
            createTextAttributesKey("PONY_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val IDENTIFIER: TextAttributesKey =
            createTextAttributesKey("PONY_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val OPERATOR: TextAttributesKey =
            createTextAttributesKey("PONY_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val DELIMITER: TextAttributesKey =
            createTextAttributesKey("PONY_DELIMITER", DefaultLanguageHighlighterColors.BRACKETS)
        val TYPE: TextAttributesKey =
            createTextAttributesKey("PONY_TYPE", DefaultLanguageHighlighterColors.CLASS_NAME)

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val STRING_KEYS = arrayOf(STRING)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val DELIMITER_KEYS = arrayOf(DELIMITER)
        private val TYPE_KEYS = arrayOf(TYPE)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }

    override fun getHighlightingLexer(): Lexer = PonyLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> = when {
        PonyTokenSets.KEYWORDS.contains(tokenType) -> KEYWORD_KEYS
        PonyTokenSets.STRINGS.contains(tokenType) -> STRING_KEYS
        PonyTokenSets.COMMENTS.contains(tokenType) -> COMMENT_KEYS
        PonyTokenSets.NUMBERS.contains(tokenType) -> NUMBER_KEYS
        PonyTokenSets.OPERATORS.contains(tokenType) -> OPERATOR_KEYS
        PonyTokenSets.DELIMITERS.contains(tokenType) -> DELIMITER_KEYS
        PonyTokenSets.TYPES.contains(tokenType) -> TYPE_KEYS
        PonyTokenSets.IDENTIFIERS.contains(tokenType) -> IDENTIFIER_KEYS
        else -> EMPTY_KEYS
    }
}

