import kotlin.random.Random

val words = arrayListOf("elbow","queen","jacket","banana","spin","blanket","crocs","spinach","greed","doctor","thief",
                        "arrow","sword","polish","bridge")
var word = ""
var guessesToBeMade = arrayListOf<Char>()
var gussesleft = 6
var mistakes =0
fun main(args:Array<String>){
    setupGame()
}
fun setupGame(){
    val indexofword = Random.nextInt(0,words.size)
    word = words[indexofword]
    words.remove(words[indexofword])

    for(i in 0..word.length-1){
        if (i==0||i==word.length-1){
          guessesToBeMade.add(word[i])
        }
        else{
            guessesToBeMade.add('_')
        }
    }
    printGameStatus()


}
fun printGameStatus(){
    when (mistakes){
        0 -> printZeroMistake()
        1 -> printOneMistake()
        2 -> printTwoMistakes()
        3 -> printThreeMistakes()
        4 -> printFourMistakes()
        5 -> printFiveMistakes()
        6 -> {
            printSixMistakes()
            println("Correct word was : $word")
            return
        }
        else -> {
            GameWon()
           return
        }
    }
    print("Guess the word : ")
    for (i in guessesToBeMade){
        print("$i ")
    }
    println("\nYou have $gussesleft guess(es) left")
    println("Please Enter the word : ")
    checkWord()
}
fun checkWord(){
    var guess = readLine()?:""
    if (guess == word){
        println("Good Guess You Win")
        mistakes =-1
        printGameStatus()
    }
    else if (guess!=word){
        if(mistakes==5){
            println("Wrong Guess...")
            mistakes++
            gussesleft--
            printGameStatus()
        }
        else{
            println("Wrong Guess... Try Again")
            mistakes++
            gussesleft--
            printGameStatus()
        }
    }
}
fun printZeroMistake(){
    println("  |------------|")
    println("  |            |")
    println("  |             ")
    println("  |             ")
    println("  |             ")
    println("  |             ")
    println(" /|\\")
    println("/ | \\")
}
fun printOneMistake(){
    println("  |------------|")
    println("  |            |")
    println("  |            O")
    println("  |             ")
    println("  |             ")
    println("  |             ")
    println(" /|\\")
    println("/ | \\")
}
fun printTwoMistakes(){
    println("  |------------|")
    println("  |            |")
    println("  |            O ")
    println("  |           /|\\ ")
    println("  |             ")
    println("  |             ")
    println(" /|\\")
    println("/ | \\")
}
fun printThreeMistakes(){
    println("  |------------|")
    println("  |            |")
    println("  |            O ")
    println("  |           /|\\ ")
    println("  |            | ")
    println("  |             ")
    println(" /|\\")
    println("/ | \\")
}
fun printFourMistakes(){
    println("  |------------|")
    println("  |            |")
    println("  |            O ")
    println("  |           /|\\ ")
    println("  |            | ")
    println("  |           / \\")
    println(" /|\\")
    println("/ | \\")
}
fun printFiveMistakes(){
    println("  |------------|")
    println("  |            |")
    println("  |            O ")
    println("  |           /|\\   ")
    println("  |            | ")
    println("  |           / \\")
    println(" /|\\      TTTTTTTTTTTT")
    println("/ | \\")
}
fun printSixMistakes(){
    println("  |------------|\t\tGAME OVER")
    println("  |            |")
    println("  |            |")
    println("  |            O ")
    println("  |           /|\\   ")
    println("  |            | ")
    println("  |       TT\\ / \\ /TTT")
    println(" /|\\         \\   /  ")
    println("/ | \\")
}
fun GameWon(){
    println("  |------------|\t\tCONGRATULATIONS ")
    println("  | ")
    println("  |             O ")
    println("  |            /|\\   ")
    println("  |             | ")
    println("  |            / \\")
    println(" /|\\      TTTTTTTTTTTT")
    println("/ | \\")
}


