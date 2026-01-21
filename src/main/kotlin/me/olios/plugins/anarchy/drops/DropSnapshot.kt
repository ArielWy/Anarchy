package me.olios.plugins.anarchy.drops

import org.bukkit.Location
import kotlin.random.Random

data class DropSnapshot(
    val worldName: String,
    val location: Location,
    val random: Random
)
