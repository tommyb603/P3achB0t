package com.p3achb0t._runelite_interfaces

interface WorldMapElement : DualNode {
    fun getCategory(): Int
    fun getSprite1(): Int
    fun getSprite2(): Int
    fun getString1(): String
    fun getStrings(): Array<String>
    fun getTextSize(): Int
    fun get__b(): Array<Byte>
    fun get__a(): Int
    fun get__j(): Int
    fun get__s(): Int
    fun get__z(): Int
    fun get__h(): Array<Int>
    fun get__i(): Array<Int>
    fun get__e(): Int
    fun get__l(): String
    fun get__o(): Int
}