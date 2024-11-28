// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyMethod extends PsiElement {

  @Nullable
  PonyCapability getCapability();

  @Nullable
  PonyDocString getDocString();

  @Nullable
  PonyExpr getExpr();

  @Nullable
  PonyMethodModifier getMethodModifier();

  @NotNull
  PonyParamList getParamList();

  @Nullable
  PonyTypeExpr getTypeExpr();

  @Nullable
  PonyTypeParams getTypeParams();

  @NotNull
  PsiElement getId();

}
