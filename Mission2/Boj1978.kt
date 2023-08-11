import java.util.*
fun main() {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()
    var answer: IntArray = IntArray(N, { 0 })
    var count = 0

    for (i in 0 until N) {
        answer[i] = scanner.nextInt()
    }

    for (i in 0 until N) {
        var isPrime: Boolean = true
        if (answer[i] == 1) {
            isPrime = false
        } else {
            for (j in 2 until answer[i]) {
                if (answer[i] % j == 0) {
                    isPrime = false
                    break 
                }
            }
        }
        if (isPrime)
            count++
    }
    print(count)
}
