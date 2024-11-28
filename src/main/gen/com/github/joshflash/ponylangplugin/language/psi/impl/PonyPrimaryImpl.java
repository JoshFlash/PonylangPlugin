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

public class PonyPrimaryImpl extends ASTWrapperPsiElement implements PonyPrimary {

  public PonyPrimaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitPrimary(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyBlock getBlock() {
    return findChildByClass(PonyBlock.class);
  }

  @Override
  @Nullable
  public PonyConsumeExpr getConsumeExpr() {
    return findChildByClass(PonyConsumeExpr.class);
  }

  @Override
  @Nullable
  public PonyExpr getExpr() {
    return findChildByClass(PonyExpr.class);
  }

  @Override
  @Nullable
  public PonyIfExpr getIfExpr() {
    return findChildByClass(PonyIfExpr.class);
  }

  @Override
  @Nullable
  public PonyLiteral getLiteral() {
    return findChildByClass(PonyLiteral.class);
  }

  @Override
  @Nullable
  public PonyMatchExpr getMatchExpr() {
    return findChildByClass(PonyMatchExpr.class);
  }

  @Override
  @Nullable
  public PonyRecoverExpr getRecoverExpr() {
    return findChildByClass(PonyRecoverExpr.class);
  }

  @Override
  @Nullable
  public PonyTryExpr getTryExpr() {
    return findChildByClass(PonyTryExpr.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

}
