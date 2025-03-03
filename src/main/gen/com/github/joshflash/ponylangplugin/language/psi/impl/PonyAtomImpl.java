// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.joshflash.ponylangplugin.language.psi.PonyTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.joshflash.ponylangplugin.language.psi.*;

public class PonyAtomImpl extends ASTWrapperPsiElement implements PonyAtom {

  public PonyAtomImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitAtom(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyForloop getForloop() {
    return findChildByClass(PonyForloop.class);
  }

  @Override
  @Nullable
  public PonyFunDef getFunDef() {
    return findChildByClass(PonyFunDef.class);
  }

  @Override
  @Nullable
  public PonyIdFfi getIdFfi() {
    return findChildByClass(PonyIdFfi.class);
  }

  @Override
  @Nullable
  public PonyIdVar getIdVar() {
    return findChildByClass(PonyIdVar.class);
  }

  @Override
  @Nullable
  public PonyIfblock getIfblock() {
    return findChildByClass(PonyIfblock.class);
  }

  @Override
  @Nullable
  public PonyLiteral getLiteral() {
    return findChildByClass(PonyLiteral.class);
  }

  @Override
  @Nullable
  public PonyNamed getNamed() {
    return findChildByClass(PonyNamed.class);
  }

  @Override
  @Nullable
  public PonyObjectDef getObjectDef() {
    return findChildByClass(PonyObjectDef.class);
  }

  @Override
  @Nullable
  public PonyPositional getPositional() {
    return findChildByClass(PonyPositional.class);
  }

  @Override
  @Nullable
  public PonyRawseq getRawseq() {
    return findChildByClass(PonyRawseq.class);
  }

  @Override
  @Nullable
  public PonyRecoverDef getRecoverDef() {
    return findChildByClass(PonyRecoverDef.class);
  }

  @Override
  @Nullable
  public PonyTuple getTuple() {
    return findChildByClass(PonyTuple.class);
  }

  @Override
  @Nullable
  public PonyType getType() {
    return findChildByClass(PonyType.class);
  }

  @Override
  @Nullable
  public PonyTypeRef getTypeRef() {
    return findChildByClass(PonyTypeRef.class);
  }

  @Override
  @Nullable
  public PonyTypeargs getTypeargs() {
    return findChildByClass(PonyTypeargs.class);
  }

  @Override
  @Nullable
  public PonyWhileloop getWhileloop() {
    return findChildByClass(PonyWhileloop.class);
  }

}
