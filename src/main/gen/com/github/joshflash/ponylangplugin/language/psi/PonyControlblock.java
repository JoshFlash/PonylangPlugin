// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyControlblock extends PsiElement {

  @Nullable
  PonyForloop getForloop();

  @Nullable
  PonyIfblock getIfblock();

  @Nullable
  PonyMatchblock getMatchblock();

  @Nullable
  PonyTryblock getTryblock();

  @Nullable
  PonyWhileloop getWhileloop();

}
