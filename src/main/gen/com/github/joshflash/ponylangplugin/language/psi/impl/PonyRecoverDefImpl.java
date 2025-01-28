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

public class PonyRecoverDefImpl extends ASTWrapperPsiElement implements PonyRecoverDef {

  public PonyRecoverDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitRecoverDef(this);
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
  @NotNull
  public List<PonyCap> getCapList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyCap.class);
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
  public PonyParamRef getParamRef() {
    return findChildByClass(PonyParamRef.class);
  }

  @Override
  @NotNull
  public PonyRawseq getRawseq() {
    return findNotNullChildByClass(PonyRawseq.class);
  }

  @Override
  @Nullable
  public PonyType getType() {
    return findChildByClass(PonyType.class);
  }

  @Override
  @Nullable
  public PonyTypeparams getTypeparams() {
    return findChildByClass(PonyTypeparams.class);
  }

}
