package com.github.joshflash.ponylangplugin.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*;

%%

%{
  public _PonyLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _PonyLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=\[ \t\n\x0B\f\r]+
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
NUMBER=[0-9]+
STRING=('([^'\\]|\\\\.)*'|\"([^\"\\]|\\\\.)*\")
LINE_COMMENT="//".*
BLOCK_COMMENT="/"\\*([^*]|\\*+[^*/])*\\*"/"

%%
<YYINITIAL> {
  {WHITE_SPACE}         { return WHITE_SPACE; }

  "="                   { return ASSIGNMENT; }
  "=>"                  { return ARROW; }
  "<-"                  { return FAT_ARROW; }
  ":"                   { return COLON; }
  ";"                   { return SEMICOLON; }
  ","                   { return COMMA; }
  "."                   { return DOT; }
  "+"                   { return PLUS; }
  "-"                   { return MINUS; }
  "*"                   { return MULT; }
  "/"                   { return DIV; }
  "=="                  { return EQUALS; }
  "!="                  { return NOT_EQUALS; }
  "<"                   { return LESS_THAN; }
  ">"                   { return GREATER_THAN; }
  "<="                  { return LESS_EQUAL; }
  ">="                  { return GREATER_EQUAL; }
  "("                   { return LEFT_PAREN; }
  ")"                   { return RIGHT_PAREN; }
  "["                   { return LEFT_BRACKET; }
  "]"                   { return RIGHT_BRACKET; }
  "use"                 { return KW_USE; }
  "actor"               { return KW_ACTOR; }
  "class"               { return KW_CLASS; }
  "trait"               { return KW_TRAIT; }
  "primitive"           { return KW_PRIMITIVE; }
  "fun"                 { return KW_FUN; }
  "be"                  { return KW_BE; }
  "new"                 { return KW_NEW; }
  "let"                 { return KW_LET; }
  "var"                 { return KW_VAR; }
  "embed"               { return KW_EMBED; }
  "is"                  { return KW_IS; }
  "if"                  { return KW_IF; }
  "try"                 { return KW_TRY; }
  "else"                { return KW_ELSE; }
  "end"                 { return KW_END; }
  "for"                 { return KW_FOR; }
  "in"                  { return KW_IN; }
  "do"                  { return KW_DO; }
  "with"                { return KW_WITH; }
  "match"               { return KW_MATCH; }
  "recover"             { return KW_RECOVER; }
  "consume"             { return KW_CONSUME; }
  "iso"                 { return KW_ISO; }
  "ref"                 { return KW_REF; }
  "val"                 { return KW_VAL; }
  "KW_THEN"             { return KW_THEN; }

  {SPACE}               { return SPACE; }
  {IDENTIFIER}          { return IDENTIFIER; }
  {NUMBER}              { return NUMBER; }
  {STRING}              { return STRING; }
  {LINE_COMMENT}        { return LINE_COMMENT; }
  {BLOCK_COMMENT}       { return BLOCK_COMMENT; }

}

[^] { return BAD_CHARACTER; }
