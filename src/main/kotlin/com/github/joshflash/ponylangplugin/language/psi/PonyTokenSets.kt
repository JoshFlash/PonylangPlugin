package com.github.joshflash.ponylangplugin.language.psi

import com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*
import com.intellij.psi.tree.TokenSet

interface PonyTokenSets {
    companion object {
        val KEYWORDS: TokenSet = TokenSet.create(
            ACTOR, ADDRESSOF, AND, AS, BE, BOX, BREAK, COMP_ERR, COMP_INT,
            CONSUME, CONTINUE, DIGESTOF, DO, ELSE, ELSEIF, EMBED, END,
            FALSE, FLOAT, FOR, FUN, IF, IFDEF, IFTYPE, IN, INTERFACE, IS,
            ISNT, ISO, LET, MATCH, NEW, NOT, OBJECT, OR, PRIMITIVE, RECOVER,
            REF, REPEAT, RETURN, STRUCT, TAG, THEN, THIS, TRAIT, TRN,
            TRUE, TRY, UNTIL, USE, VAL, VAR, WHERE, WHILE, WITH, XOR
        )

        val OPERATORS: TokenSet = TokenSet.create(
            ADD, ADD_PARTIAL, ADD_UNSAFE, AMP, ARROW, BANG, CARET, CHAIN,
            DIV, DIV_PARTIAL, DIV_UNSAFE, EQ, EQ_UNSAFE, GEQ, GEQ_UNSAFE,
            GT, GT_UNSAFE, ISA, ISNT, LEQ, LEQ_UNSAFE, LT, LT_UNSAFE,
            MOD, MOD_PARTIAL, MOD_UNSAFE, MUL, MUL_PARTIAL, MUL_UNSAFE,
            NEQ, NEQ_UNSAFE, NOT, PIPE, REM, REM_PARTIAL, REM_UNSAFE,
            SHL, SHL_UNSAFE, SHR, SHR_UNSAFE, SUB, SUB_PARTIAL, SUB_UNSAFE,
            TYPE_ARROW, XOR
        )

        val DELIMITERS: TokenSet = TokenSet.create(
            AT, COLON, COMMA, DOT, ELIPSIS, HASH, LBC, LBK, LP, QM, RBC,
            RBK, RCVR, RP, SEMI, SPACE, TILDE
        )
    }
}