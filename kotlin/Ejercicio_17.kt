

fun main(args: Array<String>){
    var sumDigit = 0L
    var extNum: Long
    print("Ingrese un numero entero: ")
    var numEntero: Long = readLine()!!.toLong()
    while (numEntero != 0L) {
        extNum = numEntero % 10
        numEntero /= 10
        sumDigit += extNum
    }
    println("La suma de los digitos es: $sumDigit")



}