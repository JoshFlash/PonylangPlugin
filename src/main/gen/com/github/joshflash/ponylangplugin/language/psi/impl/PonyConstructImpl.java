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

public class PonyConstructImpl extends ASTWrapperPsiElement implements PonyConstruct {

  public PonyConstructImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitConstruct(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyCap getCap() {
    return findChildByClass(PonyCap.class);
  }

  @Override
  @Nullable
  public PonyControlblock getControlblock() {
    return findChildByClass(PonyControlblock.class);
  }

  @Override
  @Nullable
  public PonyForloop getForloop() {
    return findChildByClass(PonyForloop.class);
  }

  @Override
  @Nullable
  public PonyIfblock getIfblock() {
    return findChildByClass(PonyIfblock.class);
  }

  @Override
  @Nullable
  public PonyIfdefblock getIfdefblock() {
    return findChildByClass(PonyIfdefblock.class);
  }

  @Override
  @Nullable
  public PonyMatchblock getMatchblock() {
    return findChildByClass(PonyMatchblock.class);
  }

  @Override
  @Nullable
  public PonyPostfix getPostfix() {
    return findChildByClass(PonyPostfix.class);
  }

  @Override
  @Nullable
  public PonyTerm getTerm() {
    return findChildByClass(PonyTerm.class);
  }

  @Override
  @Nullable
  public PonyTryblock getTryblock() {
    return findChildByClass(PonyTryblock.class);
  }

  @Override
  @Nullable
  public PonyWhileloop getWhileloop() {
    return findChildByClass(PonyWhileloop.class);
  }

}
