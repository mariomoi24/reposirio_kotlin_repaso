import java.util.*
import kotlin.system.exitProcess

val letras = ('a'..'z') + "ñ"

fun escribeMensaje(mensaje: String) {
    for (i in 1..mensaje.length) print("*")
    println("\n$mensaje")
    for (i in 1..mensaje.length) print("*")
    println()
}

fun control(pal: String): Boolean {
    if (pal.length < 3) {
        println("Una palabra de al menos 3 letras. Inténtalo otra vez.")
        return false
    }
    pal.forEach {
        if (it !in letras) {
            println("Palabra no reconocida.")
            return false
        }
    }
    return true
}

fun getSecreta(): String {
    var enter: String
    when (val console = System.console()) {
        null -> {
            println("ERROR: No detectada consola. Compila y ejecuta desde consola.")
            exitProcess(-1)
        }
        else -> {
            do {
                val pw = console.readPassword("Introduce la palabra secreta: ")
                enter = pw.joinToString("").uppercase(Locale.getDefault())
            } while (!control(enter))
        }
    }
    return enter
}
fun inputLetra(): String {
    do {
        print("Una letra: ")
        val letra = readLine().toString().uppercase(Locale.getDefault())
        if (letra.length != 1 || letra.single() !in letras) {
            println("Letra no reconocida. Inténtalo otra vez.")
        } else {
            return letra
        }
    } while (true)
}
fun otra() {
    var otraPartida: String
    do {
        print("¿Otra partida? (S/N): ")
        otraPartida = readLine().toString().uppercase(Locale.getDefault())
    } while (otraPartida != "S" && otraPartida != "N")
    if (otraPartida == "S") {
        println( arrayOf("otra"))
    } else {
        escribeMensaje("GAME OVER")
    }
}

fun main(args:Array<String>) {
    if (args.isEmpty()) escribeMensaje("BIENVENIDO AL JUEGO DEL AHORCADO")
    val secreta = getSecreta()
    val oculta = Array(secreta.length) { "_" }
    oculta.forEach { print("$it ") }
    println()
    // JUEGO
    val letrasUsadas: MutableList<String> = mutableListOf()
    var error = 0
    var acierto = 0
    do { // bucle de pedir letra (hasta victoria o errores = 3)
        val letra = inputLetra()
        // comprueba si la letra ya se ha utilizado
        if (letrasUsadas.contains(letra)) {
            println("La letra $letra ya la has dicho.")
            print("Letras usadas: ")
            letrasUsadas.forEach { print("$it ") }
            println()
            oculta.forEach { print("$it ") }
            println()
        } else {
            letrasUsadas.add(letra)
            // comprueba si la letra es acierto o error
            if (letra in secreta) { // ACIERTO
                acierto++
                for (index in secreta.indices) {
                    if (letra == secreta[index].toString()) oculta[index] = letra  // oculta.set(index, letra)
                }
                oculta.forEach { print("$it ") }
                println()
                if (secreta == oculta.joinToString(separator = "")) { // if("_" !in oculta) if(oculta.all {it != "_"})
                    println("VICTORIA")
                    break
                }
            } else { // ERROR
                error++
                println("ERROR $error")
                if (error == 3) println("Has muerto en la horca. La palabra era $secreta")
            }
        }
    } while (error < 3)
    otra()
}




