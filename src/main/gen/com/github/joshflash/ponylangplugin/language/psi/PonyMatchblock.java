// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyMatchblock extends PsiElement {

  @Nullable
  PonyAnnotatedids getAnnotatedids();

  @Nullable
  PonyAnnotatedrawseq getAnnotatedrawseq();

  @NotNull
  List<PonyCaseexpr> getCaseexprList();

  @NotNull
  PonyRawseq getRawseq();

}
