package me.olios.plugins.anarchy.drops

import me.olios.plugins.anarchy.Anarchy
import org.bukkit.Bukkit
import org.bukkit.Location

class DropCoordinator(
    private val engine: DropEngine,
    private val plugin: Anarchy
) {

    fun handle(ctx: DropContext) {

        // main thread guard
        if (ctx.world.name != Anarchy.targetWorldName) return

        val snapshot = DropSnapshot(
            worldName = ctx.world.name,
            location = ctx.block.location.clone(),
            random = ctx.random
        )

        Bukkit.getScheduler().runTaskAsynchronously(plugin, Runnable {

            val result = engine.roll(snapshot) // pure logic only!

            Bukkit.getScheduler().runTask(plugin, Runnable {

                // still same world?
                if (snapshot.worldName != Anarchy.targetWorldName) return@Runnable

                execute(result, snapshot.location)
            })
        })
    }

    private fun execute(result: DropResult, loc: Location) {
        val world = loc.world ?: return
        println(" EXECUTE!")

        when (result) {
            is DropResult.Item ->
                result.items.forEach { world.dropItemNaturally(loc, it)
                println("item: ${it.displayName()}") }

            is DropResult.Mob ->
                world.spawnEntity(loc, result.type)

            DropResult.Nothing -> {}
        }
    }
}
