// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyInterfaceDeclaration extends PsiElement {

  @Nullable
  PonyDocString getDocString();

  @NotNull
  List<PonyMethod> getMethodList();

  @Nullable
  PonyTypeParams getTypeParams();

  @NotNull
  PsiElement getId();

}