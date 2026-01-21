package me.olios.plugins.anarchy.listeners

import me.olios.plugins.anarchy.Anarchy
import me.olios.plugins.anarchy.drops.DropContext
import me.olios.plugins.anarchy.drops.DropCoordinator
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import kotlin.random.Random

class GlassBreakListener(
    private val coordinator: DropCoordinator
) : Listener {

    private val rng = Random(System.currentTimeMillis())

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onBlockBreak(event: BlockBreakEvent) {
        val block = event.block

        // return if the block isn't glass
        if (block.type != Material.GLASS) return

        // return if the block is not in the gen world (didn't generate by the plugin)
        if (block.world.name != Anarchy.targetWorldName) return

        if (event.player.gameMode == GameMode.CREATIVE) return

        event.isDropItems = false

        val ctx = DropContext(
            event.player,
            block,
            block.world,
            rng
        )

        coordinator.handle(ctx)
    }
}