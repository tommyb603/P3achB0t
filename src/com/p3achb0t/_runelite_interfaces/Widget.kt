package com.p3achb0t._runelite_interfaces

interface Widget : Node {
    fun getActions(): Array<String>
    fun getButtonText(): String
    fun getButtonType(): Int
    fun getChildIndex(): Int
    fun getChildren(): Array<Widget>
    fun getClickMask(): Int
    fun getColor(): Int
    fun getColor2(): Int
    fun getContentType(): Int
    fun getCs1ComparisonValues(): IntArray
    fun getCs1Comparisons(): IntArray
    fun getCs1Instructions(): Array<IntArray>
    fun getCycle(): Int
    fun getDataText(): String
    fun getDragThreshold(): Int
    fun getDragZoneSize(): Int
    fun getFill(): Boolean
    fun getFontId(): Int
    fun getHasListener(): Boolean
    fun getHeight(): Int
    fun getHeightAlignment(): Int
    fun getId(): Int
    fun getInvTransmitTriggers(): IntArray
    fun getInventorySprites(): IntArray
    fun getInventoryXOffsets(): IntArray
    fun getInventoryYOffsets(): IntArray
    fun getIsHidden(): Boolean
    fun getIsIf3(): Boolean
    fun getIsScrollBar(): Boolean
    fun getItemActions(): Array<String>
    fun getItemId(): Int
    fun getItemIds(): IntArray
    fun getItemQuantities(): IntArray
    fun getItemQuantity(): Int
    fun getLineWid(): Int
    fun getModelAngleX(): Int
    fun getModelAngleY(): Int
    fun getModelAngleZ(): Int
    fun getModelFrame(): Int
    fun getModelFrameCycle(): Int
    fun getModelId(): Int
    fun getModelId2(): Int
    fun getModelOffsetX(): Int
    fun getModelOffsetY(): Int
    fun getModelOrthog(): Boolean
    fun getModelType(): Int
    fun getModelType2(): Int
    fun getModelZoom(): Int
    fun getMouseOverColor(): Int
    fun getMouseOverColor2(): Int
    fun getMouseOverRedirect(): Int
    fun getNoClickThrough(): Boolean
    fun getOnClick(): Any
    fun getOnClickRepeat(): Any
    fun getOnDrag(): Any
    fun getOnDragComplete(): Any
    fun getOnHold(): Any
    fun getOnInvTransmit(): Any
    fun getOnLoad(): Any
    fun getOnMouseLeave(): Any
    fun getOnMouseOver(): Any
    fun getOnMouseRepeat(): Any
    fun getOnOp(): Any
    fun getOnRelease(): Any
    fun getOnScroll(): Any
    fun getOnStatTransmit(): Any
    fun getOnTargetEnter(): Any
    fun getOnTargetLeave(): Any
    fun getOnTimer(): Any
    fun getOnVarTransmit(): Any
    fun getOutline(): Int
    fun getPaddingX(): Int
    fun getPaddingY(): Int
    fun getParent(): Widget
    fun getParentId(): Int
    fun getRawHeight(): Int
    fun getRawWidth(): Int
    fun getRawX(): Int
    fun getRawY(): Int
    fun getRectangleMode(): RectangleMode
    fun getRootIndex(): Int
    fun getScrollHeight(): Int
    fun getScrollWidth(): Int
    fun getScrollX(): Int
    fun getScrollY(): Int
    fun getSequenceId(): Int
    fun getSequenceId2(): Int
    fun getSpellActionName(): String
    fun getSpellName(): String
    fun getSpriteAngle(): Int
    fun getSpriteFlipH(): Boolean
    fun getSpriteFlipV(): Boolean
    fun getSpriteId(): Int
    fun getSpriteId2(): Int
    fun getSpriteShadow(): Int
    fun getSpriteTiling(): Boolean
    fun getStatTransmitTriggers(): IntArray
    fun getText(): String
    fun getText2(): String
    fun getTextLineHeight(): Int
    fun getTextShadowed(): Boolean
    fun getTextXAlignment(): Int
    fun getTextYAlignment(): Int
    fun getTransparency(): Int
    fun getType(): Int
    fun getVarTransmitTriggers(): IntArray
    fun getWidth(): Int
    fun getWidthAlignment(): Int
    fun getX(): Int
    fun getXAlignment(): Int
    fun getY(): Int
    fun getYAlignment(): Int
    fun get__ba(): Boolean
    fun get__bv(): Boolean
    fun get__cg(): Boolean
    fun get__fm(): Boolean
    fun get__fq(): Boolean
    fun get__fw(): Boolean
    fun get__fz(): Boolean
    fun get__cf(): Array<ByteArray>
    fun get__cp(): Array<ByteArray>
    fun get__af(): Int
    fun get__al(): Int
    fun get__aw(): Int
    fun get__bf(): Int
    fun get__bh(): Int
    fun get__bw(): Int
    fun get__fc(): Int
    fun get__fg(): Int
    fun get__fj(): Int
    fun get__fl(): Int
    fun get__cc(): IntArray
    fun get__ci(): IntArray
    fun get__fh(): IntArray
    fun get__ed(): Any
    fun get__ee(): Any
    fun get__eh(): Any
    fun get__ei(): Any
    fun get__ej(): Any
    fun get__el(): Any
    fun get__em(): Any
    fun get__en(): Any
    fun get__eq(): Any
    fun get__ex(): Any
}
