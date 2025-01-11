// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyParticle extends PsiElement {

  @Nullable
  PonyAnnotatedids getAnnotatedids();

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyIdFfi getIdFfi();

  @Nullable
  PonyIdRef getIdRef();

  @Nullable
  PonyLambdacaptures getLambdacaptures();

  @Nullable
  PonyLambdaparams getLambdaparams();

  @Nullable
  PonyLiteral getLiteral();

  @Nullable
  PonyMembers getMembers();

  @Nullable
  PonyNamed getNamed();

  @Nullable
  PonyPositional getPositional();

  @Nullable
  PonyRawseq getRawseq();

  @Nullable
  PonyType getType();

  @Nullable
  PonyTypeRef getTypeRef();

  @Nullable
  PonyTypeargs getTypeargs();

  @Nullable
  PonyTypeparams getTypeparams();

}
