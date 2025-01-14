// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyConstruct extends PsiElement {

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyControlblock getControlblock();

  @Nullable
  PonyForloop getForloop();

  @Nullable
  PonyIfblock getIfblock();

  @Nullable
  PonyIfdefblock getIfdefblock();

  @Nullable
  PonyMatchblock getMatchblock();

  @Nullable
  PonyPostfix getPostfix();

  @Nullable
  PonyTerm getTerm();

  @Nullable
  PonyTryblock getTryblock();

  @Nullable
  PonyWhileloop getWhileloop();

}
