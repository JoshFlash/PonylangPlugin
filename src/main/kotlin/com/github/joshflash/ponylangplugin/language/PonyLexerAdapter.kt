package com.github.joshflash.ponylangplugin.language

import com.intellij.lexer.FlexAdapter

class PonyLexerAdapter : FlexAdapter(_PonyLexer(null))