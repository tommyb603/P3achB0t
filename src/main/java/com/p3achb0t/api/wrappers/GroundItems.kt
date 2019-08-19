package com.p3achb0t.api.wrappers

import com.p3achb0t._runestar_interfaces.Model
import com.p3achb0t._runestar_interfaces.Obj
import com.p3achb0t._runestar_interfaces.ObjStack
import com.p3achb0t._runestar_interfaces.ObjectNode
import com.p3achb0t.api.ObjectPositionInfo

class GroundItems {
    companion object {
        fun getAllItems(): ArrayList<GroundItem> {
            val itemList = ArrayList<GroundItem>()
            val groundItems = Client.client.getObjStacks()
            val groundItemModels = Client.client.getObjType_cachedModels()
            val tiles = Client.client.getScene().getTiles()
            for ((iP, plane) in groundItems.withIndex()) {
                for ((iX, x) in plane.iterator().withIndex()) {
                    for ((iY, itemPile) in x.iterator().withIndex()) {
                        if (itemPile != null) {

                            var gi = itemPile.getSentinel()

                            if (gi != null) {
                                gi = gi.getPrevious()
                            }
                            if (gi != null) {
                                if (gi is ObjectNode) {
                                    println("Found ObjectNode")
                                }
                                if (gi is ObjStack) {
                                    println("Found ObjStack")
                                }
                                if (gi is Obj) {
//                                    println("Found Obj")
//                                    println(" ID: ${gi.getKey()} ($iP,$iX,$iY) Found Item: ${gi.getId()} stackSize: ${gi.getQuantity()}")
                                    groundItemModels.getHashTable().getBuckets().iterator().forEach {
                                        if (it != null) {
                                            var next = it.getNext()
                                            while (next != null && next != it && next is Model && next.getKey().toInt() == gi.getId()) {
                                                try {
                                                    val x = tiles[iP][iX][iY].getX() * 128 + 64
                                                    val y = tiles[iP][iX][iY].getY() * 128 + 64
                                                    val id = gi.getId()

                                                    itemList.add(
                                                        GroundItem(
                                                            id,
                                                            ObjectPositionInfo(x, y, plane = iP)
                                                        )
                                                    )
                                                    next = next.getNext()
                                                } catch (e: Exception) {
                                                    println(e.stackTrace)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return itemList
        }

    }
}