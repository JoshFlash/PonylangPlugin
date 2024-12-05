// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyParticle extends PsiElement {

  @Nullable
  PonyCap getCap();

  @Nullable
  PonyIdlist getIdlist();

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
  PonyTypeargs getTypeargs();

  @Nullable
  PonyTypeparams getTypeparams();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getString();

}
