// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyLambdatype extends PsiElement {

  @NotNull
  List<PonyCap> getCapList();

  @Nullable
  PonyIdVar getIdVar();

  @NotNull
  List<PonyType> getTypeList();

  @Nullable
  PonyTypeparams getTypeparams();

  @Nullable
  PsiElement getGencap();

}
