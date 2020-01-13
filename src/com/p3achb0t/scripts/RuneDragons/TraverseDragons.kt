import com.p3achb0t.api.Context
import com.p3achb0t.api.Utils
import com.p3achb0t.api.wrappers.Area
import com.p3achb0t.api.wrappers.Tile
import com.p3achb0t.scripts.RuneDragsMain
import com.p3achb0t.scripts.Task
import kotlinx.coroutines.delay
import kotlin.random.Random

class TraverseDragons(val ctx: Context) : Task(ctx.client) {
    override suspend fun isValidToRun(): Boolean {
        val combatArea = Area(
                Tile(1575, 5086, ctx = ctx),
                Tile(1597, 5062, ctx = ctx)
        )
        return !RuneDragsMain.shouldBank(ctx) && !combatArea.containsOrIntersects(ctx.players.getLocal().getGlobalLocation())
    }


    override suspend fun execute() {
        val prayerpots: IntArray = intArrayOf(143, 141, 139, 2434)
        val combatArea = Area(
                Tile(1575, 5086, ctx = ctx),
                Tile(1597, 5062, ctx = ctx)
        )

        var cwBank = Tile(2442, 3083, 0, ctx = ctx)
        val pendantids: IntArray = intArrayOf(11194, 11193, 11192, 11191, 11190)
        if (ctx.bank.isOpen()) {
            ctx.bank.close()
            delay(150)
        }

        run teleportcw@{
            if (cwBank.distanceTo() < 30) {
                pendantids.forEach {
                    if (ctx.inventory.Contains(it)) {
                        println("inventory contains " + it)
                        if (!ctx.dialog.isDialogOptionsOpen()) {
                            ctx.inventory.getItem(it)?.interact("Rub")
                            delay(1000)
                        }
                        if (ctx.dialog.isDialogOptionsOpen()) {
                            ctx.dialog.selectionOption("Lithkren")
                            Utils.waitFor(5, object : Utils.Condition {
                                override suspend fun accept(): Boolean {
                                    delay(100)
                                    return cwBank.distanceTo() > 30
                                }
                            })
                        }
                        if (cwBank.distanceTo() > 30) {
                            return@teleportcw
                        }
                    }
                }
            }
            if (cwBank.distanceTo() > 30) {
                val firstTile = Tile(3550, 10457, ctx.players.getLocal().player.getPlane(), ctx)
                if (firstTile.distanceTo() < 5)
                    Tile(3549, 10466, ctx.client.getPlane(), ctx).clickOnMiniMap()
                delay(Random.nextLong(1500, 2500))
                val secondTile = Tile(3549, 10466, ctx.players.getLocal().player.getPlane(), ctx)
                val Stairs = ctx.gameObjects.find("Staircase", sortByDistance = true)
                val Door = ctx.gameObjects.find("Broken Grandiose Doors", sortByDistance = true)
                val Barrier = ctx.gameObjects.find("Barrier", sortByDistance = true)
                val BarrierTile = Tile(1573, 5076, ctx.players.getLocal().player.getPlane(), ctx)
                if (secondTile.distanceTo() <= 4) {
                    if (Stairs.size > 0) {
                        if (!Stairs[0].isOnScreen())
                            Stairs[0].turnTo()
                        if (Stairs[0].isOnScreen())
                            Stairs[0].click()
                        delay(Random.nextLong(1500, 2500))
                    }
                }
                if (Door.size > 0 && Barrier.size < 1) {
                    if (Door[0].distanceTo() <= 15) {
                        if (!Door[0].isOnScreen())
                            Door[0].turnTo()
                        if (Door[0].isOnScreen())
                            Door[0].click()
                        Utils.waitFor(5, object : Utils.Condition {
                            override suspend fun accept(): Boolean {
                                delay(100)
                                return Barrier.size > 0
                            }
                        })
                    }
                }
                if (Barrier.size > 0 && !combatArea.containsOrIntersects(ctx.players.getLocal().getGlobalLocation())) {
                    if (BarrierTile.distanceTo() > 2) {
                        BarrierTile.clickOnMiniMap()
                        delay(Random.nextLong(1500, 2500))
                        if (ctx.players.getLocal().getHealth() < 56) {
                            ctx.inventory.getItem(385)?.click()
                            delay(1500)
                        }
                        run prayerpots@{
                            if (ctx.players.getLocal().getPrayer() < 60) {
                                prayerpots.forEach {
                                    if (ctx.inventory.Contains(it)) {
                                        ctx.inventory.getItem(it)?.click()
                                        delay(500)
                                    }
                                    if (ctx.players.getLocal().getPrayer() >= 60) {
                                        return@prayerpots
                                    }
                                }
                            }
                        }
                    }
                    if (BarrierTile.distanceTo() <= 4) {
                        if (ctx.players.getLocal().getHealth() < 56) {
                            ctx.inventory.getItem(385)?.click()
                            delay(1500)
                        }
                        ctx.camera.turnEast()
                        ctx.camera.setPitch(20)
                        val random = Random.nextInt(0, 5)
                        if (!Barrier[random].getGlobalLocation().isOnScreen())
                            Barrier[random].turnTo()
                        if (Barrier[random].getGlobalLocation().isOnScreen())
                            Barrier[random].getGlobalLocation().click()
                        delay(Random.nextLong(1500, 2500))
                    }
                }

            }
        }
    }
}