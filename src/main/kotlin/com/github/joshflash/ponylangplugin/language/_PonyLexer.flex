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

FLOAT=([0-9]([0-9]|_)*(\.[0-9]([0-9]|_)*)?([eE][+-]?[0-9]([0-9]|_)*)?)
INT=(0x[0-9a-fA-F]([0-9a-fA-F]|_)*)|(0b[01]([01]|_)*)
TYPE_ID=_?[A-Z][a-zA-Z0-9_]*
ID=(_[a-z]|[a-z])[a-zA-Z0-9_]*'*
TUPLE_ID=_[1-9][0-9]?
DOC_STRING=(\"\"\")([^\"]|\"\"?[^\"])*(\"\"\")?
STRING=(\"(\\[abefnrtuvx0'?\"\\]|[^\"\\])*\")
CHAR=('(\\[abefnrtv0'\\]|[^'\\])')
GENCAP=#(read|send|share|alias|any)
LINE_COMMENT="//".*
BLOCK_COMMENT="/"\*([^*]|\*+[^*/])*(\*+"/")?

%%
<YYINITIAL> {
  {WHITE_SPACE}             { return WHITE_SPACE; }

  "use"                     { return USE; }
  "type"                    { return TYPEDEF; }
  "interface"               { return INTERFACE; }
  "trait"                   { return TRAIT; }
  "primitive"               { return PRIMITIVE; }
  "struct"                  { return STRUCT; }
  "class"                   { return CLASS; }
  "actor"                   { return ACTOR; }
  "object"                  { return OBJECT; }
  "fun"                     { return FUN; }
  "be"                      { return BE; }
  "new"                     { return NEW; }
  "let"                     { return LET; }
  "var"                     { return VAR; }
  "embed"                   { return EMBED; }
  "this"                    { return THIS; }
  "is"                      { return IS; }
  "as"                      { return AS; }
  "isnt"                    { return ISNT; }
  "if"                      { return IF; }
  "elseif"                  { return ELSEIF; }
  "then"                    { return THEN; }
  "try"                     { return TRY; }
  "else"                    { return ELSE; }
  "end"                     { return END; }
  "for"                     { return FOR; }
  "in"                      { return IN; }
  "do"                      { return DO; }
  "where"                   { return WHERE; }
  "while"                   { return WHILE; }
  "with"                    { return WITH; }
  "match"                   { return MATCH; }
  "recover"                 { return RECOVER; }
  "consume"                 { return CONSUME; }
  "ifdef"                   { return IFDEF; }
  "iftype"                  { return IFTYPE; }
  "repeat"                  { return REPEAT; }
  "until"                   { return UNTIL; }
  "iso"                     { return ISO; }
  "ref"                     { return REF; }
  "trn"                     { return TRN; }
  "val"                     { return VAL; }
  "box"                     { return BOX; }
  "tag"                     { return TAG; }
  "return"                  { return RETURN; }
  "break"                   { return BREAK; }
  "continue"                { return CONTINUE; }
  "error"                   { return ERROR; }
  "compile_intrinsic"       { return COMP_INT; }
  "compile_error"           { return COMP_ERR; }
  "__loc"                   { return SOURCELOC; }
  "addressof"               { return ADDRESSOF; }
  "digestof"                { return DIGESTOF; }
  "="                       { return EQUALS; }
  "=>"                      { return ARROW; }
  "->"                      { return TYPE_ARROW; }
  ":"                       { return COLON; }
  ";"                       { return SEMI; }
  ","                       { return COMMA; }
  "."                       { return DOT; }
  "("                       { return LP; }
  ")"                       { return RP; }
  "["                       { return LBK; }
  "]"                       { return RBK; }
  "{"                       { return LBC; }
  "}"                       { return RBC; }
  "@{"                      { return RCVR; }
  "@"                       { return AT; }
  "?"                       { return QM; }
  "^"                       { return CARET; }
  "!"                       { return BANG; }
  ".>"                      { return CHAIN; }
  "~"                       { return TILDE; }
  "|"                       { return PIPE; }
  "&"                       { return AMP; }
  "#"                       { return HASH; }
  "..."                     { return ELIPSIS; }
  "_"                       { return SCORE; }
  "<:"                      { return ISA; }
  "and"                     { return AND; }
  "or"                      { return OR; }
  "not"                     { return NOT; }
  "xor"                     { return XOR; }
  "+"                       { return ADD; }
  "-"                       { return SUB; }
  "*"                       { return MUL; }
  "/"                       { return DIV; }
  "%"                       { return REM; }
  "%%"                      { return MOD; }
  "<<"                      { return SHL; }
  ">>"                      { return SHR; }
  "=="                      { return EQ; }
  "!="                      { return NEQ; }
  "<"                       { return LT; }
  ">"                       { return GT; }
  "<="                      { return LEQ; }
  ">="                      { return GEQ; }
  "+~"                      { return ADD_UNSAFE; }
  "-~"                      { return SUB_UNSAFE; }
  "*~"                      { return MUL_UNSAFE; }
  "/~"                      { return DIV_UNSAFE; }
  "%~"                      { return REM_UNSAFE; }
  "%%~"                     { return MOD_UNSAFE; }
  "<<~"                     { return SHL_UNSAFE; }
  ">>~"                     { return SHR_UNSAFE; }
  "==~"                     { return EQ_UNSAFE; }
  "!=~"                     { return NEQ_UNSAFE; }
  "<~"                      { return LT_UNSAFE; }
  ">~"                      { return GT_UNSAFE; }
  "<=~"                     { return LEQ_UNSAFE; }
  ">=~"                     { return GEQ_UNSAFE; }
  "+?"                      { return ADD_PARTIAL; }
  "-?"                      { return SUB_PARTIAL; }
  "*?"                      { return MUL_PARTIAL; }
  "/?"                      { return DIV_PARTIAL; }
  "%?"                      { return REM_PARTIAL; }
  "%%?"                     { return MOD_PARTIAL; }
  "true"                    { return TRUE; }
  "false"                   { return FALSE; }

  {FLOAT}                   { return FLOAT; }
  {INT}                     { return INT; }
  {TYPE_ID}                 { return TYPE_ID; }
  {ID}                      { return ID; }
  {TUPLE_ID}                { return TUPLE_ID; }
  {DOC_STRING}              { return DOC_STRING; }
  {STRING}                  { return STRING; }
  {CHAR}                    { return CHAR; }
  {GENCAP}                  { return GENCAP; }
  {LINE_COMMENT}            { return LINE_COMMENT; }
  {BLOCK_COMMENT}           { return BLOCK_COMMENT; }

}

[^] { return BAD_CHARACTER; }
