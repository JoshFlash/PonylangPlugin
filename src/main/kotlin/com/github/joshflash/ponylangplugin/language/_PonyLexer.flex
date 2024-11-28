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

SPACE=[ \t\n\x0B\f\r]+
ID=[a-zA-Z_][a-zA-Z0-9_]*
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
NUMBER=[0-9]+
LINE_COMMENT="//".*
BLOCK_COMMENT="/"\\*.*?\\*"/"

%%
<YYINITIAL> {
  {WHITE_SPACE}         { return WHITE_SPACE; }

  "=>"                  { return DARROW; }
  "<-"                  { return LARROW; }
  "("                   { return LPAREN; }
  ")"                   { return RPAREN; }
  "["                   { return LBRACKET; }
  "]"                   { return RBRACKET; }
  "."                   { return DOT; }
  ","                   { return COMMA; }
  ":"                   { return COLON; }
  ";"                   { return SEMICOLON; }
  "|"                   { return PIPE; }
  "+"                   { return PLUS; }
  "-"                   { return MINUS; }
  "*"                   { return MULTIPLY; }
  "/"                   { return DIVIDE; }
  "%"                   { return MOD; }
  "="                   { return EQ; }
  "=="                  { return EQEQ; }
  "!="                  { return NOTEQ; }
  "<"                   { return LT; }
  ">"                   { return GT; }
  "<="                  { return LTEQ; }
  ">="                  { return GTEQ; }
  "and"                 { return AND; }
  "or"                  { return OR; }
  "not"                 { return NOT; }
  "is"                  { return IS; }
  "as"                  { return AS; }
  "where"               { return WHERE; }

  {SPACE}               { return SPACE; }
  {ID}                  { return ID; }
  {STRING}              { return STRING; }
  {NUMBER}              { return NUMBER; }
  {LINE_COMMENT}        { return LINE_COMMENT; }
  {BLOCK_COMMENT}       { return BLOCK_COMMENT; }

}

[^] { return BAD_CHARACTER; }
