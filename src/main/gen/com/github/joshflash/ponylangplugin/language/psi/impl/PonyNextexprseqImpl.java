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

public class PonyNextexprseqImpl extends ASTWrapperPsiElement implements PonyNextexprseq {

  public PonyNextexprseqImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitNextexprseq(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PonyAssignment getAssignment() {
    return findNotNullChildByClass(PonyAssignment.class);
  }

  @Override
  @Nullable
  public PonyNosemi getNosemi() {
    return findChildByClass(PonyNosemi.class);
  }

  @Override
  @Nullable
  public PonySemiexpr getSemiexpr() {
    return findChildByClass(PonySemiexpr.class);
  }

}
