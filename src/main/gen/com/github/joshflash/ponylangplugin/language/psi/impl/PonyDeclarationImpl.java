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

public class PonyDeclarationImpl extends ASTWrapperPsiElement implements PonyDeclaration {

  public PonyDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyActorDeclaration getActorDeclaration() {
    return findChildByClass(PonyActorDeclaration.class);
  }

  @Override
  @Nullable
  public PonyClassDeclaration getClassDeclaration() {
    return findChildByClass(PonyClassDeclaration.class);
  }

  @Override
  @Nullable
  public PonyPrimitiveDeclaration getPrimitiveDeclaration() {
    return findChildByClass(PonyPrimitiveDeclaration.class);
  }

  @Override
  @Nullable
  public PonyTraitDeclaration getTraitDeclaration() {
    return findChildByClass(PonyTraitDeclaration.class);
  }

}