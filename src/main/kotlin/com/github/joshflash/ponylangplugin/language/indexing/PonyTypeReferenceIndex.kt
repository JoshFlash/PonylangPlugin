package com.github.joshflash.ponylangplugin.language.indexing

import com.github.joshflash.ponylangplugin.language.PonyFileType
import com.github.joshflash.ponylangplugin.language.psi.PonyClassDef
import com.github.joshflash.ponylangplugin.language.psi.PonyFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.*
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor

class PonyTypeReferenceIndex : ScalarIndexExtension<String>() {

    companion object {
        val INDEX_ID: ID<String, Void> = ID.create("com.github.joshflash.ponylangplugin.typerefindex")
    }

    override fun getName(): ID<String, Void> = INDEX_ID

    override fun getVersion(): Int = 1

    override fun dependsOnFileContent(): Boolean = true

    override fun getInputFilter(): FileBasedIndex.FileTypeSpecificInputFilter {
        return DefaultFileTypeSpecificInputFilter(PonyFileType.INSTANCE)
    }

    override fun getIndexer(): DataIndexer<String, Void, FileContent> {
        return DataIndexer { inputData ->
            val result = mutableMapOf<String, Void?>()
            val psiFile = inputData.psiFile
            if (psiFile is PonyFile) {
                val classDefs = PsiTreeUtil.collectElementsOfType(psiFile, PonyClassDef::class.java)
                for (classDef in classDefs) {
                    result[classDef.typeRef.typeId.text] = null
                }
            }

            result
        }
    }

    // This descriptor is how index keys (Strings) are serialized/stored.
    override fun getKeyDescriptor(): KeyDescriptor<String> {
        return EnumeratorStringDescriptor.INSTANCE
    }
}