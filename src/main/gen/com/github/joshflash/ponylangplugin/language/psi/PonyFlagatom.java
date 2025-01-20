// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyFlagatom extends PsiElement {

  @NotNull
  List<PonyFlaginfix> getFlaginfixList();

  @Nullable
  PonyForloop getForloop();

  @Nullable
  PonyFunDef getFunDef();

  @Nullable
  PonyIdFfi getIdFfi();

  @Nullable
  PonyIfblock getIfblock();

  @Nullable
  PonyLiteral getLiteral();

  @Nullable
  PonyNamed getNamed();

  @Nullable
  PonyObjectDef getObjectDef();

  @Nullable
  PonyPositional getPositional();

  @Nullable
  PonyRecoverDef getRecoverDef();

  @Nullable
  PonyTuple getTuple();

  @Nullable
  PonyType getType();

  @Nullable
  PonyTypeargs getTypeargs();

  @Nullable
  PonyWhileloop getWhileloop();

  @Nullable
  PsiElement getId();

}
