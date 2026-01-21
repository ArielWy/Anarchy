package me.olios.plugins.anarchy.drops.probability

import me.olios.plugins.anarchy.drops.provider.DropProvider
import kotlin.random.Random

class WeightedSelector(
    providers: List<DropProvider>
) {
    private val entries: List<Pair<DropProvider, Double>>
    private val total: Double

    init {
        var sum = 0.0
        entries = providers.map {
            sum += it.weight
            it to sum
        }
        total = sum
    }

    fun select(random: Random): DropProvider {
        val r = random.nextDouble() * total
        return entries.first { r < it.second }.first
    }
}
