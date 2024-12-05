// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyNextatom extends PsiElement {

  @Nullable
  PonyForloop getForloop();

  @Nullable
  PonyIfblock getIfblock();

  @Nullable
  PonyParticle getParticle();

  @Nullable
  PonyRawseq getRawseq();

  @Nullable
  PonyTuple getTuple();

  @Nullable
  PonyType getType();

  @Nullable
  PonyWhileloop getWhileloop();

  @Nullable
  PsiElement getNewline();

}
