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

public class PonyActorBodyImpl extends ASTWrapperPsiElement implements PonyActorBody {

  public PonyActorBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitActorBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PonyBehaviorDeclaration> getBehaviorDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyBehaviorDeclaration.class);
  }

  @Override
  @NotNull
  public List<PonyConstructor> getConstructorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyConstructor.class);
  }

  @Override
  @NotNull
  public List<PonyFieldDeclaration> getFieldDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyFieldDeclaration.class);
  }

  @Override
  @NotNull
  public List<PonyMethodDeclaration> getMethodDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyMethodDeclaration.class);
  }

}
