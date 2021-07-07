package com.gitTraining

fun computeFibbonaciNumber(position: Int, recursion: Boolean = false): Int {
    if (recursion) return recursiveFibbonachi(1, 1, position - 2)

    var i = 1
    var j = 1

    if (position <= 2) return 1


    var currentPosition = 2
    while (currentPosition < position) {
        val temp = i
        i = j
        j += temp
        currentPosition ++
    }
    return j
}

fun recursiveFibbonachi(previous: Int, current: Int, stepsLeft: Int): Int {
    if (stepsLeft < 0) return 1
    return when (stepsLeft) {
        0 -> current
        else -> recursiveFibbonachi(current, previous + current, stepsLeft - 1)
    }
}

fun computeFibbonachiArray(start: Int, end: Int, efficient: Boolean = false): List<Int> {
    if (!efficient) return (start..end).map { computeFibbonaciNumber(it) }
    if (start > end) return listOf()
    if (start == end) return listOf(computeFibbonaciNumber(start))
    val output = mutableListOf(computeFibbonaciNumber(start), computeFibbonaciNumber(start + 1))
    (2..(end-start)).forEach { output.add(output[it-2] + output[it-1]) }
    return output
}
