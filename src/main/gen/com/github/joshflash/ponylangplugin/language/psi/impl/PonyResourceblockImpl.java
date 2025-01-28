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

public class PonyResourceblockImpl extends ASTWrapperPsiElement implements PonyResourceblock {

  public PonyResourceblockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitResourceblock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyAnnotatedids getAnnotatedids() {
    return findChildByClass(PonyAnnotatedids.class);
  }

  @Override
  @Nullable
  public PonyAnnotatedrawseq getAnnotatedrawseq() {
    return findChildByClass(PonyAnnotatedrawseq.class);
  }

  @Override
  @Nullable
  public PonyCap getCap() {
    return findChildByClass(PonyCap.class);
  }

  @Override
  @Nullable
  public PonyEliftype getEliftype() {
    return findChildByClass(PonyEliftype.class);
  }

  @Override
  @Nullable
  public PonyIfdefblock getIfdefblock() {
    return findChildByClass(PonyIfdefblock.class);
  }

  @Override
  @Nullable
  public PonyIstype getIstype() {
    return findChildByClass(PonyIstype.class);
  }

  @Override
  @Nullable
  public PonyRawseq getRawseq() {
    return findChildByClass(PonyRawseq.class);
  }

  @Override
  @NotNull
  public List<PonyWithelem> getWithelemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyWithelem.class);
  }

}
