// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyClassDef extends PsiElement {

  @Nullable
  PonyAnnotatedids getAnnotatedids();

  @Nullable
  PonyCap getCap();

  @NotNull
  PonyDeclaration getDeclaration();

  @NotNull
  PonyMembers getMembers();

  @Nullable
  PonyType getType();

  @NotNull
  PonyTypeRef getTypeRef();

  @Nullable
  PonyTypeparams getTypeparams();

  @Nullable
  PsiElement getDocString();

}
