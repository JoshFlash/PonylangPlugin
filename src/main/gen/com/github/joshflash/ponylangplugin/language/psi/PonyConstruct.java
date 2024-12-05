// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyConstruct extends PsiElement {

  @Nullable
  PonyAnnotatedids getAnnotatedids();

  @Nullable
  PonyAnnotatedrawseq getAnnotatedrawseq();

  @Nullable
  PonyCap getCap();

  @NotNull
  List<PonyCaseexpr> getCaseexprList();

  @Nullable
  PonyElifdef getElifdef();

  @Nullable
  PonyEliftype getEliftype();

  @Nullable
  PonyForloop getForloop();

  @Nullable
  PonyIfblock getIfblock();

  @Nullable
  PonyInfix getInfix();

  @Nullable
  PonyIstype getIstype();

  @Nullable
  PonyPostfix getPostfix();

  @Nullable
  PonyRawseq getRawseq();

  @Nullable
  PonyTerm getTerm();

  @Nullable
  PonyWhileloop getWhileloop();

  @NotNull
  List<PonyWithelem> getWithelemList();

}
