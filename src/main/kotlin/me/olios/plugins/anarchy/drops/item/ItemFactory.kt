package me.olios.plugins.anarchy.drops.item

import me.olios.plugins.anarchy.drops.DropSnapshot
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ItemFactory {

    fun create(mat: Material, ctx: DropSnapshot): ItemStack {
        val stack = ItemStack(mat, 1)

        applyAmount(stack, ctx)
        applyDurability(stack, ctx)
        applyEnchantments(stack, ctx)
        applyAttributes(stack, ctx)

        return stack
    }

    private fun applyAmount(stack: ItemStack, ctx: DropSnapshot) {}
    private fun applyDurability(stack: ItemStack, ctx: DropSnapshot) {}
    private fun applyEnchantments(stack: ItemStack, ctx: DropSnapshot) {}
    private fun applyAttributes(stack: ItemStack, ctx: DropSnapshot) {}
}
