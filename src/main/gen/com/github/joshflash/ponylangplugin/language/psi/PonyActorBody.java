// This is a generated file. Not intended for manual editing.
package com.github.joshflash.ponylangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PonyActorBody extends PsiElement {

  @NotNull
  List<PonyBehaviorDeclaration> getBehaviorDeclarationList();

  @NotNull
  List<PonyConstructor> getConstructorList();

  @NotNull
  List<PonyFieldDeclaration> getFieldDeclarationList();

  @NotNull
  List<PonyMethodDeclaration> getMethodDeclarationList();

}
