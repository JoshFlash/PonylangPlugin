// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyUseFfi extends PsiElement {

  @Nullable
  PonyParams getParams();

  @NotNull
  PonyTypeargs getTypeargs();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getString();

  @Nullable
  PsiElement getTypeId();

}
