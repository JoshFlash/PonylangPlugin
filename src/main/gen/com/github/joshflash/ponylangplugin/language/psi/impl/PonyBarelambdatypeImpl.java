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

public class PonyBarelambdatypeImpl extends ASTWrapperPsiElement implements PonyBarelambdatype {

  public PonyBarelambdatypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitBarelambdatype(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PonyCap> getCapList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyCap.class);
  }

  @Override
  @Nullable
  public PonyIdRef getIdRef() {
    return findChildByClass(PonyIdRef.class);
  }

  @Override
  @NotNull
  public List<PonyType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyType.class);
  }

  @Override
  @Nullable
  public PonyTypeparams getTypeparams() {
    return findChildByClass(PonyTypeparams.class);
  }

  @Override
  @Nullable
  public PsiElement getGencap() {
    return findChildByType(GENCAP);
  }

}
