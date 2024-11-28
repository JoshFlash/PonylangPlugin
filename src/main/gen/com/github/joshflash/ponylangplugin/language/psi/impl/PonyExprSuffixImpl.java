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

public class PonyExprSuffixImpl extends ASTWrapperPsiElement implements PonyExprSuffix {

  public PonyExprSuffixImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitExprSuffix(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyBinaryOp getBinaryOp() {
    return findChildByClass(PonyBinaryOp.class);
  }

  @Override
  @Nullable
  public PonyCallArgs getCallArgs() {
    return findChildByClass(PonyCallArgs.class);
  }

  @Override
  @Nullable
  public PonyDotAccess getDotAccess() {
    return findChildByClass(PonyDotAccess.class);
  }

  @Override
  @Nullable
  public PonyExpr getExpr() {
    return findChildByClass(PonyExpr.class);
  }

}
