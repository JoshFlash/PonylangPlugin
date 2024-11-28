// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyClassDeclaration extends PsiElement {

  @Nullable
  PonyCapability getCapability();

  @NotNull
  List<PonyConstructor> getConstructorList();

  @Nullable
  PonyDocString getDocString();

  @NotNull
  List<PonyField> getFieldList();

  @NotNull
  List<PonyMethod> getMethodList();

  @Nullable
  PonyTypeList getTypeList();

  @Nullable
  PonyTypeParams getTypeParams();

  @NotNull
  PsiElement getId();

}
