// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyPrimary extends PsiElement {

  @Nullable
  PonyBlock getBlock();

  @Nullable
  PonyConsumeExpr getConsumeExpr();

  @Nullable
  PonyExpr getExpr();

  @Nullable
  PonyIfExpr getIfExpr();

  @Nullable
  PonyLiteral getLiteral();

  @Nullable
  PonyMatchExpr getMatchExpr();

  @Nullable
  PonyRecoverExpr getRecoverExpr();

  @Nullable
  PonyTryExpr getTryExpr();

  @Nullable
  PsiElement getId();

}
