// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyForloop extends PsiElement {

  @Nullable
  PonyAnnotatedids getAnnotatedids();

  @Nullable
  PonyAnnotatedrawseq getAnnotatedrawseq();

  @NotNull
  PonyIdseq getIdseq();

  @NotNull
  List<PonyRawseq> getRawseqList();

}
