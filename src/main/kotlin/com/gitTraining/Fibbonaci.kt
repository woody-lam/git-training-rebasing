package com.gitTraining

fun computeFibbonaciNumber(position: Int): Int {
    if (position == 0) return 0
    if (position < 0) {
        val positionIsOdd = position % 2 == -1
        return if (positionIsOdd) computeFibbonaciNumber(-position) else (computeFibbonaciNumber(-position) * -1)
    }
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
