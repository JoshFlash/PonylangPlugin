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

public class PonyCasepatternImpl extends ASTWrapperPsiElement implements PonyCasepattern {

  public PonyCasepatternImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitCasepattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyBinding getBinding() {
    return findChildByClass(PonyBinding.class);
  }

  @Override
  @Nullable
  public PonyPostfix getPostfix() {
    return findChildByClass(PonyPostfix.class);
  }

  @Override
  @NotNull
  public List<PonyPostfixop> getPostfixopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PonyPostfixop.class);
  }

  @Override
  @Nullable
  public PonyTermRef getTermRef() {
    return findChildByClass(PonyTermRef.class);
  }

  @Override
  @Nullable
  public PonyType getType() {
    return findChildByClass(PonyType.class);
  }

}
