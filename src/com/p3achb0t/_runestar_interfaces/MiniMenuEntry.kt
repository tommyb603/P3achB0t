package com.p3achb0t._runestar_interfaces

interface MiniMenuEntry {
    fun getAction(): String
    fun getArgument0(): Int
    fun getArgument1(): Int
    fun getArgument2(): Int
    fun getOpcode(): Int
}
