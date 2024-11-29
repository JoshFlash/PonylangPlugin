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

public class PonyExpressionImpl extends ASTWrapperPsiElement implements PonyExpression {

  public PonyExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitExpression(this);
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
  public PonyFunctionCall getFunctionCall() {
    return findChildByClass(PonyFunctionCall.class);
  }

  @Override
  @Nullable
  public PonyMethodCall getMethodCall() {
    return findChildByClass(PonyMethodCall.class);
  }

  @Override
  @Nullable
  public PonyPrimary getPrimary() {
    return findChildByClass(PonyPrimary.class);
  }

  @Override
  @Nullable
  public PonyTuple getTuple() {
    return findChildByClass(PonyTuple.class);
  }

}
