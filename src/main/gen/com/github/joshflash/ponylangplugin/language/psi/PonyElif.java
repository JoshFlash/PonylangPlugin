// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyElif extends PsiElement {

  @Nullable
  PonyAnnotatedrawseq getAnnotatedrawseq();

  @Nullable
  PonyElif getElif();

  @Nullable
  PonyIdlist getIdlist();

  @NotNull
  List<PonyRawseq> getRawseqList();

}