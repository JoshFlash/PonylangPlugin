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

public class PonyFlaginfixopImpl extends ASTWrapperPsiElement implements PonyFlaginfixop {

  public PonyFlaginfixopImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitFlaginfixop(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyFlagterm getFlagterm() {
    return findChildByClass(PonyFlagterm.class);
  }

  @Override
  @Nullable
  public PonyPartialop getPartialop() {
    return findChildByClass(PonyPartialop.class);
  }

  @Override
  @Nullable
  public PonySafeop getSafeop() {
    return findChildByClass(PonySafeop.class);
  }

  @Override
  @Nullable
  public PonyType getType() {
    return findChildByClass(PonyType.class);
  }

  @Override
  @Nullable
  public PonyUnsafeop getUnsafeop() {
    return findChildByClass(PonyUnsafeop.class);
  }

}
