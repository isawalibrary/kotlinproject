@file: JvmName("Dice")

import java.util.*
import kotlin.collections.List as List1

fun main(args: Array<String>){
    rollWithExplosions()
}

fun rollWithExplosions() : String{
    var diceset = getDiceType()

    for (each in diceset){
        var result = rollDice(each)

        var explodingResult = result

        while (explodingResult.contains("E")){
            explodingResult = rollDice(each)
            result = result + " / " + explodingResult
        }

        println(result)
    }
    return diceset
}

fun getDiceType() : String {
    print("how many (r)ing or (s)kill dice?")
    return readLine() ?: "x"
}

fun rollDice(diceType : Char): String {
    val ring = arrayOf ("Blank","O T","O","S T","S","E T")
    val skill = arrayOf ("Blank","Blank","O","O","O","S T","S T","S","S","S T","E T","E")

    var type: Array<String> = ring

    when (diceType){
        'r' -> type = ring
        's' -> type = skill
    }

    var result: String = getRandom(type)

    return result
}


