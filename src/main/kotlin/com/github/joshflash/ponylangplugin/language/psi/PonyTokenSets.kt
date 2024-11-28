package com.github.joshflash.ponylangplugin.language.psi

import com.intellij.psi.tree.TokenSet

interface PonyTokenSets {
    companion object {
        val IDENTIFIERS = TokenSet.create(PonyTypes.ID)
        val COMMENTS = TokenSet.create(PonyTypes.LINE_COMMENT, PonyTypes.BLOCK_COMMENT)
        val LITERALS = TokenSet.create(
            PonyTypes.STRING,
            PonyTypes.NUMBER,
            PonyTypes.BOOLEAN_LITERAL,
            PonyTypes.STRING_LITERAL
        )
        val DECLARATIONS = TokenSet.create(
            PonyTypes.CLASS_DECLARATION,
            PonyTypes.ACTOR_DECLARATION,
            PonyTypes.PRIMITIVE_DECLARATION,
            PonyTypes.TRAIT_DECLARATION,
            PonyTypes.INTERFACE_DECLARATION,
            PonyTypes.USE_DECLARATION,
            PonyTypes.EXTERNAL_DECLARATION
        )
        val EXPRESSIONS = TokenSet.create(
            PonyTypes.EXPR,
            PonyTypes.IF_EXPR,
            PonyTypes.MATCH_EXPR,
            PonyTypes.TRY_EXPR,
            PonyTypes.RECOVER_EXPR,
            PonyTypes.CONSUME_EXPR
        )
    }
}