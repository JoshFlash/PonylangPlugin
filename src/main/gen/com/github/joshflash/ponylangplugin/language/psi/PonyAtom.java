// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyAtom extends PsiElement {

  @Nullable
  PonyForloop getForloop();

  @Nullable
  PonyFunDef getFunDef();

  @Nullable
  PonyIdFfi getIdFfi();

  @Nullable
  PonyIdVar getIdVar();

  @Nullable
  PonyLiteral getLiteral();

  @Nullable
  PonyNamed getNamed();

  @Nullable
  PonyObjectDef getObjectDef();

  @Nullable
  PonyPositional getPositional();

  @Nullable
  PonyRawseq getRawseq();

  @Nullable
  PonyRecoverDef getRecoverDef();

  @Nullable
  PonyTuple getTuple();

  @Nullable
  PonyType getType();

  @Nullable
  PonyTypeRef getTypeRef();

  @Nullable
  PonyTypeargs getTypeargs();

  @Nullable
  PonyWhileloop getWhileloop();

}
