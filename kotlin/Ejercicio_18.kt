
fun main(){
    val palabras:List<String> = mutableListOf("Caballo, Perro, Mono")
    val palabras2:List<String> = listOf()
    println(palabras2)
    println(palabras)
    palabras.add("Caballo")
    palabras.addAll(palabras2)

    println("se retorna la palbras pedidadas")

}

private fun <E> List<E>.addAll(palabras2: List<String>): List<String> {
    return palabras2
}

private fun <E> List<E>.add(e: E): List<Any> {
    return letras

}


