package me.olios.plugins.anarchy.drop

data class ItemConfig(
    val items: List<CustomItem>
)

data class CustomItem(
    val material: String,
    val enchantments: Map<String, Int>? = null, // Nullable map
    val weight: Int? = null             // Nullable Int for weight
) {
    // Custom getter for weight with a default value
    fun getWeightOrDefault(): Int = weight ?: 1 // If weight is null, return 1
}