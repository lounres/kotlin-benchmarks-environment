tailrec fun findTwinPrimes(primes: IntArray, lastPrime: Int, i: Int, n: Int, N: Int) {
    if (n < N) {
        if (primes.all { i % it != 0 }) {
            val primes1 = primes + i
            val k = if (i != lastPrime + 2) 0 else {
                println("$n: ($lastPrime, $i)")
                1
            }
            findTwinPrimes(primes1, i, i + 2, n + k, N)
        } else {
            findTwinPrimes(primes, lastPrime, i + 2, n, N)
        }
    }
}

fun main() {
    findTwinPrimes(intArrayOf(2), 2, 3, 0, 500)
}