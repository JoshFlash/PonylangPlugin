// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyParticle extends PsiElement {

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
  PonyRecoverDef getRecoverDef();

  @Nullable
  PonyTypeRef getTypeRef();

  @Nullable
  PonyTypeargs getTypeargs();

}
