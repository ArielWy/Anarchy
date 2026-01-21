package me.olios.plugins.anarchy.listeners

import me.olios.plugins.anarchy.Anarchy
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class GlassPlaceListener: Listener {
    /**
     * prevent placing glass block for random items -
     * only generated glass blocks should drop random item
     */

    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        val block = event.blockPlaced
        if (block.type != Material.GLASS) return

        // replace the GLASS block with WHITE_STAINED_GLASS block
        block.type = Material.WHITE_STAINED_GLASS

    }
}