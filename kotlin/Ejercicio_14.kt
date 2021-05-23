


private fun suma(num1: Array<Int>, num2: Array<Int>): Array<Int> {
    return num1 + num2
}

private fun multiplicar(num1: Array<Int>, num2: Array<Int>): Array <Int>{
    return num1 * num2
}

private operator fun <T> Array<T>.times(num2: Array<Int>): Array<Int> {
    return num2
}


fun Par(num: Array<Int>) {
    if (num % 2==0){
        println("el numero $num es par")
    }else{
        println("el numero $num es impar")
    }
}

private operator fun Any.rem(i: Int): Any {
    return 0

}

internal fun <T> Array<T>.rem(): Any {
    return Par(num = arrayOf(0))

}

fun main(args: Array<String>) {
    val numA = arrayOf(1,2,3,4,5,6)
    val numB = arrayOf(1,2,3,4,5,6)
    var resultadosum = suma(numA, numB )
    var resultadomultiplicar = multiplicar(numA, numB)

    println("el resultado de la suma es $resultadosum")
    println("el resultado de la multiplicacion es $resultadomultiplicar")


}


