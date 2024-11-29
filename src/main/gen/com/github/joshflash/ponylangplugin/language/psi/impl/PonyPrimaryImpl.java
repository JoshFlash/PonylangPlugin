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
  public PonyExpression getExpression() {
    return findChildByClass(PonyExpression.class);
  }

  @Override
  @Nullable
  public PonyLiteral getLiteral() {
    return findChildByClass(PonyLiteral.class);
  }

  @Override
  @Nullable
  public PonyQualifiedIdentifier getQualifiedIdentifier() {
    return findChildByClass(PonyQualifiedIdentifier.class);
  }

}
