// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyFieldDeclaration extends PsiElement {

  @Nullable
  PonyExpression getExpression();

  @Nullable
  PonyType getType();

  @NotNull
  PsiElement getIdentifier();

}
