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

public class PonyStatementImpl extends ASTWrapperPsiElement implements PonyStatement {

  public PonyStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PonyVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PonyVisitor) accept((PonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PonyAssignmentStatement getAssignmentStatement() {
    return findChildByClass(PonyAssignmentStatement.class);
  }

  @Override
  @Nullable
  public PonyExpressionStatement getExpressionStatement() {
    return findChildByClass(PonyExpressionStatement.class);
  }

  @Override
  @Nullable
  public PonyFieldDeclaration getFieldDeclaration() {
    return findChildByClass(PonyFieldDeclaration.class);
  }

  @Override
  @Nullable
  public PonyForStatement getForStatement() {
    return findChildByClass(PonyForStatement.class);
  }

  @Override
  @Nullable
  public PonyIfStatement getIfStatement() {
    return findChildByClass(PonyIfStatement.class);
  }

  @Override
  @Nullable
  public PonyMatchStatement getMatchStatement() {
    return findChildByClass(PonyMatchStatement.class);
  }

  @Override
  @Nullable
  public PonyTryStatement getTryStatement() {
    return findChildByClass(PonyTryStatement.class);
  }

}
