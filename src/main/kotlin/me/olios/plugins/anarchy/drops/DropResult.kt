package me.olios.plugins.anarchy.drops

import org.bukkit.entity.EntityType
import org.bukkit.inventory.ItemStack

sealed class DropResult {
    data class Item(val items: List<ItemStack>) : DropResult()
    data class Mob(val type: EntityType) : DropResult()
    object Nothing : DropResult()
}
