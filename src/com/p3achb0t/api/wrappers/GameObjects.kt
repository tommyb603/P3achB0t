package com.p3achb0t.api.wrappers

import com.p3achb0t.api.user_inputs.Mouse


class GameObjects(val client: com.p3achb0t._runestar_interfaces.Client, val mouse: Mouse) {
    val gameObjects: ArrayList<GameObject>
        get() {
            val gameObjects = ArrayList<GameObject>()
            val region = client.getScene()

            region.getTiles().iterator().forEach { plane ->
                plane.iterator().forEach { row ->
                    row.iterator().forEach { tile ->
                        if (tile != null) {
                            if (tile.getScenery().isNotEmpty()) {
                                tile.getScenery().iterator().forEach {
                                    if (it != null && it.getTag() > 0) {
                                        gameObjects.add(GameObject(it, client = client, mouse = mouse))

                                    }
                                }
                            }
                        }
                    }
                }

            }
            return gameObjects
        }

    fun find(id: Int, tile: Tile = Tile(), sortByDistance: Boolean = false): ArrayList<GameObject> {
        val gameObjects = ArrayList<GameObject>()
        val region = client.getScene()

        //Default tile we will iterate over the region
        if (tile.x == -1 && tile.y == -1) {

            region.getTiles().iterator().forEach { plane ->
                plane.iterator().forEach { row ->
                    row.iterator().forEach { colTile ->
                        if (colTile != null) {
                            if (colTile.getScenery().isNotEmpty()) {
                                colTile.getScenery().iterator().forEach {
                                    if (it != null) {
                                        val gmObj = GameObject(it, client = client, mouse = mouse)
                                        if (gmObj.id == id)
                                            gameObjects.add(gmObj)

                                    }
                                }
                            }
                            if (colTile.getWall() != null) {
                                val boundaryObject = colTile.getWall()
                                val gmObj = GameObject(wallObject = boundaryObject, client = client, mouse = mouse)
                                if (gmObj.id == id)
                                    gameObjects.add(gmObj)
                            }
                        }
                    }
                }
            }
        } else {
            //TODO - Specific tile we will zoom into that specific spot. This should be faster

        }
        if (sortByDistance) {
            val local = Players(client,mouse).getLocal()
            gameObjects.sortBy { it.distanceTo(local) }
        }
        return gameObjects
    }

    fun find(name: String, tile: Tile = Tile(), sortByDistance: Boolean = false): ArrayList<GameObject> {
        val gameObjects = ArrayList<GameObject>()
        val region = client.getScene()

        //Default tile we will iterate over the region
        if (tile.x == -1 && tile.y == -1) {

            region.getTiles().iterator().forEach { plane ->
                plane.iterator().forEach { row ->
                    row.iterator().forEach { colTile ->
                        if (colTile != null) {
                            if (colTile.getScenery().isNotEmpty()) {
                                colTile.getScenery().iterator().forEach {
                                    if (it != null) {
                                        val gmObj = GameObject(it, client = client, mouse = mouse)
                                        if (gmObj.name.toLowerCase() == name.toLowerCase())
                                            gameObjects.add(gmObj)

                                    }
                                }
                            }
                            if (colTile.getWall() != null) {
                                val boundaryObject = colTile.getWall()
                                val gmObj = GameObject(wallObject = boundaryObject, client = client, mouse = mouse)
                                if (gmObj.name.toLowerCase() == name.toLowerCase())
                                    gameObjects.add(gmObj)
                            }
                        }
                    }
                }
            }
        } else {
            //TODO - Specific tile we will zoom into that specific spot. This should be faster

        }
        if (sortByDistance) {
            val local = Players(client,mouse).getLocal()
            gameObjects.sortBy { it.distanceTo(local) }
        }
        return gameObjects
    }
}