// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyUsestmt extends PsiElement {

  @Nullable
  PonyInfix getInfix();

  @Nullable
  PonyStringliteral getStringliteral();

  @Nullable
  PonyUseFfi getUseFfi();

  @Nullable
  PsiElement getId();

}
