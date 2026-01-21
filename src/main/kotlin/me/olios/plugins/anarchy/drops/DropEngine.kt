package me.olios.plugins.anarchy.drops

import me.olios.plugins.anarchy.drops.probability.WeightedSelector
import me.olios.plugins.anarchy.drops.provider.DropProvider

class DropEngine(
    providers: List<DropProvider>
) {
    private val selector = WeightedSelector(providers)

    fun roll(ctx: DropSnapshot): DropResult {
        val provider = selector.select(ctx.random)
        return provider.roll(ctx) ?: DropResult.Nothing
    }
}
