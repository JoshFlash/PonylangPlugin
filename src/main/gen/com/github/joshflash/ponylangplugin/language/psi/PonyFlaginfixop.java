// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyFlaginfixop extends PsiElement {

  @Nullable
  PonyFlagterm getFlagterm();

  @Nullable
  PonyPartialop getPartialop();

  @Nullable
  PonySafeop getSafeop();

  @Nullable
  PonyType getType();

  @Nullable
  PonyUnsafeop getUnsafeop();

}
