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

public class PonyMethodImpl extends ASTWrapperPsiElement implements PonyMethod {

  public PonyMethodImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitMethod(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyCapability getCapability() {
    return findChildByClass(PonyCapability.class);
  }

  @Override
  @Nullable
  public PonyDocString getDocString() {
    return findChildByClass(PonyDocString.class);
  }

  @Override
  @Nullable
  public PonyExpr getExpr() {
    return findChildByClass(PonyExpr.class);
  }

  @Override
  @Nullable
  public PonyMethodModifier getMethodModifier() {
    return findChildByClass(PonyMethodModifier.class);
  }

  @Override
  @NotNull
  public PonyParamList getParamList() {
    return findNotNullChildByClass(PonyParamList.class);
  }

  @Override
  @Nullable
  public PonyTypeExpr getTypeExpr() {
    return findChildByClass(PonyTypeExpr.class);
  }

  @Override
  @Nullable
  public PonyTypeParams getTypeParams() {
    return findChildByClass(PonyTypeParams.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
