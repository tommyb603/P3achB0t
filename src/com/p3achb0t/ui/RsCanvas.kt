package com.p3achb0t.ui

import com.p3achb0t.api.painting.drawDebugText
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.event.KeyListener
import java.awt.image.BufferedImage


open class RsCanvas : Canvas() {

    private val gameCanvas = BufferedImage(765, 503, BufferedImage.TYPE_INT_RGB)

    override fun getGraphics() : Graphics {

        val g = gameCanvas.graphics
        g.color = Color.CYAN
        g.drawString("P3achB0t & Unoplex - BOT Alpha 0.1.0", 50 ,20)

        drawDebugText(g)


        super.getGraphics().drawImage(gameCanvas, 0, 0, null)
        return g

    }
}