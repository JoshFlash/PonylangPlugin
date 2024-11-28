// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.joshflash.ponylangplugin.language.psi.impl.*;

public interface PonyTypes {

  IElementType ACTOR_DECLARATION = new PonyElementType("ACTOR_DECLARATION");
  IElementType BEHAVIOR = new PonyElementType("BEHAVIOR");
  IElementType BINARY_OP = new PonyElementType("BINARY_OP");
  IElementType BLOCK = new PonyElementType("BLOCK");
  IElementType BOOLEAN_LITERAL = new PonyElementType("BOOLEAN_LITERAL");
  IElementType CALL_ARGS = new PonyElementType("CALL_ARGS");
  IElementType CAPABILITY = new PonyElementType("CAPABILITY");
  IElementType CLASS_DECLARATION = new PonyElementType("CLASS_DECLARATION");
  IElementType CONSTRUCTOR = new PonyElementType("CONSTRUCTOR");
  IElementType CONSUME_EXPR = new PonyElementType("CONSUME_EXPR");
  IElementType DOC_STRING = new PonyElementType("DOC_STRING");
  IElementType DOT_ACCESS = new PonyElementType("DOT_ACCESS");
  IElementType EXPR = new PonyElementType("EXPR");
  IElementType EXPR_SUFFIX = new PonyElementType("EXPR_SUFFIX");
  IElementType EXTERNAL_DECLARATION = new PonyElementType("EXTERNAL_DECLARATION");
  IElementType FIELD = new PonyElementType("FIELD");
  IElementType IF_EXPR = new PonyElementType("IF_EXPR");
  IElementType INTERFACE_DECLARATION = new PonyElementType("INTERFACE_DECLARATION");
  IElementType LITERAL = new PonyElementType("LITERAL");
  IElementType MATCH_CASE = new PonyElementType("MATCH_CASE");
  IElementType MATCH_EXPR = new PonyElementType("MATCH_EXPR");
  IElementType METHOD = new PonyElementType("METHOD");
  IElementType METHOD_MODIFIER = new PonyElementType("METHOD_MODIFIER");
  IElementType PARAM = new PonyElementType("PARAM");
  IElementType PARAM_LIST = new PonyElementType("PARAM_LIST");
  IElementType PATTERN = new PonyElementType("PATTERN");
  IElementType PRIMARY = new PonyElementType("PRIMARY");
  IElementType PRIMARY_TYPE = new PonyElementType("PRIMARY_TYPE");
  IElementType PRIMITIVE_DECLARATION = new PonyElementType("PRIMITIVE_DECLARATION");
  IElementType RECOVER_EXPR = new PonyElementType("RECOVER_EXPR");
  IElementType STRING_LITERAL = new PonyElementType("STRING_LITERAL");
  IElementType TRAIT_DECLARATION = new PonyElementType("TRAIT_DECLARATION");
  IElementType TRY_EXPR = new PonyElementType("TRY_EXPR");
  IElementType TYPE_ARGS = new PonyElementType("TYPE_ARGS");
  IElementType TYPE_EXPR = new PonyElementType("TYPE_EXPR");
  IElementType TYPE_LIST = new PonyElementType("TYPE_LIST");
  IElementType TYPE_PARAM = new PonyElementType("TYPE_PARAM");
  IElementType TYPE_PARAMS = new PonyElementType("TYPE_PARAMS");
  IElementType TYPE_SUFFIX = new PonyElementType("TYPE_SUFFIX");
  IElementType UNARY_OP = new PonyElementType("UNARY_OP");
  IElementType USE_DECLARATION = new PonyElementType("USE_DECLARATION");

  IElementType AND = new PonyTokenType("and");
  IElementType AS = new PonyTokenType("as");
  IElementType BLOCK_COMMENT = new PonyTokenType("block_comment");
  IElementType COLON = new PonyTokenType(":");
  IElementType COMMA = new PonyTokenType(",");
  IElementType DARROW = new PonyTokenType("=>");
  IElementType DIVIDE = new PonyTokenType("/");
  IElementType DOT = new PonyTokenType(".");
  IElementType EQ = new PonyTokenType("=");
  IElementType EQEQ = new PonyTokenType("==");
  IElementType GT = new PonyTokenType(">");
  IElementType GTEQ = new PonyTokenType(">=");
  IElementType ID = new PonyTokenType("id");
  IElementType IS = new PonyTokenType("is");
  IElementType LARROW = new PonyTokenType("<-");
  IElementType LBRACKET = new PonyTokenType("[");
  IElementType LINE_COMMENT = new PonyTokenType("line_comment");
  IElementType LPAREN = new PonyTokenType("(");
  IElementType LT = new PonyTokenType("<");
  IElementType LTEQ = new PonyTokenType("<=");
  IElementType MINUS = new PonyTokenType("-");
  IElementType MOD = new PonyTokenType("%");
  IElementType MULTIPLY = new PonyTokenType("*");
  IElementType NOT = new PonyTokenType("not");
  IElementType NOTEQ = new PonyTokenType("!=");
  IElementType NUMBER = new PonyTokenType("number");
  IElementType OR = new PonyTokenType("or");
  IElementType PIPE = new PonyTokenType("|");
  IElementType PLUS = new PonyTokenType("+");
  IElementType RBRACKET = new PonyTokenType("]");
  IElementType RPAREN = new PonyTokenType(")");
  IElementType SEMICOLON = new PonyTokenType(";");
  IElementType STRING = new PonyTokenType("string");
  IElementType WHERE = new PonyTokenType("where");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ACTOR_DECLARATION) {
        return new PonyActorDeclarationImpl(node);
      }
      else if (type == BEHAVIOR) {
        return new PonyBehaviorImpl(node);
      }
      else if (type == BINARY_OP) {
        return new PonyBinaryOpImpl(node);
      }
      else if (type == BLOCK) {
        return new PonyBlockImpl(node);
      }
      else if (type == BOOLEAN_LITERAL) {
        return new PonyBooleanLiteralImpl(node);
      }
      else if (type == CALL_ARGS) {
        return new PonyCallArgsImpl(node);
      }
      else if (type == CAPABILITY) {
        return new PonyCapabilityImpl(node);
      }
      else if (type == CLASS_DECLARATION) {
        return new PonyClassDeclarationImpl(node);
      }
      else if (type == CONSTRUCTOR) {
        return new PonyConstructorImpl(node);
      }
      else if (type == CONSUME_EXPR) {
        return new PonyConsumeExprImpl(node);
      }
      else if (type == DOC_STRING) {
        return new PonyDocStringImpl(node);
      }
      else if (type == DOT_ACCESS) {
        return new PonyDotAccessImpl(node);
      }
      else if (type == EXPR) {
        return new PonyExprImpl(node);
      }
      else if (type == EXPR_SUFFIX) {
        return new PonyExprSuffixImpl(node);
      }
      else if (type == EXTERNAL_DECLARATION) {
        return new PonyExternalDeclarationImpl(node);
      }
      else if (type == FIELD) {
        return new PonyFieldImpl(node);
      }
      else if (type == IF_EXPR) {
        return new PonyIfExprImpl(node);
      }
      else if (type == INTERFACE_DECLARATION) {
        return new PonyInterfaceDeclarationImpl(node);
      }
      else if (type == LITERAL) {
        return new PonyLiteralImpl(node);
      }
      else if (type == MATCH_CASE) {
        return new PonyMatchCaseImpl(node);
      }
      else if (type == MATCH_EXPR) {
        return new PonyMatchExprImpl(node);
      }
      else if (type == METHOD) {
        return new PonyMethodImpl(node);
      }
      else if (type == METHOD_MODIFIER) {
        return new PonyMethodModifierImpl(node);
      }
      else if (type == PARAM) {
        return new PonyParamImpl(node);
      }
      else if (type == PARAM_LIST) {
        return new PonyParamListImpl(node);
      }
      else if (type == PATTERN) {
        return new PonyPatternImpl(node);
      }
      else if (type == PRIMARY) {
        return new PonyPrimaryImpl(node);
      }
      else if (type == PRIMARY_TYPE) {
        return new PonyPrimaryTypeImpl(node);
      }
      else if (type == PRIMITIVE_DECLARATION) {
        return new PonyPrimitiveDeclarationImpl(node);
      }
      else if (type == RECOVER_EXPR) {
        return new PonyRecoverExprImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new PonyStringLiteralImpl(node);
      }
      else if (type == TRAIT_DECLARATION) {
        return new PonyTraitDeclarationImpl(node);
      }
      else if (type == TRY_EXPR) {
        return new PonyTryExprImpl(node);
      }
      else if (type == TYPE_ARGS) {
        return new PonyTypeArgsImpl(node);
      }
      else if (type == TYPE_EXPR) {
        return new PonyTypeExprImpl(node);
      }
      else if (type == TYPE_LIST) {
        return new PonyTypeListImpl(node);
      }
      else if (type == TYPE_PARAM) {
        return new PonyTypeParamImpl(node);
      }
      else if (type == TYPE_PARAMS) {
        return new PonyTypeParamsImpl(node);
      }
      else if (type == TYPE_SUFFIX) {
        return new PonyTypeSuffixImpl(node);
      }
      else if (type == UNARY_OP) {
        return new PonyUnaryOpImpl(node);
      }
      else if (type == USE_DECLARATION) {
        return new PonyUseDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
