// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyCasepattern extends PsiElement {

  @Nullable
  PonyBinding getBinding();

  @Nullable
  PonyPostfix getPostfix();

  @NotNull
  List<PonyPostfixop> getPostfixopList();

  @Nullable
  PonyTermRef getTermRef();

  @Nullable
  PonyType getType();

}
