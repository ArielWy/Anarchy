package me.olios.plugins.anarchy.drop

import com.google.gson.GsonBuilder
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.logging.Logger

class ItemConfigGenerator(private val logger: Logger) {
    fun generateFullItemConfig(outputFile: File) {
        val generatedItems = mutableListOf<CustomItem>()
        val gson = GsonBuilder().setPrettyPrinting().create()

        Material.entries.forEach { material ->
            // You might want to refine this filter for specific items/blocks you want to include
            if (!material.isItem || material.name.contains("COMMAND") || material == Material.BARRIER || material == Material.LIGHT) {
                return@forEach // 'continue' for forEach loop
            }

            val applicableEnchantments = mutableMapOf<String, Int>()
            var enchantmentCombinations: Long = 1 // Use Long for combination count to avoid overflow

            // Attempt to create an ItemStack to check enchantability
            try {
                val tempItem = ItemStack(material)

                // Get all enchantments. For modern Minecraft (1.20.5+), consider using Bukkit.getRegistry(Registry.ENCHANTMENT)
                // For wider compatibility, Enchantment.values() is still common.
                Enchantment.values().forEach { enchantment ->
                    if (enchantment.canEnchantItem(tempItem)) {
                        applicableEnchantments[enchantment.toString()] = enchantment.maxLevel
                        enchantmentCombinations *= (enchantment.maxLevel + 1).toLong() // +1 for level 0 (no enchant)
                    }
                }
            } catch (e: IllegalArgumentException) {
                logger.fine("Could not create ItemStack for material ${material.name}: ${e.message}")
                // No enchantments for this item, combinations remain 1
            } catch (e: Exception) {
                logger.warning("Unexpected error processing material ${material.name}: ${e.message}")
                // No enchantments for this item, combinations remain 1
            }

            val customItem = CustomItem(
                material = material.name,
                // Optional: Default display name. Remove if you prefer to add it manually.
                enchantments = applicableEnchantments.ifEmpty { null },
                weight = if (applicableEnchantments.isNotEmpty()) enchantmentCombinations.toInt() else 1
            )
            generatedItems.add(customItem)
        }

        val config = ItemConfig(generatedItems)

        try {
            FileWriter(outputFile).use { writer ->
                gson.toJson(config, writer)
                logger.info("Generated full custom_items_generated.json with ${generatedItems.size} items.")
            }
        } catch (e: IOException) {
            logger.severe("Error writing custom_items_generated.json: ${e.message}")
        }
    }

    private fun capitalizeWords(str: String): String {
        if (str.isEmpty()) return str
        return str.split(" ").joinToString(" ") { word ->
            word.uppercase()
        }
    }
}