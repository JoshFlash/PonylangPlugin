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

public class PonyClassDeclarationImpl extends ASTWrapperPsiElement implements PonyClassDeclaration {

  public PonyClassDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitClassDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyCapability getCapability() {
    return findChildByClass(PonyCapability.class);
  }

  @Override
  @NotNull
  public List<PonyConstructor> getConstructorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyConstructor.class);
  }

  @Override
  @Nullable
  public PonyDocString getDocString() {
    return findChildByClass(PonyDocString.class);
  }

  @Override
  @NotNull
  public List<PonyField> getFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyField.class);
  }

  @Override
  @NotNull
  public List<PonyMethod> getMethodList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyMethod.class);
  }

  @Override
  @Nullable
  public PonyTypeList getTypeList() {
    return findChildByClass(PonyTypeList.class);
  }

  @Override
  @Nullable
  public PonyTypeParams getTypeParams() {
    return findChildByClass(PonyTypeParams.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
