package benchmark

import findTwinPrimes
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.BenchmarkMode
import kotlinx.benchmark.BenchmarkTimeUnit
import kotlinx.benchmark.Mode
import kotlinx.benchmark.OutputTimeUnit
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.SECONDS)
@State(Scope.Benchmark)
class Benchmarks {
    @Benchmark
    fun test() {
        findTwinPrimes(intArrayOf(2), 2, 3, 0, 500)
    }
}