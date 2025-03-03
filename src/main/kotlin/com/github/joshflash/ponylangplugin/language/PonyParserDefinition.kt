package com.github.joshflash.ponylangplugin.language

import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.github.joshflash.ponylangplugin.language.psi.PonyTokenSets
import com.github.joshflash.ponylangplugin.language.psi.impl.PonyElements
import com.github.joshflash.ponylangplugin.parser.PonyParser
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class PonyParserDefinition : ParserDefinition {
    companion object {
        val FILE = IFileElementType(PonyLanguage)
    }

    override fun createLexer(p0: Project?): Lexer = PonyLexerAdapter()

    override fun createParser(p0: Project?): PsiParser = PonyParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = PonyTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = PonyTokenSets.STRINGS

    override fun createElement(p0: ASTNode): PsiElement = PonyElements.Factory.createElement(p0)

    override fun createFile(p0: FileViewProvider): PsiFile = PonyFile(p0)
}