// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyClassDef extends PsiElement {

  @Nullable
  PonyCap getCap();

  @NotNull
  PonyDeclaration getDeclaration();

  @Nullable
  PonyIdlist getIdlist();

  @NotNull
  PonyMembers getMembers();

  @Nullable
  PonyType getType();

  @Nullable
  PonyTypeparams getTypeparams();

  @NotNull
  PsiElement getId();

  @Nullable
  PsiElement getString();

}
