// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyConstructor extends PsiElement {

  @NotNull
  PonyBlock getBlock();

  @Nullable
  PonyCapability getCapability();

  @Nullable
  PonyDocString getDocString();

  @NotNull
  PonyParamList getParamList();

  @Nullable
  PsiElement getId();

}
