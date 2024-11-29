// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyStatement extends PsiElement {

  @Nullable
  PonyAssignmentStatement getAssignmentStatement();

  @Nullable
  PonyExpressionStatement getExpressionStatement();

  @Nullable
  PonyFieldDeclaration getFieldDeclaration();

  @Nullable
  PonyForStatement getForStatement();

  @Nullable
  PonyIfStatement getIfStatement();

  @Nullable
  PonyMatchStatement getMatchStatement();

  @Nullable
  PonyTryStatement getTryStatement();

}
