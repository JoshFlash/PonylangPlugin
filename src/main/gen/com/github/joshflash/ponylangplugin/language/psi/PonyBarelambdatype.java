// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyBarelambdatype extends PsiElement {

  @NotNull
  List<PonyCap> getCapList();

  @Nullable
  PonyIdRef getIdRef();

  @NotNull
  List<PonyType> getTypeList();

  @Nullable
  PonyTypeparams getTypeparams();

  @Nullable
  PsiElement getGencap();

}
