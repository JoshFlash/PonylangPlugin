package com.github.joshflash.ponylangplugin.util

import com.intellij.util.indexing.ValueContainer
import com.intellij.util.indexing.impl.UpdatableValueContainer
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.DataInputOutputUtil
import java.io.DataOutput
import java.util.function.IntPredicate

class SingleValueContainer<V>(var value: V?) : ValueContainer<V>(), Cloneable {

    override fun getValueIterator(): ValueIterator<V> = SingleValueIterator(value)

    override fun size(): Int = 1

    fun removeValue() {
        removeAssociatedValue(value.hashCode())
    }

    private fun removeAssociatedValue(inputId: Int): Boolean {
        if (!valueIterator.hasNext() || valueIterator.valueAssociationPredicate?.test(inputId) == false) {
            return false
        }

        valueIterator.remove()
        return true
    }

    fun saveTo(out: DataOutput?, externalizer: DataExternalizer<in V>?) {
        if (out == null) return

        DataInputOutputUtil.writeINT(out, this.size())
        val valueIterator = this.getValueIterator()
        valueIterator.forEach { value ->
            externalizer?.save(out, value)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private class SingleValueIterator<V>(private val value: V?) : ValueIterator<V> {
        private var hasNext = value != null

        override fun hasNext(): Boolean = hasNext

        override fun next(): V {
            if (!hasNext) {
                throw NoSuchElementException()
            }

            hasNext = false
            return value as V
        }

        override fun remove() {
            hasNext = false
        }

        override fun getInputIdsIterator(): IntIterator {
            return object : IntIterator {
                override fun hasNext(): Boolean = this@SingleValueIterator.hasNext()
                override fun next(): Int = this@SingleValueIterator.next().hashCode()
                override fun size(): Int = 1
            }
        }

        override fun getValueAssociationPredicate(): IntPredicate {
            val hashCode = value.hashCode()
            return IntPredicate { it == hashCode }
        }
    }
}