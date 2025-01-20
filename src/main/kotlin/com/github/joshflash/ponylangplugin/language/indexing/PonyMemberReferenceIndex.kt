package com.github.joshflash.ponylangplugin.language.indexing

import com.github.joshflash.ponylangplugin.language.PonyFileType
import com.intellij.util.indexing.*
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import java.io.DataInput
import java.io.DataOutput

class PonyMemberReferenceIndex : FileBasedIndexExtension<String, String>() {

    companion object {
        val INDEX_ID: ID<String, String> = ID.create("com.github.joshflash.ponylangplugin.idrefindex")
        const val FIELD_SUFFIX = ".field"
        const val METHOD_SUFFIX = ".method"
    }

    override fun getName(): ID<String, String> = INDEX_ID

    override fun getVersion(): Int = 2

    override fun dependsOnFileContent(): Boolean = true

    override fun getInputFilter(): FileBasedIndex.FileTypeSpecificInputFilter {
        return DefaultFileTypeSpecificInputFilter(PonyFileType.INSTANCE)
    }

    override fun getIndexer(): DataIndexer<String, String, FileContent> = PonyMemberRefDataIndexer()

    override fun getKeyDescriptor(): KeyDescriptor<String> {
        return EnumeratorStringDescriptor.INSTANCE
    }

    override fun getValueExternalizer(): DataExternalizer<String> =
        object : DataExternalizer<String> {
            override fun save(out: DataOutput, value: String) {
                out.writeUTF(value)
            }

            override fun read(inputData: DataInput): String {
                return inputData.readUTF()
            }
        }
}