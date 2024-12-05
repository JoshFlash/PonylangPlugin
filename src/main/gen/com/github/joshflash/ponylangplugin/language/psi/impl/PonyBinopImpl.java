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

public class PonyBinopImpl extends ASTWrapperPsiElement implements PonyBinop {

  public PonyBinopImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitBinop(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
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
  @NotNull
  public PonyTerm getTerm() {
    return findNotNullChildByClass(PonyTerm.class);
  }

  @Override
  @Nullable
  public PonyUnsafeop getUnsafeop() {
    return findChildByClass(PonyUnsafeop.class);
  }

}
