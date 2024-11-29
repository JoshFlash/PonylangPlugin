package com.github.joshflash.ponylangplugin.language.psi

import com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*
import com.intellij.psi.tree.TokenSet

interface PonyTokenSets {
    companion object {
        val KEYWORDS: TokenSet = TokenSet.create(
            KW_ACTOR, KW_CLASS, KW_TRAIT, KW_PRIMITIVE, KW_FUN, KW_BE, KW_NEW,
            KW_LET, KW_VAR, KW_EMBED, KW_IS, KW_TRY, KW_ELSE, KW_END, KW_FOR,
            KW_IN, KW_MATCH, KW_RECOVER, KW_CONSUME, KW_ISO, KW_REF, KW_VAL
        )

        val OPERATORS: TokenSet = TokenSet.create(
            ASSIGNMENT, PLUS, MINUS, MULT, DIV, EQUALS, NOT_EQUALS,
            LESS_THAN, GREATER_THAN, LESS_EQUAL, GREATER_EQUAL
        )

        val DELIMITERS: TokenSet = TokenSet.create(
            LEFT_PAREN, RIGHT_PAREN, LEFT_BRACKET, RIGHT_BRACKET, COMMA, DOT,
            SEMICOLON, COLON
        )
    }
}