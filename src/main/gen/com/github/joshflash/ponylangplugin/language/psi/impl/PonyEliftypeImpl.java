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

public class PonyEliftypeImpl extends ASTWrapperPsiElement implements PonyEliftype {

  public PonyEliftypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitEliftype(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyAnnotatedrawseq getAnnotatedrawseq() {
    return findChildByClass(PonyAnnotatedrawseq.class);
  }

  @Override
  @Nullable
  public PonyEliftype getEliftype() {
    return findChildByClass(PonyEliftype.class);
  }

  @Override
  @Nullable
  public PonyIdlist getIdlist() {
    return findChildByClass(PonyIdlist.class);
  }

  @Override
  @NotNull
  public PonyIstype getIstype() {
    return findNotNullChildByClass(PonyIstype.class);
  }

}
