package me.olios.plugins.anarchy.config

import org.bukkit.configuration.file.FileConfiguration

class ConfigSettings(config: FileConfiguration) {
    val enchantChance: Double = config.getDouble("enchant_chance", 0.3)
    val curseChance: Double = config.getDouble("curse_chance", 0.1)
}