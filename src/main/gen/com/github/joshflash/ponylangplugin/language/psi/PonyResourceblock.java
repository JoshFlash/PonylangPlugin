// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyResourceblock extends PsiElement {

  @Nullable
  PonyAnnotatedids getAnnotatedids();

  @Nullable
  PonyAnnotatedrawseq getAnnotatedrawseq();

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyEliftype getEliftype();

  @Nullable
  PonyIfdefblock getIfdefblock();

  @Nullable
  PonyIstype getIstype();

  @Nullable
  PonyRawseq getRawseq();

  @NotNull
  List<PonyWithelem> getWithelemList();

}
