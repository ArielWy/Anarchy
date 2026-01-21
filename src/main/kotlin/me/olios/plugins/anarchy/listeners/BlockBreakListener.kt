package me.olios.plugins.anarchy.listeners

import me.olios.plugins.anarchy.Anarchy
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.WorldCreator
import org.bukkit.block.TileState
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class BlockBreakListener: Listener {
    private val plugin = Anarchy.getInstance()

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val block = event.block

        // return if the block isn't glass
        if (block.type != Material.GLASS) return

        // return if the block is not in the gen world (didn't generate by the plugin)
        if (block.world.name != Anarchy.getWorldName())  return

        block
    }
}