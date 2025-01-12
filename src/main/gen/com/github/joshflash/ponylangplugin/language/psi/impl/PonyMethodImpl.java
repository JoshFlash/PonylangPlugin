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

public class PonyMethodImpl extends ASTWrapperPsiElement implements PonyMethod {

  public PonyMethodImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitMethod(this);
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
  public PonyCap getCap() {
    return findChildByClass(PonyCap.class);
  }

  @Override
  @NotNull
  public PonyMemberRef getMemberRef() {
    return findNotNullChildByClass(PonyMemberRef.class);
  }

  @Override
  @Nullable
  public PonyParams getParams() {
    return findChildByClass(PonyParams.class);
  }

  @Override
  @Nullable
  public PonyRawseq getRawseq() {
    return findChildByClass(PonyRawseq.class);
  }

  @Override
  @Nullable
  public PonyType getType() {
    return findChildByClass(PonyType.class);
  }

  @Override
  @Nullable
  public PonyTypeparams getTypeparams() {
    return findChildByClass(PonyTypeparams.class);
  }

  @Override
  @Nullable
  public PsiElement getDocString() {
    return findChildByType(DOC_STRING);
  }

}
