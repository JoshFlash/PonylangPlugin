// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyNominal extends PsiElement {

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyIdVar getIdVar();

  @NotNull
  PonyTypeRef getTypeRef();

  @Nullable
  PonyTypeargs getTypeargs();

  @Nullable
  PsiElement getGencap();

}
