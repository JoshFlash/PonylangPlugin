// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyRecoverDef extends PsiElement {

  @Nullable
  PonyAnnotatedids getAnnotatedids();

  @NotNull
  List<PonyCap> getCapList();

  @Nullable
  PonyLambdacaptures getLambdacaptures();

  @Nullable
  PonyLambdaparams getLambdaparams();

  @Nullable
  PonyParamRef getParamRef();

  @NotNull
  PonyRawseq getRawseq();

  @Nullable
  PonyType getType();

  @Nullable
  PonyTypeparams getTypeparams();

}
