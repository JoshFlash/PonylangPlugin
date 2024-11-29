// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PonyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return program(b, l + 1);
  }

  /* ********************************************************** */
  // (field_declaration | method_declaration | behavior_declaration | constructor)*
  public static boolean actor_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, ACTOR_BODY, "<actor body>");
    while (true) {
      int c = current_position_(b);
      if (!actor_body_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "actor_body", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // field_declaration | method_declaration | behavior_declaration | constructor
  private static boolean actor_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_body_0")) return false;
    boolean r;
    r = field_declaration(b, l + 1);
    if (!r) r = method_declaration(b, l + 1);
    if (!r) r = behavior_declaration(b, l + 1);
    if (!r) r = constructor(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_ACTOR identifier actor_body
  public static boolean actor_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration")) return false;
    if (!nextTokenIs(b, KW_ACTOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_ACTOR, IDENTIFIER);
    r = r && actor_body(b, l + 1);
    exit_section_(b, m, ACTOR_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // "@" identifier
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION, "<annotation>");
    r = consumeToken(b, "@");
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression (COMMA expression)*
  public static boolean argument_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = expression(b, l + 1);
    r = r && argument_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA expression)*
  private static boolean argument_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argument_list_1", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean argument_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier ASSIGNMENT expression
  public static boolean assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ASSIGNMENT);
    r = r && expression(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // KW_BE identifier parameter_list (COLON type)? ARROW block
  public static boolean behavior_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behavior_declaration")) return false;
    if (!nextTokenIs(b, KW_BE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_BE, IDENTIFIER);
    r = r && parameter_list(b, l + 1);
    r = r && behavior_declaration_3(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    exit_section_(b, m, BEHAVIOR_DECLARATION, r);
    return r;
  }

  // (COLON type)?
  private static boolean behavior_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behavior_declaration_3")) return false;
    behavior_declaration_3_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean behavior_declaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behavior_declaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // statement*
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // (field_declaration | method_declaration | constructor)*
  public static boolean class_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, CLASS_BODY, "<class body>");
    while (true) {
      int c = current_position_(b);
      if (!class_body_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_body", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // field_declaration | method_declaration | constructor
  private static boolean class_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_body_0")) return false;
    boolean r;
    r = field_declaration(b, l + 1);
    if (!r) r = method_declaration(b, l + 1);
    if (!r) r = constructor(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_CLASS identifier (KW_IS identifier)? class_body
  public static boolean class_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration")) return false;
    if (!nextTokenIs(b, KW_CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_CLASS, IDENTIFIER);
    r = r && class_declaration_2(b, l + 1);
    r = r && class_body(b, l + 1);
    exit_section_(b, m, CLASS_DECLARATION, r);
    return r;
  }

  // (KW_IS identifier)?
  private static boolean class_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_2")) return false;
    class_declaration_2_0(b, l + 1);
    return true;
  }

  // KW_IS identifier
  private static boolean class_declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IS, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_NEW identifier parameter_list ARROW block
  public static boolean constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor")) return false;
    if (!nextTokenIs(b, KW_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_NEW, IDENTIFIER);
    r = r && parameter_list(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    exit_section_(b, m, CONSTRUCTOR, r);
    return r;
  }

  /* ********************************************************** */
  // actor_declaration | class_declaration | trait_declaration | primitive_declaration
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = actor_declaration(b, l + 1);
    if (!r) r = class_declaration(b, l + 1);
    if (!r) r = trait_declaration(b, l + 1);
    if (!r) r = primitive_declaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primary
  //              | function_call
  //              | method_call
  //              | KW_RECOVER block KW_END
  //              | tuple
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = primary(b, l + 1);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = method_call(b, l + 1);
    if (!r) r = expression_3(b, l + 1);
    if (!r) r = tuple(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_RECOVER block KW_END
  private static boolean expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_RECOVER);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, KW_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  //             | KW_CONSUME expression
  //             | LEFT_PAREN expression RIGHT_PAREN
  public static boolean expression_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    r = expression(b, l + 1);
    if (!r) r = expression_statement_1(b, l + 1);
    if (!r) r = expression_statement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_CONSUME expression
  private static boolean expression_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CONSUME);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_PAREN expression RIGHT_PAREN
  private static boolean expression_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (KW_VAR | KW_LET | KW_EMBED) identifier (COLON type)? (ASSIGNMENT expression)?
  public static boolean field_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DECLARATION, "<field declaration>");
    r = field_declaration_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && field_declaration_2(b, l + 1);
    r = r && field_declaration_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_VAR | KW_LET | KW_EMBED
  private static boolean field_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_declaration_0")) return false;
    boolean r;
    r = consumeToken(b, KW_VAR);
    if (!r) r = consumeToken(b, KW_LET);
    if (!r) r = consumeToken(b, KW_EMBED);
    return r;
  }

  // (COLON type)?
  private static boolean field_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_declaration_2")) return false;
    field_declaration_2_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean field_declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_declaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ASSIGNMENT expression)?
  private static boolean field_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_declaration_3")) return false;
    field_declaration_3_0(b, l + 1);
    return true;
  }

  // ASSIGNMENT expression
  private static boolean field_declaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_declaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_FOR identifier KW_IN expression KW_DO block KW_END
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, KW_FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FOR, IDENTIFIER, KW_IN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, KW_DO);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, KW_END);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // qualified_identifier LEFT_PAREN argument_list? RIGHT_PAREN
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualified_identifier(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && function_call_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  // argument_list?
  private static boolean function_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_2")) return false;
    argument_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_IF expression KW_THEN block (KW_ELSE block)? KW_END
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, KW_THEN);
    r = r && block(b, l + 1);
    r = r && if_statement_4(b, l + 1);
    r = r && consumeToken(b, KW_END);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // (KW_ELSE block)?
  private static boolean if_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4")) return false;
    if_statement_4_0(b, l + 1);
    return true;
  }

  // KW_ELSE block
  private static boolean if_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // number | string | "true" | "false" | "None"
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    if (!r) r = consumeToken(b, "None");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // pattern ARROW block
  public static boolean match_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_CASE, "<match case>");
    r = pattern(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // match_case+
  public static boolean match_cases(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_cases")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_CASES, "<match cases>");
    r = match_case(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!match_case(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_cases", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_MATCH expression KW_WITH match_cases
  public static boolean match_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_statement")) return false;
    if (!nextTokenIs(b, KW_MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_MATCH);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, KW_WITH);
    r = r && match_cases(b, l + 1);
    exit_section_(b, m, MATCH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // primary DOT identifier LEFT_PAREN argument_list? RIGHT_PAREN
  public static boolean method_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_CALL, "<method call>");
    r = primary(b, l + 1);
    r = r && consumeTokens(b, 0, DOT, IDENTIFIER, LEFT_PAREN);
    r = r && method_call_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // argument_list?
  private static boolean method_call_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_4")) return false;
    argument_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (annotation*)? KW_FUN (KW_REF | KW_ISO | KW_VAL)? identifier parameter_list (COLON type)? ARROW block
  public static boolean method_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_DECLARATION, "<method declaration>");
    r = method_declaration_0(b, l + 1);
    r = r && consumeToken(b, KW_FUN);
    r = r && method_declaration_2(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && parameter_list(b, l + 1);
    r = r && method_declaration_5(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (annotation*)?
  private static boolean method_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_declaration_0")) return false;
    method_declaration_0_0(b, l + 1);
    return true;
  }

  // annotation*
  private static boolean method_declaration_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_declaration_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!annotation(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "method_declaration_0_0", c)) break;
    }
    return true;
  }

  // (KW_REF | KW_ISO | KW_VAL)?
  private static boolean method_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_declaration_2")) return false;
    method_declaration_2_0(b, l + 1);
    return true;
  }

  // KW_REF | KW_ISO | KW_VAL
  private static boolean method_declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_declaration_2_0")) return false;
    boolean r;
    r = consumeToken(b, KW_REF);
    if (!r) r = consumeToken(b, KW_ISO);
    if (!r) r = consumeToken(b, KW_VAL);
    return r;
  }

  // (COLON type)?
  private static boolean method_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_declaration_5")) return false;
    method_declaration_5_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean method_declaration_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_declaration_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier COLON type
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN (parameter (COMMA parameter)*)? RIGHT_PAREN
  public static boolean parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && parameter_list_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, PARAMETER_LIST, r);
    return r;
  }

  // (parameter (COMMA parameter)*)?
  private static boolean parameter_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_1")) return false;
    parameter_list_1_0(b, l + 1);
    return true;
  }

  // parameter (COMMA parameter)*
  private static boolean parameter_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && parameter_list_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA parameter)*
  private static boolean parameter_list_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameter_list_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameter_list_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA parameter
  private static boolean parameter_list_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier | "_"
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, "_");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // qualified_identifier | literal | LEFT_PAREN expression RIGHT_PAREN
  public static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY, "<primary>");
    r = qualified_identifier(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = primary_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LEFT_PAREN expression RIGHT_PAREN
  private static boolean primary_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // method_declaration*
  public static boolean primitive_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, PRIMITIVE_BODY, "<primitive body>");
    while (true) {
      int c = current_position_(b);
      if (!method_declaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primitive_body", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // KW_PRIMITIVE identifier primitive_body
  public static boolean primitive_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_declaration")) return false;
    if (!nextTokenIs(b, KW_PRIMITIVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_PRIMITIVE, IDENTIFIER);
    r = r && primitive_body(b, l + 1);
    exit_section_(b, m, PRIMITIVE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // (use_statement | declaration | statement)*
  static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    while (true) {
      int c = current_position_(b);
      if (!program_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program", c)) break;
    }
    return true;
  }

  // use_statement | declaration | statement
  private static boolean program_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_0")) return false;
    boolean r;
    r = use_statement(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifier (DOT identifier)*
  public static boolean qualified_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && qualified_identifier_1(b, l + 1);
    exit_section_(b, m, QUALIFIED_IDENTIFIER, r);
    return r;
  }

  // (DOT identifier)*
  private static boolean qualified_identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_identifier_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!qualified_identifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qualified_identifier_1", c)) break;
    }
    return true;
  }

  // DOT identifier
  private static boolean qualified_identifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualified_identifier_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // field_declaration
  //             | assignment_statement
  //             | expression_statement
  //             | if_statement
  //             | for_statement
  //             | try_statement
  //             | match_statement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = field_declaration(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    if (!r) r = expression_statement(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = try_statement(b, l + 1);
    if (!r) r = match_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // method_declaration*
  public static boolean trait_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, TRAIT_BODY, "<trait body>");
    while (true) {
      int c = current_position_(b);
      if (!method_declaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "trait_body", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // KW_TRAIT identifier trait_body
  public static boolean trait_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_declaration")) return false;
    if (!nextTokenIs(b, KW_TRAIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_TRAIT, IDENTIFIER);
    r = r && trait_body(b, l + 1);
    exit_section_(b, m, TRAIT_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // KW_TRY block (KW_ELSE block)? KW_END
  public static boolean try_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_statement")) return false;
    if (!nextTokenIs(b, KW_TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_TRY);
    r = r && block(b, l + 1);
    r = r && try_statement_2(b, l + 1);
    r = r && consumeToken(b, KW_END);
    exit_section_(b, m, TRY_STATEMENT, r);
    return r;
  }

  // (KW_ELSE block)?
  private static boolean try_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_statement_2")) return false;
    try_statement_2_0(b, l + 1);
    return true;
  }

  // KW_ELSE block
  private static boolean try_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN expression (COMMA expression)* RIGHT_PAREN
  public static boolean tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && expression(b, l + 1);
    r = r && tuple_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, TUPLE, r);
    return r;
  }

  // (COMMA expression)*
  private static boolean tuple_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuple_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_2", c)) break;
    }
    return true;
  }

  // COMMA expression
  private static boolean tuple_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier type_arguments?
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && type_1(b, l + 1);
    exit_section_(b, m, TYPE, r);
    return r;
  }

  // type_arguments?
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    type_arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LEFT_BRACKET type (COMMA type)* RIGHT_BRACKET
  public static boolean type_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_arguments")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && type(b, l + 1);
    r = r && type_arguments_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, TYPE_ARGUMENTS, r);
    return r;
  }

  // (COMMA type)*
  private static boolean type_arguments_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_arguments_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_arguments_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_arguments_2", c)) break;
    }
    return true;
  }

  // COMMA type
  private static boolean type_arguments_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_arguments_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_USE string
  public static boolean use_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_statement")) return false;
    if (!nextTokenIs(b, KW_USE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_USE, STRING);
    exit_section_(b, m, USE_STATEMENT, r);
    return r;
  }

}
