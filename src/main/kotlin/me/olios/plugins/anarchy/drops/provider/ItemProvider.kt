package me.olios.plugins.anarchy.drops.provider

import me.olios.plugins.anarchy.drops.DropContext
import me.olios.plugins.anarchy.drops.DropResult
import me.olios.plugins.anarchy.drops.DropSnapshot
import me.olios.plugins.anarchy.drops.item.ItemFactory
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import java.util.*

class ItemProvider(
    private val allowed: List<Material>,
    private val itemFactory: ItemFactory
) : DropProvider {

    override val weight = 100.0

    override fun roll(ctx: DropSnapshot): DropResult {
        val mat = allowed.random(ctx.random)
        val stack = itemFactory.create(mat, ctx)
        return DropResult.Item(listOf(stack))
    }
}
