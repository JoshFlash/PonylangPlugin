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

public class PonyLiteralImpl extends ASTWrapperPsiElement implements PonyLiteral {

  public PonyLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyFloat getFloat() {
    return findChildByClass(PonyFloat.class);
  }

  @Override
  @Nullable
  public PonyInt getInt() {
    return findChildByClass(PonyInt.class);
  }

  @Override
  @Nullable
  public PonyStringliteral getStringliteral() {
    return findChildByClass(PonyStringliteral.class);
  }

}
