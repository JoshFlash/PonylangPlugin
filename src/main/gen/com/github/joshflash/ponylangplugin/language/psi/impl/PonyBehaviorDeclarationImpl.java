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

public class PonyBehaviorDeclarationImpl extends ASTWrapperPsiElement implements PonyBehaviorDeclaration {

  public PonyBehaviorDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitBehaviorDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PonyBlock getBlock() {
    return findNotNullChildByClass(PonyBlock.class);
  }

  @Override
  @NotNull
  public PonyParameterList getParameterList() {
    return findNotNullChildByClass(PonyParameterList.class);
  }

  @Override
  @Nullable
  public PonyType getType() {
    return findChildByClass(PonyType.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}