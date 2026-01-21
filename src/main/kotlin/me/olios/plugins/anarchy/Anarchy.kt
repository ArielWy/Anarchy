package me.olios.plugins.anarchy

import me.olios.plugins.anarchy.drops.DropCoordinator
import me.olios.plugins.anarchy.drops.DropEngine
import me.olios.plugins.anarchy.drops.item.ItemFactory
import me.olios.plugins.anarchy.drops.provider.ItemProvider
import me.olios.plugins.anarchy.generator.GlassChunkGenerator
import me.olios.plugins.anarchy.listeners.GlassBreakListener
import me.olios.plugins.anarchy.listeners.GlassPlaceListener
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.generator.ChunkGenerator
import org.bukkit.plugin.java.JavaPlugin

class Anarchy : JavaPlugin() {

    companion object {
        lateinit var instance: Anarchy
            private set

        // Load this directly from config so it's available immediately
        var targetWorldName: String = "world"
            private set
    }

    override fun onLoad() {
        instance = this
        saveDefaultConfig()
        targetWorldName = config.getString("world.name", "world")!!
    }

    override fun onEnable() {

        val blacklist = config.getStringList("drops.blacklist")
            .mapNotNull { Material.matchMaterial(it) }
            .toSet()

        val allowedMaterials = Material.entries
            .filter { it.isItem && !it.isAir && !blacklist.contains(it) }

        val itemProvider = ItemProvider(allowedMaterials, ItemFactory())
        val engine = DropEngine(listOf(itemProvider))
        val coordinator = DropCoordinator(engine, this)

        registerListeners(coordinator)
    }

    private fun registerListeners(c: DropCoordinator) {
        Bukkit.getPluginManager().registerEvents(GlassBreakListener(c), this)
        Bukkit.getPluginManager().registerEvents(GlassPlaceListener(), this)
    }

    override fun getDefaultWorldGenerator(worldName: String, id: String?): ChunkGenerator? {

        if (worldName == targetWorldName) {
            return GlassChunkGenerator()
        }

        return super.getDefaultWorldGenerator(worldName, id)
    }
}
