// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyMethod extends PsiElement {

  @Nullable
  PonyAnnotatedids getAnnotatedids();

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyParams getParams();

  @Nullable
  PonyRawseq getRawseq();

  @Nullable
  PonyType getType();

  @Nullable
  PonyTypeparams getTypeparams();

  @NotNull
  PsiElement getId();

  @Nullable
  PsiElement getString();

}
