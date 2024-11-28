// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyExpr extends PsiElement {

  @NotNull
  List<PonyExprSuffix> getExprSuffixList();

  @NotNull
  PonyPrimary getPrimary();

  @Nullable
  PonyUnaryOp getUnaryOp();

}
