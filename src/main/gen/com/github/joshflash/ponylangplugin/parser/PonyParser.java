// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*;
import static com.github.joshflash.ponylangplugin.parser.PonyParserUtil.*;
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
    return module(b, l + 1);
  }

  /* ********************************************************** */
  // "\\" id (COMMA id)* "\\"
  public static boolean annotatedids(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedids")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATEDIDS, "<annotatedids>");
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, ID);
    r = r && annotatedids_2(b, l + 1);
    r = r && consumeToken(b, "\\");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA id)*
  private static boolean annotatedids_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedids_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!annotatedids_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "annotatedids_2", c)) break;
    }
    return true;
  }

  // COMMA id
  private static boolean annotatedids_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedids_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [annotatedids] (exprseq | jump)
  public static boolean annotatedrawseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATEDRAWSEQ, "<annotatedrawseq>");
    r = annotatedrawseq_0(b, l + 1);
    r = r && annotatedrawseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [annotatedids]
  private static boolean annotatedrawseq_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq_0")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // exprseq | jump
  private static boolean annotatedrawseq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotatedrawseq_1")) return false;
    boolean r;
    r = exprseq(b, l + 1);
    if (!r) r = jump(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // infix [EQUALS assignment]
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = infix(b, l + 1);
    r = r && assignment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [EQUALS assignment]
  private static boolean assignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1")) return false;
    assignment_1_0(b, l + 1);
    return true;
  }

  // EQUALS assignment
  private static boolean assignment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id_var
  //   | type_ref
  //   | literal
  //   | ifblock
  //   | whileloop
  //   | forloop
  //   | fun_def
  //   | object_def
  //   | recover_def
  //   | LP rawseq [tuple] RP
  //   | THIS
  //   | AT id_ffi [typeargs] LP [positional] [named] RP [QM]
  //   | SOURCELOC
  //   | LBK [AS type COLON] [rawseq] RBK
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = id_var(b, l + 1);
    if (!r) r = type_ref(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = ifblock(b, l + 1);
    if (!r) r = whileloop(b, l + 1);
    if (!r) r = forloop(b, l + 1);
    if (!r) r = fun_def(b, l + 1);
    if (!r) r = object_def(b, l + 1);
    if (!r) r = recover_def(b, l + 1);
    if (!r) r = atom_9(b, l + 1);
    if (!r) r = consumeToken(b, THIS);
    if (!r) r = atom_11(b, l + 1);
    if (!r) r = consumeToken(b, SOURCELOC);
    if (!r) r = atom_13(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LP rawseq [tuple] RP
  private static boolean atom_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && rawseq(b, l + 1);
    r = r && atom_9_2(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, null, r);
    return r;
  }

  // [tuple]
  private static boolean atom_9_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_9_2")) return false;
    tuple(b, l + 1);
    return true;
  }

  // AT id_ffi [typeargs] LP [positional] [named] RP [QM]
  private static boolean atom_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && id_ffi(b, l + 1);
    r = r && atom_11_2(b, l + 1);
    r = r && consumeToken(b, LP);
    r = r && atom_11_4(b, l + 1);
    r = r && atom_11_5(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && atom_11_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [typeargs]
  private static boolean atom_11_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_11_2")) return false;
    typeargs(b, l + 1);
    return true;
  }

  // [positional]
  private static boolean atom_11_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_11_4")) return false;
    positional(b, l + 1);
    return true;
  }

  // [named]
  private static boolean atom_11_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_11_5")) return false;
    named(b, l + 1);
    return true;
  }

  // [QM]
  private static boolean atom_11_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_11_7")) return false;
    consumeToken(b, QM);
    return true;
  }

  // LBK [AS type COLON] [rawseq] RBK
  private static boolean atom_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBK);
    r = r && atom_13_1(b, l + 1);
    r = r && atom_13_2(b, l + 1);
    r = r && consumeToken(b, RBK);
    exit_section_(b, m, null, r);
    return r;
  }

  // [AS type COLON]
  private static boolean atom_13_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_13_1")) return false;
    atom_13_1_0(b, l + 1);
    return true;
  }

  // AS type COLON
  private static boolean atom_13_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_13_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // [rawseq]
  private static boolean atom_13_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_13_2")) return false;
    rawseq(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // THIS
  //   | cap
  //   | LP infixtype [tupletype] RP
  //   | nominal
  //   | lambdatype
  //   | barelambdatype
  public static boolean atomtype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOMTYPE, "<atomtype>");
    r = consumeToken(b, THIS);
    if (!r) r = cap(b, l + 1);
    if (!r) r = atomtype_2(b, l + 1);
    if (!r) r = nominal(b, l + 1);
    if (!r) r = lambdatype(b, l + 1);
    if (!r) r = barelambdatype(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LP infixtype [tupletype] RP
  private static boolean atomtype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && infixtype(b, l + 1);
    r = r && atomtype_2_2(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, null, r);
    return r;
  }

  // [tupletype]
  private static boolean atomtype_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomtype_2_2")) return false;
    tupletype(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // RCVR [cap] [id_var] [typeparams] LP [type (COMMA type)*] RP [COLON type] [QM] RBC [cap | gencap] [CARET | BANG]
  public static boolean barelambdatype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype")) return false;
    if (!nextTokenIs(b, RCVR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RCVR);
    r = r && barelambdatype_1(b, l + 1);
    r = r && barelambdatype_2(b, l + 1);
    r = r && barelambdatype_3(b, l + 1);
    r = r && consumeToken(b, LP);
    r = r && barelambdatype_5(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && barelambdatype_7(b, l + 1);
    r = r && barelambdatype_8(b, l + 1);
    r = r && consumeToken(b, RBC);
    r = r && barelambdatype_10(b, l + 1);
    r = r && barelambdatype_11(b, l + 1);
    exit_section_(b, m, BARELAMBDATYPE, r);
    return r;
  }

  // [cap]
  private static boolean barelambdatype_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_1")) return false;
    cap(b, l + 1);
    return true;
  }

  // [id_var]
  private static boolean barelambdatype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_2")) return false;
    id_var(b, l + 1);
    return true;
  }

  // [typeparams]
  private static boolean barelambdatype_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_3")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // [type (COMMA type)*]
  private static boolean barelambdatype_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5")) return false;
    barelambdatype_5_0(b, l + 1);
    return true;
  }

  // type (COMMA type)*
  private static boolean barelambdatype_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && barelambdatype_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA type)*
  private static boolean barelambdatype_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!barelambdatype_5_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "barelambdatype_5_0_1", c)) break;
    }
    return true;
  }

  // COMMA type
  private static boolean barelambdatype_5_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_5_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COLON type]
  private static boolean barelambdatype_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_7")) return false;
    barelambdatype_7_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean barelambdatype_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [QM]
  private static boolean barelambdatype_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_8")) return false;
    consumeToken(b, QM);
    return true;
  }

  // [cap | gencap]
  private static boolean barelambdatype_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_10")) return false;
    barelambdatype_10_0(b, l + 1);
    return true;
  }

  // cap | gencap
  private static boolean barelambdatype_10_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_10_0")) return false;
    boolean r;
    r = cap(b, l + 1);
    if (!r) r = consumeToken(b, GENCAP);
    return r;
  }

  // [CARET | BANG]
  private static boolean barelambdatype_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_11")) return false;
    barelambdatype_11_0(b, l + 1);
    return true;
  }

  // CARET | BANG
  private static boolean barelambdatype_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "barelambdatype_11_0")) return false;
    boolean r;
    r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, BANG);
    return r;
  }

  /* ********************************************************** */
  // VAR | LET | EMBED
  public static boolean binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINDING, "<binding>");
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, EMBED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (safeop | unsafeop | partialop) [QM] term
  public static boolean binop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINOP, "<binop>");
    r = binop_0(b, l + 1);
    r = r && binop_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // safeop | unsafeop | partialop
  private static boolean binop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binop_0")) return false;
    boolean r;
    r = safeop(b, l + 1);
    if (!r) r = unsafeop(b, l + 1);
    if (!r) r = partialop(b, l + 1);
    return r;
  }

  // [QM]
  private static boolean binop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binop_1")) return false;
    consumeToken(b, QM);
    return true;
  }

  /* ********************************************************** */
  // LP [positional] [named] RP [QM]
  public static boolean call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && call_1(b, l + 1);
    r = r && call_2(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && call_4(b, l + 1);
    exit_section_(b, m, CALL, r);
    return r;
  }

  // [positional]
  private static boolean call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_1")) return false;
    positional(b, l + 1);
    return true;
  }

  // [named]
  private static boolean call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_2")) return false;
    named(b, l + 1);
    return true;
  }

  // [QM]
  private static boolean call_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_4")) return false;
    consumeToken(b, QM);
    return true;
  }

  /* ********************************************************** */
  // ISO | REF | TRN | VAL | BOX | TAG
  public static boolean cap(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cap")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CAP, "<cap>");
    r = consumeToken(b, ISO);
    if (!r) r = consumeToken(b, REF);
    if (!r) r = consumeToken(b, TRN);
    if (!r) r = consumeToken(b, VAL);
    if (!r) r = consumeToken(b, BOX);
    if (!r) r = consumeToken(b, TAG);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PIPE [annotatedids] [casepattern] [IF rawseq] [ARROW rawseq]
  public static boolean caseexpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr")) return false;
    if (!nextTokenIs(b, PIPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && caseexpr_1(b, l + 1);
    r = r && caseexpr_2(b, l + 1);
    r = r && caseexpr_3(b, l + 1);
    r = r && caseexpr_4(b, l + 1);
    exit_section_(b, m, CASEEXPR, r);
    return r;
  }

  // [annotatedids]
  private static boolean caseexpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [casepattern]
  private static boolean caseexpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_2")) return false;
    casepattern(b, l + 1);
    return true;
  }

  // [IF rawseq]
  private static boolean caseexpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_3")) return false;
    caseexpr_3_0(b, l + 1);
    return true;
  }

  // IF rawseq
  private static boolean caseexpr_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ARROW rawseq]
  private static boolean caseexpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_4")) return false;
    caseexpr_4_0(b, l + 1);
    return true;
  }

  // ARROW rawseq
  private static boolean caseexpr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseexpr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // binding term_ref [COLON type]
  //   | postfixop* postfix
  public static boolean casepattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casepattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASEPATTERN, "<casepattern>");
    r = casepattern_0(b, l + 1);
    if (!r) r = casepattern_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // binding term_ref [COLON type]
  private static boolean casepattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casepattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding(b, l + 1);
    r = r && term_ref(b, l + 1);
    r = r && casepattern_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COLON type]
  private static boolean casepattern_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casepattern_0_2")) return false;
    casepattern_0_2_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean casepattern_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casepattern_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // postfixop* postfix
  private static boolean casepattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casepattern_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = casepattern_1_0(b, l + 1);
    r = r && postfix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // postfixop*
  private static boolean casepattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "casepattern_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!postfixop(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "casepattern_1_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // CHAIN member_ref
  public static boolean chain_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chain_id")) return false;
    if (!nextTokenIs(b, CHAIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHAIN);
    r = r && member_ref(b, l + 1);
    exit_section_(b, m, CHAIN_ID, r);
    return r;
  }

  /* ********************************************************** */
  // declaration [annotatedids] [AT] [cap] type_ref [typeparams] [IS type] [doc_string] members
  public static boolean class_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DEF, "<class def>");
    r = declaration(b, l + 1);
    r = r && class_def_1(b, l + 1);
    r = r && class_def_2(b, l + 1);
    r = r && class_def_3(b, l + 1);
    r = r && type_ref(b, l + 1);
    r = r && class_def_5(b, l + 1);
    r = r && class_def_6(b, l + 1);
    r = r && class_def_7(b, l + 1);
    r = r && members(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [annotatedids]
  private static boolean class_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [AT]
  private static boolean class_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_2")) return false;
    consumeToken(b, AT);
    return true;
  }

  // [cap]
  private static boolean class_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_3")) return false;
    cap(b, l + 1);
    return true;
  }

  // [typeparams]
  private static boolean class_def_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_5")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // [IS type]
  private static boolean class_def_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_6")) return false;
    class_def_6_0(b, l + 1);
    return true;
  }

  // IS type
  private static boolean class_def_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IS);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [doc_string]
  private static boolean class_def_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_def_7")) return false;
    consumeToken(b, DOC_STRING);
    return true;
  }

  /* ********************************************************** */
  // line_comment | block_comment | doc_string
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, LINE_COMMENT);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    if (!r) r = consumeToken(b, DOC_STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ifblock
  //   | whileloop
  //   | forloop
  //   | tryblock
  //   | matchblock
  public static boolean controlblock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "controlblock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTROLBLOCK, "<controlblock>");
    r = ifblock(b, l + 1);
    if (!r) r = whileloop(b, l + 1);
    if (!r) r = forloop(b, l + 1);
    if (!r) r = tryblock(b, l + 1);
    if (!r) r = matchblock(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TYPEDEF | INTERFACE | TRAIT | PRIMITIVE | STRUCT | CLASS | ACTOR
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = consumeToken(b, TYPEDEF);
    if (!r) r = consumeToken(b, INTERFACE);
    if (!r) r = consumeToken(b, TRAIT);
    if (!r) r = consumeToken(b, PRIMITIVE);
    if (!r) r = consumeToken(b, STRUCT);
    if (!r) r = consumeToken(b, CLASS);
    if (!r) r = consumeToken(b, ACTOR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOT (member_ref | tuple_id)
  public static boolean dot_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_id")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && dot_id_1(b, l + 1);
    exit_section_(b, m, DOT_ID, r);
    return r;
  }

  // member_ref | tuple_id
  private static boolean dot_id_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_id_1")) return false;
    boolean r;
    r = member_ref(b, l + 1);
    if (!r) r = consumeToken(b, TUPLE_ID);
    return r;
  }

  /* ********************************************************** */
  // DOT type_ref
  public static boolean dot_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_type")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && type_ref(b, l + 1);
    exit_section_(b, m, DOT_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // ELSEIF [annotatedids] rawseq THEN rawseq [elif | (ELSE annotatedrawseq)]
  public static boolean elif(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elif")) return false;
    if (!nextTokenIs(b, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && elif_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    r = r && elif_5(b, l + 1);
    exit_section_(b, m, ELIF, r);
    return r;
  }

  // [annotatedids]
  private static boolean elif_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elif_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [elif | (ELSE annotatedrawseq)]
  private static boolean elif_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elif_5")) return false;
    elif_5_0(b, l + 1);
    return true;
  }

  // elif | (ELSE annotatedrawseq)
  private static boolean elif_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elif_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elif(b, l + 1);
    if (!r) r = elif_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean elif_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elif_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ELSEIF [annotatedids] infix THEN rawseq [elifdef | (ELSE annotatedrawseq)]
  public static boolean elifdef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elifdef")) return false;
    if (!nextTokenIs(b, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && elifdef_1(b, l + 1);
    r = r && infix(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    r = r && elifdef_5(b, l + 1);
    exit_section_(b, m, ELIFDEF, r);
    return r;
  }

  // [annotatedids]
  private static boolean elifdef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elifdef_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [elifdef | (ELSE annotatedrawseq)]
  private static boolean elifdef_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elifdef_5")) return false;
    elifdef_5_0(b, l + 1);
    return true;
  }

  // elifdef | (ELSE annotatedrawseq)
  private static boolean elifdef_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elifdef_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elifdef(b, l + 1);
    if (!r) r = elifdef_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean elifdef_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elifdef_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ELSEIF [annotatedids] istype [eliftype | (ELSE annotatedrawseq)]
  public static boolean eliftype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eliftype")) return false;
    if (!nextTokenIs(b, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && eliftype_1(b, l + 1);
    r = r && istype(b, l + 1);
    r = r && eliftype_3(b, l + 1);
    exit_section_(b, m, ELIFTYPE, r);
    return r;
  }

  // [annotatedids]
  private static boolean eliftype_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eliftype_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [eliftype | (ELSE annotatedrawseq)]
  private static boolean eliftype_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eliftype_3")) return false;
    eliftype_3_0(b, l + 1);
    return true;
  }

  // eliftype | (ELSE annotatedrawseq)
  private static boolean eliftype_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eliftype_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eliftype(b, l + 1);
    if (!r) r = eliftype_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean eliftype_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eliftype_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assignment [semiexpr | nosemi]
  public static boolean exprseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRSEQ, "<exprseq>");
    r = assignment(b, l + 1);
    r = r && exprseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [semiexpr | nosemi]
  private static boolean exprseq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprseq_1")) return false;
    exprseq_1_0(b, l + 1);
    return true;
  }

  // semiexpr | nosemi
  private static boolean exprseq_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprseq_1_0")) return false;
    boolean r;
    r = semiexpr(b, l + 1);
    if (!r) r = nosemi(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // binding member_ref COLON type [EQUALS infix] [doc_string]
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = binding(b, l + 1);
    r = r && member_ref(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    r = r && field_4(b, l + 1);
    r = r && field_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [EQUALS infix]
  private static boolean field_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_4")) return false;
    field_4_0(b, l + 1);
    return true;
  }

  // EQUALS infix
  private static boolean field_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [doc_string]
  private static boolean field_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_5")) return false;
    consumeToken(b, DOC_STRING);
    return true;
  }

  /* ********************************************************** */
  // FOR [annotatedids] idseq IN rawseq DO rawseq [ELSE annotatedrawseq] END
  public static boolean forloop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forloop")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && forloop_1(b, l + 1);
    r = r && idseq(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && rawseq(b, l + 1);
    r = r && forloop_7(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, FORLOOP, r);
    return r;
  }

  // [annotatedids]
  private static boolean forloop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forloop_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [ELSE annotatedrawseq]
  private static boolean forloop_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forloop_7")) return false;
    forloop_7_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean forloop_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forloop_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBC [annotatedids] [cap] [param_ref] [typeparams] LP [lambdaparams] RP [lambdacaptures] [COLON type] [QM] ARROW rawseq RBC [cap]
  public static boolean fun_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def")) return false;
    if (!nextTokenIs(b, LBC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBC);
    r = r && fun_def_1(b, l + 1);
    r = r && fun_def_2(b, l + 1);
    r = r && fun_def_3(b, l + 1);
    r = r && fun_def_4(b, l + 1);
    r = r && consumeToken(b, LP);
    r = r && fun_def_6(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && fun_def_8(b, l + 1);
    r = r && fun_def_9(b, l + 1);
    r = r && fun_def_10(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, RBC);
    r = r && fun_def_14(b, l + 1);
    exit_section_(b, m, FUN_DEF, r);
    return r;
  }

  // [annotatedids]
  private static boolean fun_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [cap]
  private static boolean fun_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // [param_ref]
  private static boolean fun_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_3")) return false;
    param_ref(b, l + 1);
    return true;
  }

  // [typeparams]
  private static boolean fun_def_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // [lambdaparams]
  private static boolean fun_def_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_6")) return false;
    lambdaparams(b, l + 1);
    return true;
  }

  // [lambdacaptures]
  private static boolean fun_def_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_8")) return false;
    lambdacaptures(b, l + 1);
    return true;
  }

  // [COLON type]
  private static boolean fun_def_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_9")) return false;
    fun_def_9_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean fun_def_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [QM]
  private static boolean fun_def_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_10")) return false;
    consumeToken(b, QM);
    return true;
  }

  // [cap]
  private static boolean fun_def_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_def_14")) return false;
    cap(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SCORE* (id | type_id | string)
  public static boolean id_ffi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_ffi")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID_FFI, "<id ffi>");
    r = id_ffi_0(b, l + 1);
    r = r && id_ffi_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SCORE*
  private static boolean id_ffi_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_ffi_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, SCORE)) break;
      if (!empty_element_parsed_guard_(b, "id_ffi_0", c)) break;
    }
    return true;
  }

  // id | type_id | string
  private static boolean id_ffi_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_ffi_1")) return false;
    boolean r;
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, TYPE_ID);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  /* ********************************************************** */
  // id | type_id | SCORE
  public static boolean id_var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_var")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID_VAR, "<id var>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, TYPE_ID);
    if (!r) r = consumeToken(b, SCORE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // term_ref
  //   | LP idseq (COMMA idseq)* RP
  public static boolean idseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDSEQ, "<idseq>");
    r = term_ref(b, l + 1);
    if (!r) r = idseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LP idseq (COMMA idseq)* RP
  private static boolean idseq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && idseq(b, l + 1);
    r = r && idseq_1_2(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA idseq)*
  private static boolean idseq_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!idseq_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "idseq_1_2", c)) break;
    }
    return true;
  }

  // COMMA idseq
  private static boolean idseq_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idseq_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && idseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF [annotatedids] rawseq THEN rawseq [elif | (ELSE annotatedrawseq)] END
  public static boolean ifblock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifblock")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && ifblock_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    r = r && ifblock_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, IFBLOCK, r);
    return r;
  }

  // [annotatedids]
  private static boolean ifblock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifblock_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [elif | (ELSE annotatedrawseq)]
  private static boolean ifblock_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifblock_5")) return false;
    ifblock_5_0(b, l + 1);
    return true;
  }

  // elif | (ELSE annotatedrawseq)
  private static boolean ifblock_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifblock_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elif(b, l + 1);
    if (!r) r = ifblock_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean ifblock_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifblock_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // term infixop*
  public static boolean infix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INFIX, "<infix>");
    r = term(b, l + 1);
    r = r && infix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // infixop*
  private static boolean infix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!infixop(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "infix_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // binop | isop | AS type
  public static boolean infixop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INFIXOP, "<infixop>");
    r = binop(b, l + 1);
    if (!r) r = isop(b, l + 1);
    if (!r) r = infixop_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AS type
  private static boolean infixop_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixop_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (type | SCORE) (uniontype | isecttype)*
  public static boolean infixtype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixtype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INFIXTYPE, "<infixtype>");
    r = infixtype_0(b, l + 1);
    r = r && infixtype_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type | SCORE
  private static boolean infixtype_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixtype_0")) return false;
    boolean r;
    r = type(b, l + 1);
    if (!r) r = consumeToken(b, SCORE);
    return r;
  }

  // (uniontype | isecttype)*
  private static boolean infixtype_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixtype_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!infixtype_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "infixtype_1", c)) break;
    }
    return true;
  }

  // uniontype | isecttype
  private static boolean infixtype_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infixtype_1_0")) return false;
    boolean r;
    r = uniontype(b, l + 1);
    if (!r) r = isecttype(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // AMP type
  public static boolean isecttype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isecttype")) return false;
    if (!nextTokenIs(b, AMP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AMP);
    r = r && type(b, l + 1);
    exit_section_(b, m, ISECTTYPE, r);
    return r;
  }

  /* ********************************************************** */
  // (IS | ISNT) term
  public static boolean isop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isop")) return false;
    if (!nextTokenIs(b, "<isop>", IS, ISNT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ISOP, "<isop>");
    r = isop_0(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IS | ISNT
  private static boolean isop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isop_0")) return false;
    boolean r;
    r = consumeToken(b, IS);
    if (!r) r = consumeToken(b, ISNT);
    return r;
  }

  /* ********************************************************** */
  // type ISA type THEN rawseq
  public static boolean istype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "istype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ISTYPE, "<istype>");
    r = type(b, l + 1);
    r = r && consumeToken(b, ISA);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (RETURN | BREAK | CONTINUE | ERROR | COMP_INT | COMP_ERR) [rawseq]
  public static boolean jump(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JUMP, "<jump>");
    r = jump_0(b, l + 1);
    r = r && jump_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RETURN | BREAK | CONTINUE | ERROR | COMP_INT | COMP_ERR
  private static boolean jump_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump_0")) return false;
    boolean r;
    r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, CONTINUE);
    if (!r) r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, COMP_INT);
    if (!r) r = consumeToken(b, COMP_ERR);
    return r;
  }

  // [rawseq]
  private static boolean jump_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jump_1")) return false;
    rawseq(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // param_ref [COLON type] [EQUALS infix]
  public static boolean lambdacapture(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture")) return false;
    if (!nextTokenIs(b, "<lambdacapture>", ID, SCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDACAPTURE, "<lambdacapture>");
    r = param_ref(b, l + 1);
    r = r && lambdacapture_1(b, l + 1);
    r = r && lambdacapture_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON type]
  private static boolean lambdacapture_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_1")) return false;
    lambdacapture_1_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean lambdacapture_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [EQUALS infix]
  private static boolean lambdacapture_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_2")) return false;
    lambdacapture_2_0(b, l + 1);
    return true;
  }

  // EQUALS infix
  private static boolean lambdacapture_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacapture_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LP (lambdacapture | THIS) (COMMA (lambdacapture | THIS))* RP
  public static boolean lambdacaptures(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures")) return false;
    if (!nextTokenIs(b, LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LP);
    r = r && lambdacaptures_1(b, l + 1);
    r = r && lambdacaptures_2(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, LAMBDACAPTURES, r);
    return r;
  }

  // lambdacapture | THIS
  private static boolean lambdacaptures_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_1")) return false;
    boolean r;
    r = lambdacapture(b, l + 1);
    if (!r) r = consumeToken(b, THIS);
    return r;
  }

  // (COMMA (lambdacapture | THIS))*
  private static boolean lambdacaptures_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambdacaptures_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambdacaptures_2", c)) break;
    }
    return true;
  }

  // COMMA (lambdacapture | THIS)
  private static boolean lambdacaptures_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && lambdacaptures_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // lambdacapture | THIS
  private static boolean lambdacaptures_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdacaptures_2_0_1")) return false;
    boolean r;
    r = lambdacapture(b, l + 1);
    if (!r) r = consumeToken(b, THIS);
    return r;
  }

  /* ********************************************************** */
  // param_ref [COLON type] [EQUALS infix]
  public static boolean lambdaparam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam")) return false;
    if (!nextTokenIs(b, "<lambdaparam>", ID, SCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDAPARAM, "<lambdaparam>");
    r = param_ref(b, l + 1);
    r = r && lambdaparam_1(b, l + 1);
    r = r && lambdaparam_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON type]
  private static boolean lambdaparam_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_1")) return false;
    lambdaparam_1_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean lambdaparam_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [EQUALS infix]
  private static boolean lambdaparam_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_2")) return false;
    lambdaparam_2_0(b, l + 1);
    return true;
  }

  // EQUALS infix
  private static boolean lambdaparam_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparam_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lambdaparam (COMMA lambdaparam)*
  public static boolean lambdaparams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparams")) return false;
    if (!nextTokenIs(b, "<lambdaparams>", ID, SCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDAPARAMS, "<lambdaparams>");
    r = lambdaparam(b, l + 1);
    r = r && lambdaparams_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA lambdaparam)*
  private static boolean lambdaparams_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparams_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambdaparams_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambdaparams_1", c)) break;
    }
    return true;
  }

  // COMMA lambdaparam
  private static boolean lambdaparams_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaparams_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && lambdaparam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBC [cap] [id_var] [typeparams] LP [type (COMMA type)*] RP [COLON type] [QM] RBC [cap | gencap] [CARET | BANG]
  public static boolean lambdatype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype")) return false;
    if (!nextTokenIs(b, LBC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBC);
    r = r && lambdatype_1(b, l + 1);
    r = r && lambdatype_2(b, l + 1);
    r = r && lambdatype_3(b, l + 1);
    r = r && consumeToken(b, LP);
    r = r && lambdatype_5(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && lambdatype_7(b, l + 1);
    r = r && lambdatype_8(b, l + 1);
    r = r && consumeToken(b, RBC);
    r = r && lambdatype_10(b, l + 1);
    r = r && lambdatype_11(b, l + 1);
    exit_section_(b, m, LAMBDATYPE, r);
    return r;
  }

  // [cap]
  private static boolean lambdatype_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_1")) return false;
    cap(b, l + 1);
    return true;
  }

  // [id_var]
  private static boolean lambdatype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_2")) return false;
    id_var(b, l + 1);
    return true;
  }

  // [typeparams]
  private static boolean lambdatype_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_3")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // [type (COMMA type)*]
  private static boolean lambdatype_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5")) return false;
    lambdatype_5_0(b, l + 1);
    return true;
  }

  // type (COMMA type)*
  private static boolean lambdatype_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && lambdatype_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA type)*
  private static boolean lambdatype_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lambdatype_5_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambdatype_5_0_1", c)) break;
    }
    return true;
  }

  // COMMA type
  private static boolean lambdatype_5_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_5_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COLON type]
  private static boolean lambdatype_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_7")) return false;
    lambdatype_7_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean lambdatype_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [QM]
  private static boolean lambdatype_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_8")) return false;
    consumeToken(b, QM);
    return true;
  }

  // [cap | gencap]
  private static boolean lambdatype_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_10")) return false;
    lambdatype_10_0(b, l + 1);
    return true;
  }

  // cap | gencap
  private static boolean lambdatype_10_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_10_0")) return false;
    boolean r;
    r = cap(b, l + 1);
    if (!r) r = consumeToken(b, GENCAP);
    return r;
  }

  // [CARET | BANG]
  private static boolean lambdatype_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_11")) return false;
    lambdatype_11_0(b, l + 1);
    return true;
  }

  // CARET | BANG
  private static boolean lambdatype_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdatype_11_0")) return false;
    boolean r;
    r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, BANG);
    return r;
  }

  /* ********************************************************** */
  // true
  //   | false
  //   | char
  //   | number
  //   | stringliteral
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = number(b, l + 1);
    if (!r) r = stringliteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MATCH [annotatedids] rawseq caseexpr* [ELSE annotatedrawseq] END
  public static boolean matchblock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchblock")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && matchblock_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && matchblock_3(b, l + 1);
    r = r && matchblock_4(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, MATCHBLOCK, r);
    return r;
  }

  // [annotatedids]
  private static boolean matchblock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchblock_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // caseexpr*
  private static boolean matchblock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchblock_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseexpr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "matchblock_3", c)) break;
    }
    return true;
  }

  // [ELSE annotatedrawseq]
  private static boolean matchblock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchblock_4")) return false;
    matchblock_4_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean matchblock_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchblock_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean member_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_ref")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, MEMBER_REF, r);
    return r;
  }

  /* ********************************************************** */
  // field* method*
  public static boolean members(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "members")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MEMBERS, "<members>");
    r = members_0(b, l + 1);
    r = r && members_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // field*
  private static boolean members_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "members_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "members_0", c)) break;
    }
    return true;
  }

  // method*
  private static boolean members_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "members_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "members_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (FUN | BE | NEW) [annotatedids] [cap | AT] member_ref [typeparams] LP [params] RP [COLON type] [QM] [ARROW] [doc_string] [rawseq]
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD, "<method>");
    r = method_0(b, l + 1);
    r = r && method_1(b, l + 1);
    r = r && method_2(b, l + 1);
    r = r && member_ref(b, l + 1);
    r = r && method_4(b, l + 1);
    r = r && consumeToken(b, LP);
    r = r && method_6(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && method_8(b, l + 1);
    r = r && method_9(b, l + 1);
    r = r && method_10(b, l + 1);
    r = r && method_11(b, l + 1);
    r = r && method_12(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FUN | BE | NEW
  private static boolean method_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_0")) return false;
    boolean r;
    r = consumeToken(b, FUN);
    if (!r) r = consumeToken(b, BE);
    if (!r) r = consumeToken(b, NEW);
    return r;
  }

  // [annotatedids]
  private static boolean method_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [cap | AT]
  private static boolean method_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_2")) return false;
    method_2_0(b, l + 1);
    return true;
  }

  // cap | AT
  private static boolean method_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_2_0")) return false;
    boolean r;
    r = cap(b, l + 1);
    if (!r) r = consumeToken(b, AT);
    return r;
  }

  // [typeparams]
  private static boolean method_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // [params]
  private static boolean method_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_6")) return false;
    params(b, l + 1);
    return true;
  }

  // [COLON type]
  private static boolean method_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_8")) return false;
    method_8_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean method_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [QM]
  private static boolean method_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_9")) return false;
    consumeToken(b, QM);
    return true;
  }

  // [ARROW]
  private static boolean method_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_10")) return false;
    consumeToken(b, ARROW);
    return true;
  }

  // [doc_string]
  private static boolean method_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_11")) return false;
    consumeToken(b, DOC_STRING);
    return true;
  }

  // [rawseq]
  private static boolean method_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_12")) return false;
    rawseq(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [doc_string] usestmt* class_def*
  static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_0(b, l + 1);
    r = r && module_1(b, l + 1);
    r = r && module_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [doc_string]
  private static boolean module_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_0")) return false;
    consumeToken(b, DOC_STRING);
    return true;
  }

  // usestmt*
  private static boolean module_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!usestmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_1", c)) break;
    }
    return true;
  }

  // class_def*
  private static boolean module_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_def(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // WHERE id EQUALS rawseq (COMMA id EQUALS rawseq)*
  public static boolean named(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named")) return false;
    if (!nextTokenIs(b, WHERE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WHERE, ID, EQUALS);
    r = r && rawseq(b, l + 1);
    r = r && named_4(b, l + 1);
    exit_section_(b, m, NAMED, r);
    return r;
  }

  // (COMMA id EQUALS rawseq)*
  private static boolean named_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!named_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_4", c)) break;
    }
    return true;
  }

  // COMMA id EQUALS rawseq
  private static boolean named_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, ID, EQUALS);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assignment [semiexpr | nosemi]
  public static boolean nextexprseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextexprseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEXTEXPRSEQ, "<nextexprseq>");
    r = assignment(b, l + 1);
    r = r && nextexprseq_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [semiexpr | nosemi]
  private static boolean nextexprseq_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextexprseq_1")) return false;
    nextexprseq_1_0(b, l + 1);
    return true;
  }

  // semiexpr | nosemi
  private static boolean nextexprseq_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nextexprseq_1_0")) return false;
    boolean r;
    r = semiexpr(b, l + 1);
    if (!r) r = nosemi(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // [id_var DOT] type_ref [typeargs] [cap | gencap] [CARET | BANG]
  public static boolean nominal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOMINAL, "<nominal>");
    r = nominal_0(b, l + 1);
    r = r && type_ref(b, l + 1);
    r = r && nominal_2(b, l + 1);
    r = r && nominal_3(b, l + 1);
    r = r && nominal_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [id_var DOT]
  private static boolean nominal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_0")) return false;
    nominal_0_0(b, l + 1);
    return true;
  }

  // id_var DOT
  private static boolean nominal_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id_var(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // [typeargs]
  private static boolean nominal_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_2")) return false;
    typeargs(b, l + 1);
    return true;
  }

  // [cap | gencap]
  private static boolean nominal_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_3")) return false;
    nominal_3_0(b, l + 1);
    return true;
  }

  // cap | gencap
  private static boolean nominal_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_3_0")) return false;
    boolean r;
    r = cap(b, l + 1);
    if (!r) r = consumeToken(b, GENCAP);
    return r;
  }

  // [CARET | BANG]
  private static boolean nominal_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_4")) return false;
    nominal_4_0(b, l + 1);
    return true;
  }

  // CARET | BANG
  private static boolean nominal_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nominal_4_0")) return false;
    boolean r;
    r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, BANG);
    return r;
  }

  /* ********************************************************** */
  // jump | nextexprseq
  public static boolean nosemi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nosemi")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOSEMI, "<nosemi>");
    r = jump(b, l + 1);
    if (!r) r = nextexprseq(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // float | int
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    if (!nextTokenIs(b, "<number>", FLOAT, INT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, INT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OBJECT [annotatedids] [cap] [IS type] members END
  public static boolean object_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_def")) return false;
    if (!nextTokenIs(b, OBJECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OBJECT);
    r = r && object_def_1(b, l + 1);
    r = r && object_def_2(b, l + 1);
    r = r && object_def_3(b, l + 1);
    r = r && members(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, OBJECT_DEF, r);
    return r;
  }

  // [annotatedids]
  private static boolean object_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_def_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [cap]
  private static boolean object_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_def_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // [IS type]
  private static boolean object_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_def_3")) return false;
    object_def_3_0(b, l + 1);
    return true;
  }

  // IS type
  private static boolean object_def_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_def_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IS);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // param_ref COLON type [EQUALS infix]
  public static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    if (!nextTokenIs(b, "<param>", ID, SCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM, "<param>");
    r = param_ref(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    r = r && param_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [EQUALS infix]
  private static boolean param_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_3")) return false;
    param_3_0(b, l + 1);
    return true;
  }

  // EQUALS infix
  private static boolean param_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id | SCORE
  public static boolean param_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_ref")) return false;
    if (!nextTokenIs(b, "<param ref>", ID, SCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_REF, "<param ref>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, SCORE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (param | ELIPSIS) (COMMA (param | ELIPSIS))*
  public static boolean params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMS, "<params>");
    r = params_0(b, l + 1);
    r = r && params_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // param | ELIPSIS
  private static boolean params_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_0")) return false;
    boolean r;
    r = param(b, l + 1);
    if (!r) r = consumeToken(b, ELIPSIS);
    return r;
  }

  // (COMMA (param | ELIPSIS))*
  private static boolean params_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!params_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "params_1", c)) break;
    }
    return true;
  }

  // COMMA (param | ELIPSIS)
  private static boolean params_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && params_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // param | ELIPSIS
  private static boolean params_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "params_1_0_1")) return false;
    boolean r;
    r = param(b, l + 1);
    if (!r) r = consumeToken(b, ELIPSIS);
    return r;
  }

  /* ********************************************************** */
  // ADD_PARTIAL | SUB_PARTIAL | MUL_PARTIAL
  //   | DIV_PARTIAL | REM_PARTIAL | MOD_PARTIAL
  public static boolean partialop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "partialop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARTIALOP, "<partialop>");
    r = consumeToken(b, ADD_PARTIAL);
    if (!r) r = consumeToken(b, SUB_PARTIAL);
    if (!r) r = consumeToken(b, MUL_PARTIAL);
    if (!r) r = consumeToken(b, DIV_PARTIAL);
    if (!r) r = consumeToken(b, REM_PARTIAL);
    if (!r) r = consumeToken(b, MOD_PARTIAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // rawseq (COMMA rawseq)*
  public static boolean positional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSITIONAL, "<positional>");
    r = rawseq(b, l + 1);
    r = r && positional_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA rawseq)*
  private static boolean positional_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!positional_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "positional_1", c)) break;
    }
    return true;
  }

  // COMMA rawseq
  private static boolean positional_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atom postfixelem*
  public static boolean postfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIX, "<postfix>");
    r = atom(b, l + 1);
    r = r && postfix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // postfixelem*
  private static boolean postfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!postfixelem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "postfix_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // dot_id | tilde_id | chain_id | dot_type | typeargs | call
  public static boolean postfixelem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixelem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIXELEM, "<postfixelem>");
    r = dot_id(b, l + 1);
    if (!r) r = tilde_id(b, l + 1);
    if (!r) r = chain_id(b, l + 1);
    if (!r) r = dot_type(b, l + 1);
    if (!r) r = typeargs(b, l + 1);
    if (!r) r = call(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NOT | ADDRESSOF | SUB | SUB_UNSAFE | DIGESTOF
  public static boolean postfixop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIXOP, "<postfixop>");
    r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, ADDRESSOF);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, SUB_UNSAFE);
    if (!r) r = consumeToken(b, DIGESTOF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // exprseq | jump
  public static boolean rawseq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rawseq")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RAWSEQ, "<rawseq>");
    r = exprseq(b, l + 1);
    if (!r) r = jump(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RCVR [annotatedids] [cap] [param_ref] [typeparams] LP [lambdaparams] RP [lambdacaptures] [COLON type] [QM] ARROW rawseq RBC [cap]
  public static boolean recover_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def")) return false;
    if (!nextTokenIs(b, RCVR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RCVR);
    r = r && recover_def_1(b, l + 1);
    r = r && recover_def_2(b, l + 1);
    r = r && recover_def_3(b, l + 1);
    r = r && recover_def_4(b, l + 1);
    r = r && consumeToken(b, LP);
    r = r && recover_def_6(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && recover_def_8(b, l + 1);
    r = r && recover_def_9(b, l + 1);
    r = r && recover_def_10(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, RBC);
    r = r && recover_def_14(b, l + 1);
    exit_section_(b, m, RECOVER_DEF, r);
    return r;
  }

  // [annotatedids]
  private static boolean recover_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [cap]
  private static boolean recover_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_2")) return false;
    cap(b, l + 1);
    return true;
  }

  // [param_ref]
  private static boolean recover_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_3")) return false;
    param_ref(b, l + 1);
    return true;
  }

  // [typeparams]
  private static boolean recover_def_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_4")) return false;
    typeparams(b, l + 1);
    return true;
  }

  // [lambdaparams]
  private static boolean recover_def_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_6")) return false;
    lambdaparams(b, l + 1);
    return true;
  }

  // [lambdacaptures]
  private static boolean recover_def_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_8")) return false;
    lambdacaptures(b, l + 1);
    return true;
  }

  // [COLON type]
  private static boolean recover_def_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_9")) return false;
    recover_def_9_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean recover_def_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [QM]
  private static boolean recover_def_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_10")) return false;
    consumeToken(b, QM);
    return true;
  }

  // [cap]
  private static boolean recover_def_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_def_14")) return false;
    cap(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IFDEF [annotatedids] infix THEN rawseq [elifdef | (ELSE annotatedrawseq)] END
  //   | IFTYPE [annotatedids] istype [eliftype | (ELSE annotatedrawseq)] END
  //   | REPEAT [annotatedids] rawseq UNTIL annotatedrawseq [ELSE annotatedrawseq] END
  //   | WITH [annotatedids] withelem (COMMA withelem)* DO rawseq END
  //   | RECOVER [annotatedids] [cap] rawseq END
  public static boolean resourceblock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESOURCEBLOCK, "<resourceblock>");
    r = resourceblock_0(b, l + 1);
    if (!r) r = resourceblock_1(b, l + 1);
    if (!r) r = resourceblock_2(b, l + 1);
    if (!r) r = resourceblock_3(b, l + 1);
    if (!r) r = resourceblock_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IFDEF [annotatedids] infix THEN rawseq [elifdef | (ELSE annotatedrawseq)] END
  private static boolean resourceblock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IFDEF);
    r = r && resourceblock_0_1(b, l + 1);
    r = r && infix(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && rawseq(b, l + 1);
    r = r && resourceblock_0_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // [annotatedids]
  private static boolean resourceblock_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_0_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [elifdef | (ELSE annotatedrawseq)]
  private static boolean resourceblock_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_0_5")) return false;
    resourceblock_0_5_0(b, l + 1);
    return true;
  }

  // elifdef | (ELSE annotatedrawseq)
  private static boolean resourceblock_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elifdef(b, l + 1);
    if (!r) r = resourceblock_0_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean resourceblock_0_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_0_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IFTYPE [annotatedids] istype [eliftype | (ELSE annotatedrawseq)] END
  private static boolean resourceblock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IFTYPE);
    r = r && resourceblock_1_1(b, l + 1);
    r = r && istype(b, l + 1);
    r = r && resourceblock_1_3(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // [annotatedids]
  private static boolean resourceblock_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_1_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [eliftype | (ELSE annotatedrawseq)]
  private static boolean resourceblock_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_1_3")) return false;
    resourceblock_1_3_0(b, l + 1);
    return true;
  }

  // eliftype | (ELSE annotatedrawseq)
  private static boolean resourceblock_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eliftype(b, l + 1);
    if (!r) r = resourceblock_1_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE annotatedrawseq
  private static boolean resourceblock_1_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_1_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // REPEAT [annotatedids] rawseq UNTIL annotatedrawseq [ELSE annotatedrawseq] END
  private static boolean resourceblock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPEAT);
    r = r && resourceblock_2_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, UNTIL);
    r = r && annotatedrawseq(b, l + 1);
    r = r && resourceblock_2_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // [annotatedids]
  private static boolean resourceblock_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_2_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [ELSE annotatedrawseq]
  private static boolean resourceblock_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_2_5")) return false;
    resourceblock_2_5_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean resourceblock_2_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_2_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WITH [annotatedids] withelem (COMMA withelem)* DO rawseq END
  private static boolean resourceblock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITH);
    r = r && resourceblock_3_1(b, l + 1);
    r = r && withelem(b, l + 1);
    r = r && resourceblock_3_3(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // [annotatedids]
  private static boolean resourceblock_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_3_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // (COMMA withelem)*
  private static boolean resourceblock_3_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_3_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!resourceblock_3_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "resourceblock_3_3", c)) break;
    }
    return true;
  }

  // COMMA withelem
  private static boolean resourceblock_3_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_3_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && withelem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RECOVER [annotatedids] [cap] rawseq END
  private static boolean resourceblock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RECOVER);
    r = r && resourceblock_4_1(b, l + 1);
    r = r && resourceblock_4_2(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // [annotatedids]
  private static boolean resourceblock_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_4_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [cap]
  private static boolean resourceblock_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resourceblock_4_2")) return false;
    cap(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // AND | OR  | XOR | ADD | SUB | MUL
  //   | DIV | REM | MOD | SHL | SHR | EQ
  //   | NEQ | LT  | LEQ | GEQ | GT
  public static boolean safeop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "safeop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SAFEOP, "<safeop>");
    r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, XOR);
    if (!r) r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, REM);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, SHL);
    if (!r) r = consumeToken(b, SHR);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NEQ);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, LEQ);
    if (!r) r = consumeToken(b, GEQ);
    if (!r) r = consumeToken(b, GT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SEMI (exprseq | jump)
  public static boolean semiexpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semiexpr")) return false;
    if (!nextTokenIs(b, SEMI)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    r = r && semiexpr_1(b, l + 1);
    exit_section_(b, m, SEMIEXPR, r);
    return r;
  }

  // exprseq | jump
  private static boolean semiexpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semiexpr_1")) return false;
    boolean r;
    r = exprseq(b, l + 1);
    if (!r) r = jump(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // string | doc_string
  public static boolean stringliteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringliteral")) return false;
    if (!nextTokenIs(b, "<stringliteral>", DOC_STRING, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRINGLITERAL, "<stringliteral>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, DOC_STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // controlblock
  //   | resourceblock
  //   | binding term_ref [COLON type]
  //   | postfixop* postfix
  //   | CONSUME [cap] term
  //   | HASH postfix
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = controlblock(b, l + 1);
    if (!r) r = resourceblock(b, l + 1);
    if (!r) r = term_2(b, l + 1);
    if (!r) r = term_3(b, l + 1);
    if (!r) r = term_4(b, l + 1);
    if (!r) r = term_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // binding term_ref [COLON type]
  private static boolean term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binding(b, l + 1);
    r = r && term_ref(b, l + 1);
    r = r && term_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COLON type]
  private static boolean term_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_2")) return false;
    term_2_2_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean term_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // postfixop* postfix
  private static boolean term_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = term_3_0(b, l + 1);
    r = r && postfix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // postfixop*
  private static boolean term_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!postfixop(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "term_3_0", c)) break;
    }
    return true;
  }

  // CONSUME [cap] term
  private static boolean term_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSUME);
    r = r && term_4_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [cap]
  private static boolean term_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_4_1")) return false;
    cap(b, l + 1);
    return true;
  }

  // HASH postfix
  private static boolean term_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HASH);
    r = r && postfix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id | SCORE
  public static boolean term_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_ref")) return false;
    if (!nextTokenIs(b, "<term ref>", ID, SCORE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM_REF, "<term ref>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, SCORE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TILDE member_ref
  public static boolean tilde_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tilde_id")) return false;
    if (!nextTokenIs(b, TILDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TILDE);
    r = r && member_ref(b, l + 1);
    exit_section_(b, m, TILDE_ID, r);
    return r;
  }

  /* ********************************************************** */
  // TRY [annotatedids] rawseq [ELSE annotatedrawseq] [THEN annotatedrawseq] END
  public static boolean tryblock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryblock")) return false;
    if (!nextTokenIs(b, TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY);
    r = r && tryblock_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && tryblock_3(b, l + 1);
    r = r && tryblock_4(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, TRYBLOCK, r);
    return r;
  }

  // [annotatedids]
  private static boolean tryblock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryblock_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [ELSE annotatedrawseq]
  private static boolean tryblock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryblock_3")) return false;
    tryblock_3_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean tryblock_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryblock_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [THEN annotatedrawseq]
  private static boolean tryblock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryblock_4")) return false;
    tryblock_4_0(b, l + 1);
    return true;
  }

  // THEN annotatedrawseq
  private static boolean tryblock_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryblock_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THEN);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMA rawseq (COMMA rawseq)*
  public static boolean tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple")) return false;
    if (!nextTokenIs(b, COMMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && rawseq(b, l + 1);
    r = r && tuple_2(b, l + 1);
    exit_section_(b, m, TUPLE, r);
    return r;
  }

  // (COMMA rawseq)*
  private static boolean tuple_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuple_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_2", c)) break;
    }
    return true;
  }

  // COMMA rawseq
  private static boolean tuple_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && rawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMA infixtype (COMMA infixtype)*
  public static boolean tupletype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupletype")) return false;
    if (!nextTokenIs(b, COMMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && infixtype(b, l + 1);
    r = r && tupletype_2(b, l + 1);
    exit_section_(b, m, TUPLETYPE, r);
    return r;
  }

  // (COMMA infixtype)*
  private static boolean tupletype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupletype_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tupletype_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tupletype_2", c)) break;
    }
    return true;
  }

  // COMMA infixtype
  private static boolean tupletype_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tupletype_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && infixtype(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atomtype [TYPE_ARROW type]
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = atomtype(b, l + 1);
    r = r && type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [TYPE_ARROW type]
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    type_1_0(b, l + 1);
    return true;
  }

  // TYPE_ARROW type
  private static boolean type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_ARROW);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type_id
  public static boolean type_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ref")) return false;
    if (!nextTokenIs(b, TYPE_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_ID);
    exit_section_(b, m, TYPE_REF, r);
    return r;
  }

  /* ********************************************************** */
  // type
  //   | literal
  //   | HASH postfix
  public static boolean typearg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typearg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPEARG, "<typearg>");
    r = type(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = typearg_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // HASH postfix
  private static boolean typearg_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typearg_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HASH);
    r = r && postfix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBK typearg (COMMA typearg)* RBK
  public static boolean typeargs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeargs")) return false;
    if (!nextTokenIs(b, LBK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBK);
    r = r && typearg(b, l + 1);
    r = r && typeargs_2(b, l + 1);
    r = r && consumeToken(b, RBK);
    exit_section_(b, m, TYPEARGS, r);
    return r;
  }

  // (COMMA typearg)*
  private static boolean typeargs_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeargs_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeargs_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeargs_2", c)) break;
    }
    return true;
  }

  // COMMA typearg
  private static boolean typeargs_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeargs_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && typearg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (type_ref) [COLON type] [EQUALS typearg]
  public static boolean typeparam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam")) return false;
    if (!nextTokenIs(b, TYPE_ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeparam_0(b, l + 1);
    r = r && typeparam_1(b, l + 1);
    r = r && typeparam_2(b, l + 1);
    exit_section_(b, m, TYPEPARAM, r);
    return r;
  }

  // (type_ref)
  private static boolean typeparam_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_ref(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COLON type]
  private static boolean typeparam_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_1")) return false;
    typeparam_1_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean typeparam_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [EQUALS typearg]
  private static boolean typeparam_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_2")) return false;
    typeparam_2_0(b, l + 1);
    return true;
  }

  // EQUALS typearg
  private static boolean typeparam_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparam_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && typearg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBK typeparam (COMMA typeparam)* RBK
  public static boolean typeparams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams")) return false;
    if (!nextTokenIs(b, LBK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBK);
    r = r && typeparam(b, l + 1);
    r = r && typeparams_2(b, l + 1);
    r = r && consumeToken(b, RBK);
    exit_section_(b, m, TYPEPARAMS, r);
    return r;
  }

  // (COMMA typeparam)*
  private static boolean typeparams_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeparams_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeparams_2", c)) break;
    }
    return true;
  }

  // COMMA typeparam
  private static boolean typeparams_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeparams_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && typeparam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PIPE type
  public static boolean uniontype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uniontype")) return false;
    if (!nextTokenIs(b, PIPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && type(b, l + 1);
    exit_section_(b, m, UNIONTYPE, r);
    return r;
  }

  /* ********************************************************** */
  // ADD_UNSAFE | SUB_UNSAFE | MUL_UNSAFE
  //   | DIV_UNSAFE | REM_UNSAFE | MOD_UNSAFE
  //   | SHL_UNSAFE | SHR_UNSAFE | EQ_UNSAFE
  //   | NEQ_UNSAFE | LT_UNSAFE  | LEQ_UNSAFE
  //   | GT_UNSAFE  | GEQ_UNSAFE
  public static boolean unsafeop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unsafeop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNSAFEOP, "<unsafeop>");
    r = consumeToken(b, ADD_UNSAFE);
    if (!r) r = consumeToken(b, SUB_UNSAFE);
    if (!r) r = consumeToken(b, MUL_UNSAFE);
    if (!r) r = consumeToken(b, DIV_UNSAFE);
    if (!r) r = consumeToken(b, REM_UNSAFE);
    if (!r) r = consumeToken(b, MOD_UNSAFE);
    if (!r) r = consumeToken(b, SHL_UNSAFE);
    if (!r) r = consumeToken(b, SHR_UNSAFE);
    if (!r) r = consumeToken(b, EQ_UNSAFE);
    if (!r) r = consumeToken(b, NEQ_UNSAFE);
    if (!r) r = consumeToken(b, LT_UNSAFE);
    if (!r) r = consumeToken(b, LEQ_UNSAFE);
    if (!r) r = consumeToken(b, GT_UNSAFE);
    if (!r) r = consumeToken(b, GEQ_UNSAFE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AT id_ffi typeargs LP [params] RP [QM]
  public static boolean use_ffi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && id_ffi(b, l + 1);
    r = r && typeargs(b, l + 1);
    r = r && consumeToken(b, LP);
    r = r && use_ffi_4(b, l + 1);
    r = r && consumeToken(b, RP);
    r = r && use_ffi_6(b, l + 1);
    exit_section_(b, m, USE_FFI, r);
    return r;
  }

  // [params]
  private static boolean use_ffi_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi_4")) return false;
    params(b, l + 1);
    return true;
  }

  // [QM]
  private static boolean use_ffi_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_ffi_6")) return false;
    consumeToken(b, QM);
    return true;
  }

  /* ********************************************************** */
  // USE [id EQUALS] (string | use_ffi) [IF infix]
  public static boolean usestmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usestmt")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, USE);
    r = r && usestmt_1(b, l + 1);
    r = r && usestmt_2(b, l + 1);
    r = r && usestmt_3(b, l + 1);
    exit_section_(b, m, USESTMT, r);
    return r;
  }

  // [id EQUALS]
  private static boolean usestmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usestmt_1")) return false;
    parseTokens(b, 0, ID, EQUALS);
    return true;
  }

  // string | use_ffi
  private static boolean usestmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usestmt_2")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = use_ffi(b, l + 1);
    return r;
  }

  // [IF infix]
  private static boolean usestmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usestmt_3")) return false;
    usestmt_3_0(b, l + 1);
    return true;
  }

  // IF infix
  private static boolean usestmt_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usestmt_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && infix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE [annotatedids] rawseq DO rawseq [ELSE annotatedrawseq] END
  public static boolean whileloop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileloop")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && whileloop_1(b, l + 1);
    r = r && rawseq(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && rawseq(b, l + 1);
    r = r && whileloop_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, WHILELOOP, r);
    return r;
  }

  // [annotatedids]
  private static boolean whileloop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileloop_1")) return false;
    annotatedids(b, l + 1);
    return true;
  }

  // [ELSE annotatedrawseq]
  private static boolean whileloop_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileloop_5")) return false;
    whileloop_5_0(b, l + 1);
    return true;
  }

  // ELSE annotatedrawseq
  private static boolean whileloop_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileloop_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && annotatedrawseq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // idseq EQUALS rawseq
  public static boolean withelem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withelem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WITHELEM, "<withelem>");
    r = idseq(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && rawseq(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
