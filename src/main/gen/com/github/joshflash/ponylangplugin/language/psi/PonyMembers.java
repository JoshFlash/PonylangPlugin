// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyMembers extends PsiElement {

  @NotNull
  List<PonyField> getFieldList();

  @NotNull
  List<PonyMethod> getMethodList();

}