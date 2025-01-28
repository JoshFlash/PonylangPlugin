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

public class PonyParamImpl extends ASTWrapperPsiElement implements PonyParam {

  public PonyParamImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitParam(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyInfix getInfix() {
    return findChildByClass(PonyInfix.class);
  }

  @Override
  @NotNull
  public PonyParamRef getParamRef() {
    return findNotNullChildByClass(PonyParamRef.class);
  }

  @Override
  @NotNull
  public PonyType getType() {
    return findNotNullChildByClass(PonyType.class);
  }

}
