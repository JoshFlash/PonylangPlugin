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

public class PonyParticleImpl extends ASTWrapperPsiElement implements PonyParticle {

  public PonyParticleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitParticle(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyAnnotatedids getAnnotatedids() {
    return findChildByClass(PonyAnnotatedids.class);
  }

  @Override
  @Nullable
  public PonyCap getCap() {
    return findChildByClass(PonyCap.class);
  }

  @Override
  @Nullable
  public PonyIdRef getIdRef() {
    return findChildByClass(PonyIdRef.class);
  }

  @Override
  @Nullable
  public PonyLambdacaptures getLambdacaptures() {
    return findChildByClass(PonyLambdacaptures.class);
  }

  @Override
  @Nullable
  public PonyLambdaparams getLambdaparams() {
    return findChildByClass(PonyLambdaparams.class);
  }

  @Override
  @Nullable
  public PonyLiteral getLiteral() {
    return findChildByClass(PonyLiteral.class);
  }

  @Override
  @Nullable
  public PonyMembers getMembers() {
    return findChildByClass(PonyMembers.class);
  }

  @Override
  @Nullable
  public PonyNamed getNamed() {
    return findChildByClass(PonyNamed.class);
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
  public PonyStringliteral getStringliteral() {
    return findChildByClass(PonyStringliteral.class);
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
  public PonyTypeparams getTypeparams() {
    return findChildByClass(PonyTypeparams.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

  @Override
  @Nullable
  public PsiElement getTypeId() {
    return findChildByType(TYPE_ID);
  }

}
