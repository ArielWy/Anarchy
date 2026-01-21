package me.olios.plugins.anarchy.drops

import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.entity.Player
import kotlin.random.Random

data class DropContext(
    val player: Player,
    val block: Block,
    val world: World,
    val random: Random
)

