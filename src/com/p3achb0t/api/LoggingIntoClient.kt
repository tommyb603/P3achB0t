package com.p3achb0t.api

import com.p3achb0t.UserDetails
import com.p3achb0t.api.user_inputs.Mouse
import com.p3achb0t.api.wrappers.utils.Utils
import com.p3achb0t.api.wrappers.widgets.WidgetID
import com.p3achb0t.api.wrappers.widgets.WidgetItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.awt.Point

class LoggingIntoClient {
    companion object {
        var loggedIn = false
    }
}

fun LoggingIntoAccount(ctx: Context) {
    //Logging into the client
    Thread.sleep(2000)
    GlobalScope.launch {

        repeat(1000) {
            try {

//                val disconnected = WidgetItem(ctx.widgets.find(WidgetID.login, 85), ctx = ctx)
                // When loaded login
                if (ctx.client.getGameState() == 10) {
                    delay(2000)
                    ctx.mouse.moveMouse(Point(399, 316), true, Mouse.ClickType.Left)
                    delay(1000)
                    ctx.mouse.moveMouse(Point(531, 280), true, Mouse.ClickType.Left)
                    delay(2000)
                    ctx.keyboard.sendKeys(UserDetails.data.username)
                    delay(500)
                    ctx.mouse.moveMouse(Point(367, 262), true, Mouse.ClickType.Left)
                    delay(2000)
                    ctx.keyboard.sendKeys(UserDetails.data.password)
                    ctx.mouse.moveMouse(Point(326, 323), true, Mouse.ClickType.Left)

                    while (ctx.client.getGameState() != 30) {
                        delay(100)
                    }
                    delay(1500)
                    println("Clicking login")
                    val login = WidgetItem(ctx.widgets.find(WidgetID.LOGIN_CLICK_TO_PLAY_GROUP_ID, 85), ctx = ctx)
                    println("login: ${login.area.x},${login.area.y},${login.area.height},${login.area.width}")
                    login.click()
                    Utils.waitFor(5, object : Utils.Condition {
                        override suspend fun accept(): Boolean {
                            delay(100)
                            return ctx.client.getGameState() == 30
                        }
                    })
                }


                //IF not on tutorial island: click the play. Widget 378,85
//                if (Client.GameState.LoggedIn.intState == clientData.gameState.toInt()) {
//                    getLocalNPCData()
//                    getLocalPlayersData()
//                    getGroundItemData()
//                    getItemTableData()
//                    getRegion()
//                }
            } catch (e: Exception) {
                println("Exception" + e.toString())
                for (statck in e.stackTrace) {
                    println(statck.toString())
                }
            }
            delay(50)
        }
    }
}