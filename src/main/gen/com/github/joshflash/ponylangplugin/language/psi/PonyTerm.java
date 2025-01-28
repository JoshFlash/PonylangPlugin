// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyTerm extends PsiElement {

  @Nullable
  PonyBinding getBinding();

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyControlblock getControlblock();

  @Nullable
  PonyPostfix getPostfix();

  @NotNull
  List<PonyPostfixop> getPostfixopList();

  @Nullable
  PonyResourceblock getResourceblock();

  @Nullable
  PonyTerm getTerm();

  @Nullable
  PonyTermRef getTermRef();

  @Nullable
  PonyType getType();

}
