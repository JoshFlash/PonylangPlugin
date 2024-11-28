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

public class PonyMatchExprImpl extends ASTWrapperPsiElement implements PonyMatchExpr {

  public PonyMatchExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitMatchExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PonyExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyExpr.class);
  }

  @Override
  @NotNull
  public List<PonyMatchCase> getMatchCaseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyMatchCase.class);
  }

}
