fun main() {
    println("Введите количество строк:")
    val rows = readLine()?.toIntOrNull()
    println("Введите количество столбцов:")
    val cols = readLine()?.toIntOrNull()

    if (rows == null || cols == null || rows <= 0 || cols <= 0) {
        println("Ошибка: введите положительные числа для строк и столбцов.")
        return
    }

    val totalNumbers = rows * cols
    println("Введите $totalNumbers трехзначных чисел (каждое число с новой строки):")

    val array = Array(rows) { IntArray(cols) }
    var numbersEntered = 0

    while (numbersEntered < totalNumbers) {
        val input = readLine()?.toIntOrNull()
        if (input == null || input < 100 || input > 999) {
            println("Ошибка: введите корректное трехзначное число.")
        } else {
            array[numbersEntered / cols][numbersEntered % cols] = input
            numbersEntered++
        }
    }

    val digitSet = mutableSetOf<Char>()
    for (row in array) {
        for (number in row) {
            digitSet.addAll(number.toString().toCharArray().toSet())
        }
    }

    println("Полученный массив:")
    for (row in array) {
        println(row.joinToString("   "))
    }

    println("В массиве использовано ${digitSet.size} различных цифр.")
}
