// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.joshflash.ponylangplugin.language.psi.impl.*;

public interface PonyTypes {

  IElementType ANNOTATEDIDS = new PonyElementType("ANNOTATEDIDS");
  IElementType ANNOTATEDRAWSEQ = new PonyElementType("ANNOTATEDRAWSEQ");
  IElementType ASSIGNMENT = new PonyElementType("ASSIGNMENT");
  IElementType ATOM = new PonyElementType("ATOM");
  IElementType ATOMTYPE = new PonyElementType("ATOMTYPE");
  IElementType BARELAMBDATYPE = new PonyElementType("BARELAMBDATYPE");
  IElementType BINDIGIT = new PonyElementType("BINDIGIT");
  IElementType BINDING = new PonyElementType("BINDING");
  IElementType BINOP = new PonyElementType("BINOP");
  IElementType CALL = new PonyElementType("CALL");
  IElementType CAP = new PonyElementType("CAP");
  IElementType CASEATOM = new PonyElementType("CASEATOM");
  IElementType CASEEXPR = new PonyElementType("CASEEXPR");
  IElementType CASEPARAMPATTERN = new PonyElementType("CASEPARAMPATTERN");
  IElementType CASEPATTERN = new PonyElementType("CASEPATTERN");
  IElementType CASEPOSTFIX = new PonyElementType("CASEPOSTFIX");
  IElementType CHAIN_ID = new PonyElementType("CHAIN_ID");
  IElementType CLASS_DEF = new PonyElementType("CLASS_DEF");
  IElementType CONSTRUCT = new PonyElementType("CONSTRUCT");
  IElementType DECLARATION = new PonyElementType("DECLARATION");
  IElementType DOT_ID = new PonyElementType("DOT_ID");
  IElementType ELIF = new PonyElementType("ELIF");
  IElementType ELIFDEF = new PonyElementType("ELIFDEF");
  IElementType ELIFTYPE = new PonyElementType("ELIFTYPE");
  IElementType EXPONENT = new PonyElementType("EXPONENT");
  IElementType EXPRSEQ = new PonyElementType("EXPRSEQ");
  IElementType FIELD = new PonyElementType("FIELD");
  IElementType FLOAT = new PonyElementType("FLOAT");
  IElementType FORLOOP = new PonyElementType("FORLOOP");
  IElementType HEXDIGIT = new PonyElementType("HEXDIGIT");
  IElementType HEXLETTER = new PonyElementType("HEXLETTER");
  IElementType IDSEQ = new PonyElementType("IDSEQ");
  IElementType IDSEQ_IN_SEQ = new PonyElementType("IDSEQ_IN_SEQ");
  IElementType IFBLOCK = new PonyElementType("IFBLOCK");
  IElementType INFIX = new PonyElementType("INFIX");
  IElementType INFIXOP = new PonyElementType("INFIXOP");
  IElementType INFIXTYPE = new PonyElementType("INFIXTYPE");
  IElementType INT = new PonyElementType("INT");
  IElementType ISECTTYPE = new PonyElementType("ISECTTYPE");
  IElementType ISOP = new PonyElementType("ISOP");
  IElementType ISTYPE = new PonyElementType("ISTYPE");
  IElementType JUMP = new PonyElementType("JUMP");
  IElementType LAMBDACAPTURE = new PonyElementType("LAMBDACAPTURE");
  IElementType LAMBDACAPTURES = new PonyElementType("LAMBDACAPTURES");
  IElementType LAMBDAPARAM = new PonyElementType("LAMBDAPARAM");
  IElementType LAMBDAPARAMS = new PonyElementType("LAMBDAPARAMS");
  IElementType LAMBDATYPE = new PonyElementType("LAMBDATYPE");
  IElementType LITERAL = new PonyElementType("LITERAL");
  IElementType MEMBERS = new PonyElementType("MEMBERS");
  IElementType METHOD = new PonyElementType("METHOD");
  IElementType NAMED = new PonyElementType("NAMED");
  IElementType NAMEDARG = new PonyElementType("NAMEDARG");
  IElementType NEXTASSIGNMENT = new PonyElementType("NEXTASSIGNMENT");
  IElementType NEXTATOM = new PonyElementType("NEXTATOM");
  IElementType NEXTEXPRSEQ = new PonyElementType("NEXTEXPRSEQ");
  IElementType NEXTINFIX = new PonyElementType("NEXTINFIX");
  IElementType NEXTPARAMPATTERN = new PonyElementType("NEXTPARAMPATTERN");
  IElementType NEXTPATTERN = new PonyElementType("NEXTPATTERN");
  IElementType NEXTPOSTFIX = new PonyElementType("NEXTPOSTFIX");
  IElementType NEXTTERM = new PonyElementType("NEXTTERM");
  IElementType NOMINAL = new PonyElementType("NOMINAL");
  IElementType NOSEMI = new PonyElementType("NOSEMI");
  IElementType PARAM = new PonyElementType("PARAM");
  IElementType PARAMPATTERN = new PonyElementType("PARAMPATTERN");
  IElementType PARAMS = new PonyElementType("PARAMS");
  IElementType PARTIALOP = new PonyElementType("PARTIALOP");
  IElementType PARTICLE = new PonyElementType("PARTICLE");
  IElementType PATTERN = new PonyElementType("PATTERN");
  IElementType POSITIONAL = new PonyElementType("POSITIONAL");
  IElementType POSTFIX = new PonyElementType("POSTFIX");
  IElementType POSTFIXELEM = new PonyElementType("POSTFIXELEM");
  IElementType RAWSEQ = new PonyElementType("RAWSEQ");
  IElementType SAFEOP = new PonyElementType("SAFEOP");
  IElementType SEMIEXPR = new PonyElementType("SEMIEXPR");
  IElementType TERM = new PonyElementType("TERM");
  IElementType TILDE_ID = new PonyElementType("TILDE_ID");
  IElementType TUPLE = new PonyElementType("TUPLE");
  IElementType TUPLETYPE = new PonyElementType("TUPLETYPE");
  IElementType TYPE = new PonyElementType("TYPE");
  IElementType TYPEARG = new PonyElementType("TYPEARG");
  IElementType TYPEARGS = new PonyElementType("TYPEARGS");
  IElementType TYPEPARAM = new PonyElementType("TYPEPARAM");
  IElementType TYPEPARAMS = new PonyElementType("TYPEPARAMS");
  IElementType TYPE_REF = new PonyElementType("TYPE_REF");
  IElementType UNIONTYPE = new PonyElementType("UNIONTYPE");
  IElementType UNSAFEOP = new PonyElementType("UNSAFEOP");
  IElementType USESTMT = new PonyElementType("USESTMT");
  IElementType USE_FFI = new PonyElementType("USE_FFI");
  IElementType WHILELOOP = new PonyElementType("WHILELOOP");
  IElementType WITHELEM = new PonyElementType("WITHELEM");

  IElementType ACTOR = new PonyTokenType("actor");
  IElementType ADD = new PonyTokenType("+");
  IElementType ADDRESSOF = new PonyTokenType("addressof");
  IElementType ADD_PARTIAL = new PonyTokenType("+?");
  IElementType ADD_UNSAFE = new PonyTokenType("+~");
  IElementType AMP = new PonyTokenType("&");
  IElementType AND = new PonyTokenType("and");
  IElementType ARROW = new PonyTokenType("=>");
  IElementType AS = new PonyTokenType("as");
  IElementType AT = new PonyTokenType("@");
  IElementType BANG = new PonyTokenType("!");
  IElementType BE = new PonyTokenType("be");
  IElementType BEGIN_COMMENT = new PonyTokenType("/*");
  IElementType BOX = new PonyTokenType("box");
  IElementType BREAK = new PonyTokenType("break");
  IElementType CARET = new PonyTokenType("^");
  IElementType CHAIN = new PonyTokenType(".>");
  IElementType CLASS = new PonyTokenType("class");
  IElementType COLON = new PonyTokenType(":");
  IElementType COMMA = new PonyTokenType(",");
  IElementType COMP_ERR = new PonyTokenType("compile_error");
  IElementType COMP_INT = new PonyTokenType("compile_intrinsic");
  IElementType CONSUME = new PonyTokenType("consume");
  IElementType CONTINUE = new PonyTokenType("continue");
  IElementType DIGESTOF = new PonyTokenType("digestof");
  IElementType DIGIT = new PonyTokenType("digit");
  IElementType DIV = new PonyTokenType("/");
  IElementType DIV_PARTIAL = new PonyTokenType("/?");
  IElementType DIV_UNSAFE = new PonyTokenType("/~");
  IElementType DO = new PonyTokenType("do");
  IElementType DOT = new PonyTokenType(".");
  IElementType ELIPSIS = new PonyTokenType("...");
  IElementType ELSE = new PonyTokenType("else");
  IElementType ELSEIF = new PonyTokenType("elseif");
  IElementType EMBED = new PonyTokenType("embed");
  IElementType END = new PonyTokenType("end");
  IElementType END_COMMENT = new PonyTokenType("*/");
  IElementType EQ = new PonyTokenType("==");
  IElementType EQUALS = new PonyTokenType("=");
  IElementType EQ_UNSAFE = new PonyTokenType("==~");
  IElementType ERROR = new PonyTokenType("error");
  IElementType FALSE = new PonyTokenType("false");
  IElementType FOR = new PonyTokenType("for");
  IElementType FUN = new PonyTokenType("fun");
  IElementType GENCAP = new PonyTokenType("gencap");
  IElementType GEQ = new PonyTokenType(">=");
  IElementType GEQ_UNSAFE = new PonyTokenType(">=~");
  IElementType GT = new PonyTokenType(">");
  IElementType GT_UNSAFE = new PonyTokenType(">~");
  IElementType HASH = new PonyTokenType("#");
  IElementType ID = new PonyTokenType("id");
  IElementType IF = new PonyTokenType("if");
  IElementType IFDEF = new PonyTokenType("ifdef");
  IElementType IFTYPE = new PonyTokenType("iftype");
  IElementType IN = new PonyTokenType("in");
  IElementType INTERFACE = new PonyTokenType("interface");
  IElementType IS = new PonyTokenType("is");
  IElementType ISA = new PonyTokenType("<:");
  IElementType ISNT = new PonyTokenType("isnt");
  IElementType ISO = new PonyTokenType("iso");
  IElementType LBC = new PonyTokenType("{");
  IElementType LBK = new PonyTokenType("[");
  IElementType LEQ = new PonyTokenType("<=");
  IElementType LEQ_UNSAFE = new PonyTokenType("<=~");
  IElementType LET = new PonyTokenType("let");
  IElementType LINE_COMMENT = new PonyTokenType("line_comment");
  IElementType LP = new PonyTokenType("(");
  IElementType LT = new PonyTokenType("<");
  IElementType LT_UNSAFE = new PonyTokenType("<~");
  IElementType MATCH = new PonyTokenType("match");
  IElementType MOD = new PonyTokenType("%%");
  IElementType MOD_PARTIAL = new PonyTokenType("%%?");
  IElementType MOD_UNSAFE = new PonyTokenType("%%~");
  IElementType MUL = new PonyTokenType("*");
  IElementType MUL_PARTIAL = new PonyTokenType("*?");
  IElementType MUL_UNSAFE = new PonyTokenType("*~");
  IElementType NEQ = new PonyTokenType("!=");
  IElementType NEQ_UNSAFE = new PonyTokenType("!=~");
  IElementType NEW = new PonyTokenType("new");
  IElementType NEWLINE = new PonyTokenType("newline");
  IElementType NOT = new PonyTokenType("not");
  IElementType OBJECT = new PonyTokenType("object");
  IElementType OR = new PonyTokenType("or");
  IElementType PIPE = new PonyTokenType("|");
  IElementType PRIMITIVE = new PonyTokenType("primitive");
  IElementType QM = new PonyTokenType("?");
  IElementType RBC = new PonyTokenType("}");
  IElementType RBK = new PonyTokenType("]");
  IElementType RCVR = new PonyTokenType("@{");
  IElementType RECOVER = new PonyTokenType("recover");
  IElementType REF = new PonyTokenType("ref");
  IElementType REM = new PonyTokenType("%");
  IElementType REM_PARTIAL = new PonyTokenType("%?");
  IElementType REM_UNSAFE = new PonyTokenType("%~");
  IElementType REPEAT = new PonyTokenType("repeat");
  IElementType RETURN = new PonyTokenType("return");
  IElementType RP = new PonyTokenType(")");
  IElementType SEMI = new PonyTokenType(";");
  IElementType SHL = new PonyTokenType("<<");
  IElementType SHL_UNSAFE = new PonyTokenType("<<~");
  IElementType SHR = new PonyTokenType(">>");
  IElementType SHR_UNSAFE = new PonyTokenType(">>~");
  IElementType SOURCELOC = new PonyTokenType("__loc");
  IElementType STRING = new PonyTokenType("string");
  IElementType STRUCT = new PonyTokenType("struct");
  IElementType SUB = new PonyTokenType("-");
  IElementType SUB_PARTIAL = new PonyTokenType("-?");
  IElementType SUB_UNSAFE = new PonyTokenType("-~");
  IElementType TAG = new PonyTokenType("tag");
  IElementType THEN = new PonyTokenType("then");
  IElementType THIS = new PonyTokenType("this");
  IElementType TILDE = new PonyTokenType("~");
  IElementType TRAIT = new PonyTokenType("trait");
  IElementType TRN = new PonyTokenType("trn");
  IElementType TRUE = new PonyTokenType("true");
  IElementType TRY = new PonyTokenType("try");
  IElementType TYPEDEF = new PonyTokenType("type");
  IElementType TYPE_ARROW = new PonyTokenType("->");
  IElementType TYPE_ID = new PonyTokenType("type_id");
  IElementType UNTIL = new PonyTokenType("until");
  IElementType USE = new PonyTokenType("use");
  IElementType VAL = new PonyTokenType("val");
  IElementType VAR = new PonyTokenType("var");
  IElementType WHERE = new PonyTokenType("where");
  IElementType WHILE = new PonyTokenType("while");
  IElementType WITH = new PonyTokenType("with");
  IElementType XOR = new PonyTokenType("xor");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATEDIDS) {
        return new PonyAnnotatedidsImpl(node);
      }
      else if (type == ANNOTATEDRAWSEQ) {
        return new PonyAnnotatedrawseqImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new PonyAssignmentImpl(node);
      }
      else if (type == ATOM) {
        return new PonyAtomImpl(node);
      }
      else if (type == ATOMTYPE) {
        return new PonyAtomtypeImpl(node);
      }
      else if (type == BARELAMBDATYPE) {
        return new PonyBarelambdatypeImpl(node);
      }
      else if (type == BINDIGIT) {
        return new PonyBindigitImpl(node);
      }
      else if (type == BINDING) {
        return new PonyBindingImpl(node);
      }
      else if (type == BINOP) {
        return new PonyBinopImpl(node);
      }
      else if (type == CALL) {
        return new PonyCallImpl(node);
      }
      else if (type == CAP) {
        return new PonyCapImpl(node);
      }
      else if (type == CASEATOM) {
        return new PonyCaseatomImpl(node);
      }
      else if (type == CASEEXPR) {
        return new PonyCaseexprImpl(node);
      }
      else if (type == CASEPARAMPATTERN) {
        return new PonyCaseparampatternImpl(node);
      }
      else if (type == CASEPATTERN) {
        return new PonyCasepatternImpl(node);
      }
      else if (type == CASEPOSTFIX) {
        return new PonyCasepostfixImpl(node);
      }
      else if (type == CHAIN_ID) {
        return new PonyChainIdImpl(node);
      }
      else if (type == CLASS_DEF) {
        return new PonyClassDefImpl(node);
      }
      else if (type == CONSTRUCT) {
        return new PonyConstructImpl(node);
      }
      else if (type == DECLARATION) {
        return new PonyDeclarationImpl(node);
      }
      else if (type == DOT_ID) {
        return new PonyDotIdImpl(node);
      }
      else if (type == ELIF) {
        return new PonyElifImpl(node);
      }
      else if (type == ELIFDEF) {
        return new PonyElifdefImpl(node);
      }
      else if (type == ELIFTYPE) {
        return new PonyEliftypeImpl(node);
      }
      else if (type == EXPONENT) {
        return new PonyExponentImpl(node);
      }
      else if (type == EXPRSEQ) {
        return new PonyExprseqImpl(node);
      }
      else if (type == FIELD) {
        return new PonyFieldImpl(node);
      }
      else if (type == FLOAT) {
        return new PonyFloatImpl(node);
      }
      else if (type == FORLOOP) {
        return new PonyForloopImpl(node);
      }
      else if (type == HEXDIGIT) {
        return new PonyHexdigitImpl(node);
      }
      else if (type == HEXLETTER) {
        return new PonyHexletterImpl(node);
      }
      else if (type == IDSEQ) {
        return new PonyIdseqImpl(node);
      }
      else if (type == IDSEQ_IN_SEQ) {
        return new PonyIdseqInSeqImpl(node);
      }
      else if (type == IFBLOCK) {
        return new PonyIfblockImpl(node);
      }
      else if (type == INFIX) {
        return new PonyInfixImpl(node);
      }
      else if (type == INFIXOP) {
        return new PonyInfixopImpl(node);
      }
      else if (type == INFIXTYPE) {
        return new PonyInfixtypeImpl(node);
      }
      else if (type == INT) {
        return new PonyIntImpl(node);
      }
      else if (type == ISECTTYPE) {
        return new PonyIsecttypeImpl(node);
      }
      else if (type == ISOP) {
        return new PonyIsopImpl(node);
      }
      else if (type == ISTYPE) {
        return new PonyIstypeImpl(node);
      }
      else if (type == JUMP) {
        return new PonyJumpImpl(node);
      }
      else if (type == LAMBDACAPTURE) {
        return new PonyLambdacaptureImpl(node);
      }
      else if (type == LAMBDACAPTURES) {
        return new PonyLambdacapturesImpl(node);
      }
      else if (type == LAMBDAPARAM) {
        return new PonyLambdaparamImpl(node);
      }
      else if (type == LAMBDAPARAMS) {
        return new PonyLambdaparamsImpl(node);
      }
      else if (type == LAMBDATYPE) {
        return new PonyLambdatypeImpl(node);
      }
      else if (type == LITERAL) {
        return new PonyLiteralImpl(node);
      }
      else if (type == MEMBERS) {
        return new PonyMembersImpl(node);
      }
      else if (type == METHOD) {
        return new PonyMethodImpl(node);
      }
      else if (type == NAMED) {
        return new PonyNamedImpl(node);
      }
      else if (type == NAMEDARG) {
        return new PonyNamedargImpl(node);
      }
      else if (type == NEXTASSIGNMENT) {
        return new PonyNextassignmentImpl(node);
      }
      else if (type == NEXTATOM) {
        return new PonyNextatomImpl(node);
      }
      else if (type == NEXTEXPRSEQ) {
        return new PonyNextexprseqImpl(node);
      }
      else if (type == NEXTINFIX) {
        return new PonyNextinfixImpl(node);
      }
      else if (type == NEXTPARAMPATTERN) {
        return new PonyNextparampatternImpl(node);
      }
      else if (type == NEXTPATTERN) {
        return new PonyNextpatternImpl(node);
      }
      else if (type == NEXTPOSTFIX) {
        return new PonyNextpostfixImpl(node);
      }
      else if (type == NEXTTERM) {
        return new PonyNexttermImpl(node);
      }
      else if (type == NOMINAL) {
        return new PonyNominalImpl(node);
      }
      else if (type == NOSEMI) {
        return new PonyNosemiImpl(node);
      }
      else if (type == PARAM) {
        return new PonyParamImpl(node);
      }
      else if (type == PARAMPATTERN) {
        return new PonyParampatternImpl(node);
      }
      else if (type == PARAMS) {
        return new PonyParamsImpl(node);
      }
      else if (type == PARTIALOP) {
        return new PonyPartialopImpl(node);
      }
      else if (type == PARTICLE) {
        return new PonyParticleImpl(node);
      }
      else if (type == PATTERN) {
        return new PonyPatternImpl(node);
      }
      else if (type == POSITIONAL) {
        return new PonyPositionalImpl(node);
      }
      else if (type == POSTFIX) {
        return new PonyPostfixImpl(node);
      }
      else if (type == POSTFIXELEM) {
        return new PonyPostfixelemImpl(node);
      }
      else if (type == RAWSEQ) {
        return new PonyRawseqImpl(node);
      }
      else if (type == SAFEOP) {
        return new PonySafeopImpl(node);
      }
      else if (type == SEMIEXPR) {
        return new PonySemiexprImpl(node);
      }
      else if (type == TERM) {
        return new PonyTermImpl(node);
      }
      else if (type == TILDE_ID) {
        return new PonyTildeIdImpl(node);
      }
      else if (type == TUPLE) {
        return new PonyTupleImpl(node);
      }
      else if (type == TUPLETYPE) {
        return new PonyTupletypeImpl(node);
      }
      else if (type == TYPE) {
        return new PonyTypeImpl(node);
      }
      else if (type == TYPEARG) {
        return new PonyTypeargImpl(node);
      }
      else if (type == TYPEARGS) {
        return new PonyTypeargsImpl(node);
      }
      else if (type == TYPEPARAM) {
        return new PonyTypeparamImpl(node);
      }
      else if (type == TYPEPARAMS) {
        return new PonyTypeparamsImpl(node);
      }
      else if (type == TYPE_REF) {
        return new PonyTypeRefImpl(node);
      }
      else if (type == UNIONTYPE) {
        return new PonyUniontypeImpl(node);
      }
      else if (type == UNSAFEOP) {
        return new PonyUnsafeopImpl(node);
      }
      else if (type == USESTMT) {
        return new PonyUsestmtImpl(node);
      }
      else if (type == USE_FFI) {
        return new PonyUseFfiImpl(node);
      }
      else if (type == WHILELOOP) {
        return new PonyWhileloopImpl(node);
      }
      else if (type == WITHELEM) {
        return new PonyWithelemImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
