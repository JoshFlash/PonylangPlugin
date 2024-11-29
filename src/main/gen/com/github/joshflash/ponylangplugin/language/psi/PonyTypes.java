// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.joshflash.ponylangplugin.language.psi.impl.*;

public interface PonyTypes {

  IElementType ACTOR_BODY = new PonyElementType("ACTOR_BODY");
  IElementType ACTOR_DECLARATION = new PonyElementType("ACTOR_DECLARATION");
  IElementType ANNOTATION = new PonyElementType("ANNOTATION");
  IElementType ARGUMENT_LIST = new PonyElementType("ARGUMENT_LIST");
  IElementType ASSIGNMENT_STATEMENT = new PonyElementType("ASSIGNMENT_STATEMENT");
  IElementType BEHAVIOR_DECLARATION = new PonyElementType("BEHAVIOR_DECLARATION");
  IElementType BLOCK = new PonyElementType("BLOCK");
  IElementType CLASS_BODY = new PonyElementType("CLASS_BODY");
  IElementType CLASS_DECLARATION = new PonyElementType("CLASS_DECLARATION");
  IElementType CONSTRUCTOR = new PonyElementType("CONSTRUCTOR");
  IElementType DECLARATION = new PonyElementType("DECLARATION");
  IElementType EXPRESSION = new PonyElementType("EXPRESSION");
  IElementType EXPRESSION_STATEMENT = new PonyElementType("EXPRESSION_STATEMENT");
  IElementType FIELD_DECLARATION = new PonyElementType("FIELD_DECLARATION");
  IElementType FOR_STATEMENT = new PonyElementType("FOR_STATEMENT");
  IElementType FUNCTION_CALL = new PonyElementType("FUNCTION_CALL");
  IElementType IF_STATEMENT = new PonyElementType("IF_STATEMENT");
  IElementType LITERAL = new PonyElementType("LITERAL");
  IElementType MATCH_CASE = new PonyElementType("MATCH_CASE");
  IElementType MATCH_CASES = new PonyElementType("MATCH_CASES");
  IElementType MATCH_STATEMENT = new PonyElementType("MATCH_STATEMENT");
  IElementType METHOD_CALL = new PonyElementType("METHOD_CALL");
  IElementType METHOD_DECLARATION = new PonyElementType("METHOD_DECLARATION");
  IElementType PARAMETER = new PonyElementType("PARAMETER");
  IElementType PARAMETER_LIST = new PonyElementType("PARAMETER_LIST");
  IElementType PATTERN = new PonyElementType("PATTERN");
  IElementType PRIMARY = new PonyElementType("PRIMARY");
  IElementType PRIMITIVE_BODY = new PonyElementType("PRIMITIVE_BODY");
  IElementType PRIMITIVE_DECLARATION = new PonyElementType("PRIMITIVE_DECLARATION");
  IElementType QUALIFIED_IDENTIFIER = new PonyElementType("QUALIFIED_IDENTIFIER");
  IElementType STATEMENT = new PonyElementType("STATEMENT");
  IElementType TRAIT_BODY = new PonyElementType("TRAIT_BODY");
  IElementType TRAIT_DECLARATION = new PonyElementType("TRAIT_DECLARATION");
  IElementType TRY_STATEMENT = new PonyElementType("TRY_STATEMENT");
  IElementType TUPLE = new PonyElementType("TUPLE");
  IElementType TYPE = new PonyElementType("TYPE");
  IElementType TYPE_ARGUMENTS = new PonyElementType("TYPE_ARGUMENTS");
  IElementType USE_STATEMENT = new PonyElementType("USE_STATEMENT");

  IElementType ARROW = new PonyTokenType("=>");
  IElementType ASSIGNMENT = new PonyTokenType("=");
  IElementType BLOCK_COMMENT = new PonyTokenType("block_comment");
  IElementType COLON = new PonyTokenType(":");
  IElementType COMMA = new PonyTokenType(",");
  IElementType DIV = new PonyTokenType("/");
  IElementType DOT = new PonyTokenType(".");
  IElementType EQUALS = new PonyTokenType("==");
  IElementType FAT_ARROW = new PonyTokenType("<-");
  IElementType GREATER_EQUAL = new PonyTokenType(">=");
  IElementType GREATER_THAN = new PonyTokenType(">");
  IElementType IDENTIFIER = new PonyTokenType("identifier");
  IElementType KW_ACTOR = new PonyTokenType("actor");
  IElementType KW_BE = new PonyTokenType("be");
  IElementType KW_CLASS = new PonyTokenType("class");
  IElementType KW_CONSUME = new PonyTokenType("consume");
  IElementType KW_DO = new PonyTokenType("do");
  IElementType KW_ELSE = new PonyTokenType("else");
  IElementType KW_EMBED = new PonyTokenType("embed");
  IElementType KW_END = new PonyTokenType("end");
  IElementType KW_FOR = new PonyTokenType("for");
  IElementType KW_FUN = new PonyTokenType("fun");
  IElementType KW_IF = new PonyTokenType("if");
  IElementType KW_IN = new PonyTokenType("in");
  IElementType KW_IS = new PonyTokenType("is");
  IElementType KW_ISO = new PonyTokenType("iso");
  IElementType KW_LET = new PonyTokenType("let");
  IElementType KW_MATCH = new PonyTokenType("match");
  IElementType KW_NEW = new PonyTokenType("new");
  IElementType KW_PRIMITIVE = new PonyTokenType("primitive");
  IElementType KW_RECOVER = new PonyTokenType("recover");
  IElementType KW_REF = new PonyTokenType("ref");
  IElementType KW_THEN = new PonyTokenType("KW_THEN");
  IElementType KW_TRAIT = new PonyTokenType("trait");
  IElementType KW_TRY = new PonyTokenType("try");
  IElementType KW_USE = new PonyTokenType("use");
  IElementType KW_VAL = new PonyTokenType("val");
  IElementType KW_VAR = new PonyTokenType("var");
  IElementType KW_WITH = new PonyTokenType("with");
  IElementType LEFT_BRACKET = new PonyTokenType("[");
  IElementType LEFT_PAREN = new PonyTokenType("(");
  IElementType LESS_EQUAL = new PonyTokenType("<=");
  IElementType LESS_THAN = new PonyTokenType("<");
  IElementType LINE_COMMENT = new PonyTokenType("line_comment");
  IElementType MINUS = new PonyTokenType("-");
  IElementType MULT = new PonyTokenType("*");
  IElementType NOT_EQUALS = new PonyTokenType("!=");
  IElementType NUMBER = new PonyTokenType("number");
  IElementType PLUS = new PonyTokenType("+");
  IElementType RIGHT_BRACKET = new PonyTokenType("]");
  IElementType RIGHT_PAREN = new PonyTokenType(")");
  IElementType SEMICOLON = new PonyTokenType(";");
  IElementType SPACE = new PonyTokenType("space");
  IElementType STRING = new PonyTokenType("string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ACTOR_BODY) {
        return new PonyActorBodyImpl(node);
      }
      else if (type == ACTOR_DECLARATION) {
        return new PonyActorDeclarationImpl(node);
      }
      else if (type == ANNOTATION) {
        return new PonyAnnotationImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new PonyArgumentListImpl(node);
      }
      else if (type == ASSIGNMENT_STATEMENT) {
        return new PonyAssignmentStatementImpl(node);
      }
      else if (type == BEHAVIOR_DECLARATION) {
        return new PonyBehaviorDeclarationImpl(node);
      }
      else if (type == BLOCK) {
        return new PonyBlockImpl(node);
      }
      else if (type == CLASS_BODY) {
        return new PonyClassBodyImpl(node);
      }
      else if (type == CLASS_DECLARATION) {
        return new PonyClassDeclarationImpl(node);
      }
      else if (type == CONSTRUCTOR) {
        return new PonyConstructorImpl(node);
      }
      else if (type == DECLARATION) {
        return new PonyDeclarationImpl(node);
      }
      else if (type == EXPRESSION) {
        return new PonyExpressionImpl(node);
      }
      else if (type == EXPRESSION_STATEMENT) {
        return new PonyExpressionStatementImpl(node);
      }
      else if (type == FIELD_DECLARATION) {
        return new PonyFieldDeclarationImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new PonyForStatementImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new PonyFunctionCallImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new PonyIfStatementImpl(node);
      }
      else if (type == LITERAL) {
        return new PonyLiteralImpl(node);
      }
      else if (type == MATCH_CASE) {
        return new PonyMatchCaseImpl(node);
      }
      else if (type == MATCH_CASES) {
        return new PonyMatchCasesImpl(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new PonyMatchStatementImpl(node);
      }
      else if (type == METHOD_CALL) {
        return new PonyMethodCallImpl(node);
      }
      else if (type == METHOD_DECLARATION) {
        return new PonyMethodDeclarationImpl(node);
      }
      else if (type == PARAMETER) {
        return new PonyParameterImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new PonyParameterListImpl(node);
      }
      else if (type == PATTERN) {
        return new PonyPatternImpl(node);
      }
      else if (type == PRIMARY) {
        return new PonyPrimaryImpl(node);
      }
      else if (type == PRIMITIVE_BODY) {
        return new PonyPrimitiveBodyImpl(node);
      }
      else if (type == PRIMITIVE_DECLARATION) {
        return new PonyPrimitiveDeclarationImpl(node);
      }
      else if (type == QUALIFIED_IDENTIFIER) {
        return new PonyQualifiedIdentifierImpl(node);
      }
      else if (type == STATEMENT) {
        return new PonyStatementImpl(node);
      }
      else if (type == TRAIT_BODY) {
        return new PonyTraitBodyImpl(node);
      }
      else if (type == TRAIT_DECLARATION) {
        return new PonyTraitDeclarationImpl(node);
      }
      else if (type == TRY_STATEMENT) {
        return new PonyTryStatementImpl(node);
      }
      else if (type == TUPLE) {
        return new PonyTupleImpl(node);
      }
      else if (type == TYPE) {
        return new PonyTypeImpl(node);
      }
      else if (type == TYPE_ARGUMENTS) {
        return new PonyTypeArgumentsImpl(node);
      }
      else if (type == USE_STATEMENT) {
        return new PonyUseStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
