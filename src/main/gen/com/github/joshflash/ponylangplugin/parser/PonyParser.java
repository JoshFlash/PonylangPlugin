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
  // doc_string? 'actor' id type_params? ('is' type_list)? field* constructor* behavior* method*
  public static boolean actor_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ACTOR_DECLARATION, "<actor declaration>");
    r = actor_declaration_0(b, l + 1);
    r = r && consumeToken(b, "actor");
    r = r && consumeToken(b, ID);
    r = r && actor_declaration_3(b, l + 1);
    r = r && actor_declaration_4(b, l + 1);
    r = r && actor_declaration_5(b, l + 1);
    r = r && actor_declaration_6(b, l + 1);
    r = r && actor_declaration_7(b, l + 1);
    r = r && actor_declaration_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_string?
  private static boolean actor_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration_0")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // type_params?
  private static boolean actor_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration_3")) return false;
    type_params(b, l + 1);
    return true;
  }

  // ('is' type_list)?
  private static boolean actor_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration_4")) return false;
    actor_declaration_4_0(b, l + 1);
    return true;
  }

  // 'is' type_list
  private static boolean actor_declaration_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IS);
    r = r && type_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // field*
  private static boolean actor_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "actor_declaration_5", c)) break;
    }
    return true;
  }

  // constructor*
  private static boolean actor_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constructor(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "actor_declaration_6", c)) break;
    }
    return true;
  }

  // behavior*
  private static boolean actor_declaration_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!behavior(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "actor_declaration_7", c)) break;
    }
    return true;
  }

  // method*
  private static boolean actor_declaration_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "actor_declaration_8")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "actor_declaration_8", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // doc_string? 'be' id param_list ('=>' expr)?
  public static boolean behavior(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behavior")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BEHAVIOR, "<behavior>");
    r = behavior_0(b, l + 1);
    r = r && consumeToken(b, "be");
    r = r && consumeToken(b, ID);
    r = r && param_list(b, l + 1);
    r = r && behavior_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_string?
  private static boolean behavior_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behavior_0")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // ('=>' expr)?
  private static boolean behavior_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behavior_4")) return false;
    behavior_4_0(b, l + 1);
    return true;
  }

  // '=>' expr
  private static boolean behavior_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "behavior_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DARROW);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-' | '*' | '/' | '=' | '==' | '!=' | '<' | '>' | '<=' | '>=' | 'and' | 'or'
  public static boolean binary_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_OP, "<binary op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MULTIPLY);
    if (!r) r = consumeToken(b, DIVIDE);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, EQEQ);
    if (!r) r = consumeToken(b, NOTEQ);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LTEQ);
    if (!r) r = consumeToken(b, GTEQ);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('regexp:\n\t' expr)+
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = block_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!block_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'regexp:\n\t' expr
  private static boolean block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "regexp:\\n\\t");
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'true' | 'false'
  public static boolean boolean_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_LITERAL, "<boolean literal>");
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' (expr (',' expr)*)? ')'
  public static boolean call_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && call_args_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CALL_ARGS, r);
    return r;
  }

  // (expr (',' expr)*)?
  private static boolean call_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_1")) return false;
    call_args_1_0(b, l + 1);
    return true;
  }

  // expr (',' expr)*
  private static boolean call_args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && call_args_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' expr)*
  private static boolean call_args_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!call_args_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "call_args_1_0_1", c)) break;
    }
    return true;
  }

  // ',' expr
  private static boolean call_args_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_args_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'iso' | 'trn' | 'ref' | 'val' | 'box' | 'tag'
  public static boolean capability(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capability")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CAPABILITY, "<capability>");
    r = consumeToken(b, "iso");
    if (!r) r = consumeToken(b, "trn");
    if (!r) r = consumeToken(b, "ref");
    if (!r) r = consumeToken(b, "val");
    if (!r) r = consumeToken(b, "box");
    if (!r) r = consumeToken(b, "tag");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // doc_string? capability? 'class' ('iso' | 'val')? id type_params? ('is' type_list)? field* constructor* method*
  public static boolean class_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DECLARATION, "<class declaration>");
    r = class_declaration_0(b, l + 1);
    r = r && class_declaration_1(b, l + 1);
    r = r && consumeToken(b, "class");
    r = r && class_declaration_3(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && class_declaration_5(b, l + 1);
    r = r && class_declaration_6(b, l + 1);
    r = r && class_declaration_7(b, l + 1);
    r = r && class_declaration_8(b, l + 1);
    r = r && class_declaration_9(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_string?
  private static boolean class_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_0")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // capability?
  private static boolean class_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_1")) return false;
    capability(b, l + 1);
    return true;
  }

  // ('iso' | 'val')?
  private static boolean class_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_3")) return false;
    class_declaration_3_0(b, l + 1);
    return true;
  }

  // 'iso' | 'val'
  private static boolean class_declaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_3_0")) return false;
    boolean r;
    r = consumeToken(b, "iso");
    if (!r) r = consumeToken(b, "val");
    return r;
  }

  // type_params?
  private static boolean class_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_5")) return false;
    type_params(b, l + 1);
    return true;
  }

  // ('is' type_list)?
  private static boolean class_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_6")) return false;
    class_declaration_6_0(b, l + 1);
    return true;
  }

  // 'is' type_list
  private static boolean class_declaration_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IS);
    r = r && type_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // field*
  private static boolean class_declaration_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_declaration_7", c)) break;
    }
    return true;
  }

  // constructor*
  private static boolean class_declaration_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_8")) return false;
    while (true) {
      int c = current_position_(b);
      if (!constructor(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_declaration_8", c)) break;
    }
    return true;
  }

  // method*
  private static boolean class_declaration_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_declaration_9")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_declaration_9", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // doc_string? capability? 'new' id? 'create' param_list block
  public static boolean constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTRUCTOR, "<constructor>");
    r = constructor_0(b, l + 1);
    r = r && constructor_1(b, l + 1);
    r = r && consumeToken(b, "new");
    r = r && constructor_3(b, l + 1);
    r = r && consumeToken(b, "create");
    r = r && param_list(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_string?
  private static boolean constructor_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_0")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // capability?
  private static boolean constructor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_1")) return false;
    capability(b, l + 1);
    return true;
  }

  // id?
  private static boolean constructor_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_3")) return false;
    consumeToken(b, ID);
    return true;
  }

  /* ********************************************************** */
  // 'consume' expr
  public static boolean consume_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consume_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSUME_EXPR, "<consume expr>");
    r = consumeToken(b, "consume");
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // class_declaration
  //   | actor_declaration
  //   | primitive_declaration
  //   | trait_declaration
  //   | interface_declaration
  static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    r = class_declaration(b, l + 1);
    if (!r) r = actor_declaration(b, l + 1);
    if (!r) r = primitive_declaration(b, l + 1);
    if (!r) r = trait_declaration(b, l + 1);
    if (!r) r = interface_declaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '"""' string '"""'
  public static boolean doc_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOC_STRING, "<doc string>");
    r = consumeToken(b, "\"\"\"");
    r = r && consumeToken(b, STRING);
    r = r && consumeToken(b, "\"\"\"");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '.' id
  public static boolean dot_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_access")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, ID);
    exit_section_(b, m, DOT_ACCESS, r);
    return r;
  }

  /* ********************************************************** */
  // unary_op? primary expr_suffix*
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = expr_0(b, l + 1);
    r = r && primary(b, l + 1);
    r = r && expr_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unary_op?
  private static boolean expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    unary_op(b, l + 1);
    return true;
  }

  // expr_suffix*
  private static boolean expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_suffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // binary_op expr
  //   | call_args
  //   | dot_access
  public static boolean expr_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_suffix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_SUFFIX, "<expr suffix>");
    r = expr_suffix_0(b, l + 1);
    if (!r) r = call_args(b, l + 1);
    if (!r) r = dot_access(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // binary_op expr
  private static boolean expr_suffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_suffix_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binary_op(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '<<' id expr* '>>'
  public static boolean external_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "external_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTERNAL_DECLARATION, "<external declaration>");
    r = consumeToken(b, "<<");
    r = r && consumeToken(b, ID);
    r = r && external_declaration_2(b, l + 1);
    r = r && consumeToken(b, ">>");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expr*
  private static boolean external_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "external_declaration_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "external_declaration_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ('let' | 'var') id ':' type_expr ('=' expr)?
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = field_0(b, l + 1);
    r = r && consumeTokens(b, 0, ID, COLON);
    r = r && type_expr(b, l + 1);
    r = r && field_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'let' | 'var'
  private static boolean field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_0")) return false;
    boolean r;
    r = consumeToken(b, "let");
    if (!r) r = consumeToken(b, "var");
    return r;
  }

  // ('=' expr)?
  private static boolean field_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_4")) return false;
    field_4_0(b, l + 1);
    return true;
  }

  // '=' expr
  private static boolean field_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'if' expr 'then' expr ('else' expr)?
  public static boolean if_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IF_EXPR, "<if expr>");
    r = consumeToken(b, "if");
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, "then");
    r = r && expr(b, l + 1);
    r = r && if_expr_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('else' expr)?
  private static boolean if_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_4")) return false;
    if_expr_4_0(b, l + 1);
    return true;
  }

  // 'else' expr
  private static boolean if_expr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // doc_string? 'interface' id type_params? method*
  public static boolean interface_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE_DECLARATION, "<interface declaration>");
    r = interface_declaration_0(b, l + 1);
    r = r && consumeToken(b, "interface");
    r = r && consumeToken(b, ID);
    r = r && interface_declaration_3(b, l + 1);
    r = r && interface_declaration_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_string?
  private static boolean interface_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_declaration_0")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // type_params?
  private static boolean interface_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_declaration_3")) return false;
    type_params(b, l + 1);
    return true;
  }

  // method*
  private static boolean interface_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_declaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "interface_declaration_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // number | string_literal | boolean_literal | 'None'
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, NUMBER);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = boolean_literal(b, l + 1);
    if (!r) r = consumeToken(b, "None");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // pattern '=>' expr
  public static boolean match_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_case")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_CASE, "<match case>");
    r = pattern(b, l + 1);
    r = r && consumeToken(b, DARROW);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'match' expr ('|' match_case)* ('else' expr)?
  public static boolean match_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_EXPR, "<match expr>");
    r = consumeToken(b, "match");
    r = r && expr(b, l + 1);
    r = r && match_expr_2(b, l + 1);
    r = r && match_expr_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('|' match_case)*
  private static boolean match_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!match_expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_expr_2", c)) break;
    }
    return true;
  }

  // '|' match_case
  private static boolean match_expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && match_case(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('else' expr)?
  private static boolean match_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expr_3")) return false;
    match_expr_3_0(b, l + 1);
    return true;
  }

  // 'else' expr
  private static boolean match_expr_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expr_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // doc_string? method_modifier? 'fun' capability? id type_params? param_list (':' type_expr)? ('=>' expr)?
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD, "<method>");
    r = method_0(b, l + 1);
    r = r && method_1(b, l + 1);
    r = r && consumeToken(b, "fun");
    r = r && method_3(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && method_5(b, l + 1);
    r = r && param_list(b, l + 1);
    r = r && method_7(b, l + 1);
    r = r && method_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_string?
  private static boolean method_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_0")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // method_modifier?
  private static boolean method_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1")) return false;
    method_modifier(b, l + 1);
    return true;
  }

  // capability?
  private static boolean method_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_3")) return false;
    capability(b, l + 1);
    return true;
  }

  // type_params?
  private static boolean method_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_5")) return false;
    type_params(b, l + 1);
    return true;
  }

  // (':' type_expr)?
  private static boolean method_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_7")) return false;
    method_7_0(b, l + 1);
    return true;
  }

  // ':' type_expr
  private static boolean method_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=>' expr)?
  private static boolean method_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_8")) return false;
    method_8_0(b, l + 1);
    return true;
  }

  // '=>' expr
  private static boolean method_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DARROW);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'ref' | 'val' | 'box'
  public static boolean method_modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_modifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_MODIFIER, "<method modifier>");
    r = consumeToken(b, "ref");
    if (!r) r = consumeToken(b, "val");
    if (!r) r = consumeToken(b, "box");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id ':' type_expr
  public static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, COLON);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // '(' (param (',' param)*)? ')'
  public static boolean param_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && param_list_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, PARAM_LIST, r);
    return r;
  }

  // (param (',' param)*)?
  private static boolean param_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list_1")) return false;
    param_list_1_0(b, l + 1);
    return true;
  }

  // param (',' param)*
  private static boolean param_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = param(b, l + 1);
    r = r && param_list_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' param)*
  private static boolean param_list_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!param_list_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "param_list_1_0_1", c)) break;
    }
    return true;
  }

  // ',' param
  private static boolean param_list_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // literal | id | '(' pattern ')'
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = literal(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = pattern_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' pattern ')'
  private static boolean pattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && pattern(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // literal
  //   | id
  //   | block
  //   | if_expr
  //   | match_expr
  //   | try_expr
  //   | recover_expr
  //   | consume_expr
  //   | '(' expr ')'
  public static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY, "<primary>");
    r = literal(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = block(b, l + 1);
    if (!r) r = if_expr(b, l + 1);
    if (!r) r = match_expr(b, l + 1);
    if (!r) r = try_expr(b, l + 1);
    if (!r) r = recover_expr(b, l + 1);
    if (!r) r = consume_expr(b, l + 1);
    if (!r) r = primary_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' expr ')'
  private static boolean primary_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id type_args? | '(' type_expr ')'
  public static boolean primary_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_type")) return false;
    if (!nextTokenIs(b, "<primary type>", ID, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_TYPE, "<primary type>");
    r = primary_type_0(b, l + 1);
    if (!r) r = primary_type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // id type_args?
  private static boolean primary_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_type_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && primary_type_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // type_args?
  private static boolean primary_type_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_type_0_1")) return false;
    type_args(b, l + 1);
    return true;
  }

  // '(' type_expr ')'
  private static boolean primary_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_type_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && type_expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // doc_string? 'primitive' id type_params? method*
  public static boolean primitive_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMITIVE_DECLARATION, "<primitive declaration>");
    r = primitive_declaration_0(b, l + 1);
    r = r && consumeToken(b, "primitive");
    r = r && consumeToken(b, ID);
    r = r && primitive_declaration_3(b, l + 1);
    r = r && primitive_declaration_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_string?
  private static boolean primitive_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_declaration_0")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // type_params?
  private static boolean primitive_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_declaration_3")) return false;
    type_params(b, l + 1);
    return true;
  }

  // method*
  private static boolean primitive_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_declaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primitive_declaration_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // use_declaration* (declaration | external_declaration)*
  static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = program_0(b, l + 1);
    r = r && program_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // use_declaration*
  private static boolean program_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!use_declaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program_0", c)) break;
    }
    return true;
  }

  // (declaration | external_declaration)*
  private static boolean program_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!program_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program_1", c)) break;
    }
    return true;
  }

  // declaration | external_declaration
  private static boolean program_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_1_0")) return false;
    boolean r;
    r = declaration(b, l + 1);
    if (!r) r = external_declaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'recover' capability? expr 'end'
  public static boolean recover_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECOVER_EXPR, "<recover expr>");
    r = consumeToken(b, "recover");
    r = r && recover_expr_1(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // capability?
  private static boolean recover_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_expr_1")) return false;
    capability(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // string
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // doc_string? 'trait' id type_params? method*
  public static boolean trait_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRAIT_DECLARATION, "<trait declaration>");
    r = trait_declaration_0(b, l + 1);
    r = r && consumeToken(b, "trait");
    r = r && consumeToken(b, ID);
    r = r && trait_declaration_3(b, l + 1);
    r = r && trait_declaration_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // doc_string?
  private static boolean trait_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_declaration_0")) return false;
    doc_string(b, l + 1);
    return true;
  }

  // type_params?
  private static boolean trait_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_declaration_3")) return false;
    type_params(b, l + 1);
    return true;
  }

  // method*
  private static boolean trait_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_declaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "trait_declaration_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'try' expr ('else' expr)? 'end'
  public static boolean try_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRY_EXPR, "<try expr>");
    r = consumeToken(b, "try");
    r = r && expr(b, l + 1);
    r = r && try_expr_2(b, l + 1);
    r = r && consumeToken(b, "end");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('else' expr)?
  private static boolean try_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_expr_2")) return false;
    try_expr_2_0(b, l + 1);
    return true;
  }

  // 'else' expr
  private static boolean try_expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "try_expr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "else");
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[' type_expr (',' type_expr)* ']'
  public static boolean type_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_args")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && type_expr(b, l + 1);
    r = r && type_args_2(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, TYPE_ARGS, r);
    return r;
  }

  // (',' type_expr)*
  private static boolean type_args_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_args_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_args_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_args_2", c)) break;
    }
    return true;
  }

  // ',' type_expr
  private static boolean type_args_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_args_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primary_type type_suffix*
  public static boolean type_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr")) return false;
    if (!nextTokenIs(b, "<type expr>", ID, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPR, "<type expr>");
    r = primary_type(b, l + 1);
    r = r && type_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type_suffix*
  private static boolean type_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_suffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // type_expr (',' type_expr)*
  public static boolean type_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list")) return false;
    if (!nextTokenIs(b, "<type list>", ID, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_LIST, "<type list>");
    r = type_expr(b, l + 1);
    r = r && type_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' type_expr)*
  private static boolean type_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_list_1", c)) break;
    }
    return true;
  }

  // ',' type_expr
  private static boolean type_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id (':' type_expr)?
  public static boolean type_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_param")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && type_param_1(b, l + 1);
    exit_section_(b, m, TYPE_PARAM, r);
    return r;
  }

  // (':' type_expr)?
  private static boolean type_param_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_param_1")) return false;
    type_param_1_0(b, l + 1);
    return true;
  }

  // ':' type_expr
  private static boolean type_param_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_param_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[' type_param (',' type_param)* ']'
  public static boolean type_params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && type_param(b, l + 1);
    r = r && type_params_2(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, TYPE_PARAMS, r);
    return r;
  }

  // (',' type_param)*
  private static boolean type_params_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_params_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_params_2", c)) break;
    }
    return true;
  }

  // ',' type_param
  private static boolean type_params_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // capability | '|' primary_type | '&' primary_type
  public static boolean type_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_suffix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_SUFFIX, "<type suffix>");
    r = capability(b, l + 1);
    if (!r) r = type_suffix_1(b, l + 1);
    if (!r) r = type_suffix_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '|' primary_type
  private static boolean type_suffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_suffix_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && primary_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '&' primary_type
  private static boolean type_suffix_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_suffix_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "&");
    r = r && primary_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '-' | 'not'
  public static boolean unary_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_op")) return false;
    if (!nextTokenIs(b, "<unary op>", MINUS, NOT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_OP, "<unary op>");
    r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, NOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'use' string_literal ('=' string_literal)?
  public static boolean use_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE_DECLARATION, "<use declaration>");
    r = consumeToken(b, "use");
    r = r && string_literal(b, l + 1);
    r = r && use_declaration_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('=' string_literal)?
  private static boolean use_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_declaration_2")) return false;
    use_declaration_2_0(b, l + 1);
    return true;
  }

  // '=' string_literal
  private static boolean use_declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_declaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && string_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
