import javax.swing.JOptionPane

fun main(args: Array<String>) {
   var texto=JOptionPane.showInputDialog("Ingrese un texto")
    if (texto!=null){
        texto.reverseOrder<String>(null)
        println("se ingreso texto")
    }
}

private fun <T> String.reverseOrder(nothing: Nothing?) {
    reverseOrder<String>(null)
}






