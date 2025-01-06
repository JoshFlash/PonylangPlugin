package com.github.joshflash.ponylangplugin.language.psi

import com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*
import com.intellij.psi.tree.TokenSet

interface PonyTokenSets {
    companion object {
        val KEYWORDS: TokenSet = TokenSet.create(
            ACTOR, ADDRESSOF, AS, BE, BOX, BREAK, CLASS, COMP_ERR, COMP_INT,
            CONSUME, CONTINUE, DIGESTOF, DO, ELSE, ELSEIF, EMBED, END, ERROR,
            FOR, FUN, IF, IFDEF, IFTYPE, IN, INTERFACE, IS, ISNT,
            ISO, LET, MATCH, NEW, OBJECT, PRIMITIVE, RECOVER, REF, REPEAT,
            RETURN, SOURCELOC, STRUCT, TAG, THEN, TRAIT, TRN, TRY,
            TYPEDEF, UNTIL, USE, VAL, VAR, WHERE, WHILE, WITH
        )

        val KW_CONTROL: TokenSet = TokenSet.create(
            IF, THEN, TRY, ELSE, ELSEIF, WHILE, FOR, IN, DO, MATCH,
            IFDEF, IFTYPE, REPEAT, UNTIL, WITH, RECOVER, CONSUME, END,
        )

        val OPERATORS: TokenSet = TokenSet.create(
            ADD, ADD_PARTIAL, ADD_UNSAFE, AMP, AND, DIV, DIV_PARTIAL, DIV_UNSAFE,
            EQ, EQ_UNSAFE, GEQ, GEQ_UNSAFE, GT, GT_UNSAFE, ISA, LEQ, LEQ_UNSAFE,
            LT, LT_UNSAFE, MOD, MOD_PARTIAL, MOD_UNSAFE, MUL, MUL_PARTIAL,
            MUL_UNSAFE, NEQ, NEQ_UNSAFE, NOT, OR, REM, REM_PARTIAL, REM_UNSAFE,
            SHL, SHL_UNSAFE, SHR, SHR_UNSAFE, SUB, SUB_PARTIAL, SUB_UNSAFE, XOR
        )

        val DELIMITERS: TokenSet = TokenSet.create(
            AMP, ARROW, AT, BANG, CARET, CHAIN, COLON, COMMA, DOT, ELIPSIS,
            EQUALS, HASH, LBC, LBK, LP, PIPE, QM, RBC, RBK, RCVR, RP, SEMI,
            TILDE, TYPE_ARROW
        )

        val STRINGS: TokenSet = TokenSet.create(
            STRING, CHAR, DOC_STRING
        )

        val COMMENTS: TokenSet = TokenSet.create(
            LINE_COMMENT, BLOCK_COMMENT
        )

        val NUMBERS: TokenSet = TokenSet.create(
            INT, FLOAT, TRUE, FALSE
        )

        val TYPES: TokenSet = TokenSet.create(
            TYPE_ID,
        )

        val IDENTIFIERS: TokenSet = TokenSet.create(
            ID, THIS
        )

    }
}