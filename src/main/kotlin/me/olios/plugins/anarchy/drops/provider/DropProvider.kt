package me.olios.plugins.anarchy.drops.provider

import me.olios.plugins.anarchy.drops.DropContext
import me.olios.plugins.anarchy.drops.DropResult
import me.olios.plugins.anarchy.drops.DropSnapshot

interface DropProvider {
    fun roll(ctx: DropSnapshot): DropResult?
    val weight: Double
}
