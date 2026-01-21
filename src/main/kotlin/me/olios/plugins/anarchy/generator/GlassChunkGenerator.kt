package me.olios.plugins.anarchy.generator

import org.bukkit.HeightMap
import org.bukkit.Material
import org.bukkit.generator.ChunkGenerator
import org.bukkit.generator.WorldInfo
import java.util.*


class GlassChunkGenerator: ChunkGenerator() {
    private val surfaceLayerY: Int = 64 // Define Y level
    private val material: Material = Material.GLASS

    override fun generateSurface(worldInfo: WorldInfo, random: Random, chunkX: Int, chunkZ: Int, chunkData: ChunkData) =
        chunkData.setRegion(0, 0, 0, 16, surfaceLayerY - 1, 16, material)

    override fun getBaseHeight(worldInfo: WorldInfo, random: Random, x: Int, z: Int, heightMap: HeightMap): Int =
        surfaceLayerY

    override fun shouldGenerateNoise(): Boolean =
        false

    override fun shouldGenerateNoise(worldInfo: WorldInfo, random: Random, chunkX: Int, chunkZ: Int): Boolean =
        false

    override fun shouldGenerateSurface(): Boolean =
        true

    override fun shouldGenerateSurface(worldInfo: WorldInfo, random: Random, chunkX: Int, chunkZ: Int): Boolean =
        true

    override fun shouldGenerateCaves(): Boolean =
        false

    override fun shouldGenerateCaves(worldInfo: WorldInfo, random: Random, chunkX: Int, chunkZ: Int): Boolean =
        false

    override fun shouldGenerateDecorations(): Boolean =
        false

    override fun shouldGenerateDecorations(worldInfo: WorldInfo, random: Random, chunkX: Int, chunkZ: Int): Boolean =
        false

    override fun shouldGenerateMobs(): Boolean =
        true // Enable mobs spawning

    override fun shouldGenerateMobs(worldInfo: WorldInfo, random: Random, chunkX: Int, chunkZ: Int): Boolean =
        true // Enable mobs spawning

    override fun shouldGenerateStructures(): Boolean =
        true // Enable structure generation

    override fun shouldGenerateStructures(worldInfo: WorldInfo, random: Random, chunkX: Int, chunkZ: Int): Boolean =
        true // Enable structure generation

}