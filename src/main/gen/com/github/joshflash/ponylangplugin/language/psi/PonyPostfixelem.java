// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyPostfixelem extends PsiElement {

  @Nullable
  PonyCall getCall();

  @Nullable
  PonyChainId getChainId();

  @Nullable
  PonyDotId getDotId();

  @Nullable
  PonyTildeId getTildeId();

  @Nullable
  PonyTypeargs getTypeargs();

}
