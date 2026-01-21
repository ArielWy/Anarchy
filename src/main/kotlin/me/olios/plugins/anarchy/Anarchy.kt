package me.olios.plugins.anarchy

import me.olios.plugins.anarchy.generator.GlassChunkGenerator
import me.olios.plugins.anarchy.listeners.BlockBreakListener
import me.olios.plugins.anarchy.listeners.BlockPlaceListener
import org.bukkit.Bukkit
import org.bukkit.generator.ChunkGenerator
import org.bukkit.plugin.java.JavaPlugin

class Anarchy : JavaPlugin() {

    companion object {
        // plugin instance
        private lateinit var instance: Anarchy
        fun getInstance(): Anarchy = instance

        // world instance
        var generatedWorldName: String? = null
        fun getWorldName(): String = generatedWorldName?: "None"
    }


    override fun onEnable() {
        // define plugin instance
        instance = this

        saveDefaultConfig() /* save the config to the plugin folder */
        registerListeners()
    }

    override fun getDefaultWorldGenerator(worldName: String, id: String?): ChunkGenerator {
        // define world gen

        /* ----------------------DEBUGGING MESSAGE------------------------- */
        logger.info("RELOAD GLASS WORLD for world: $worldName!")
        /* ----------------------DEBUGGING MESSAGE------------------------- */

        if (generatedWorldName == null) { // Store it if not already set
            generatedWorldName = worldName

            /* ----------------------DEBUGGING MESSAGE------------------------- */
            logger.info("Anarchy generator targeting world: $generatedWorldName")
            /* ----------------------DEBUGGING MESSAGE------------------------- */
        }

        return GlassChunkGenerator()
    }

    fun registerListeners() {
        Bukkit.getPluginManager().registerEvents(BlockBreakListener(), this)
        Bukkit.getPluginManager().registerEvents(BlockPlaceListener(), this)
    }

}
