package com.github.joshflash.ponylangplugin.util

import com.intellij.concurrency.ConcurrentCollectionFactory
import com.intellij.util.indexing.ValueContainer
import com.intellij.util.indexing.impl.IndexStorageUtil
import com.intellij.util.io.KeyDescriptor
import java.io.Closeable
import java.io.Flushable

class VirtualIndexStorage<K, V>(keyDescriptor: KeyDescriptor<K>) : Flushable, Closeable {
    private val valueMap: MutableMap<K, SingleValueContainer<V>> =
        ConcurrentCollectionFactory.createConcurrentMap(IndexStorageUtil.adaptKeyDescriptorToStrategy(keyDescriptor))

    private fun <K, V> MutableMap<K, V>.asReadOnlyMap(): Map<K, V> {
        return this
    }

    fun getMap() = valueMap.asReadOnlyMap()

    fun addValue(k: K, v: V) {
        valueMap.computeIfAbsent(k) { SingleValueContainer(v) }
    }

    fun clear() {
        valueMap.clear()
    }

    fun read(k: K): ValueContainer<V> {
        if (!valueMap.containsKey(k)) {
            return SingleValueContainer<V>(null)
        }

        return valueMap[k]!!
    }

    fun getValue(k: K): V? {
        return valueMap[k]?.getSingleValue()
    }

    fun clearCaches() {
    }

    override fun close() {
    }

    override fun flush() {
    }

    fun removeAllValues(k: K & Any, inputId: Int) {
        val container: SingleValueContainer<V> = this.valueMap[k] ?: return
        container.removeValue()
        valueMap.remove(k)
    }

    fun isDirty(): Boolean {
        return false
    }

    fun keyCount(): Int {
        return valueMap.size
    }
}