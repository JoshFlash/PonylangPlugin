// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyBehaviorDeclaration extends PsiElement {

  @NotNull
  PonyBlock getBlock();

  @NotNull
  PonyParameterList getParameterList();

  @Nullable
  PonyType getType();

  @NotNull
  PsiElement getIdentifier();

}
