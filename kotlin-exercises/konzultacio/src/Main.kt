//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // nem valtoztathato, immutable, de nem muszaj helyben erteket kapjon
    val name = "Kotlin"

    // valtoztathato
    var number = 3
    number = 4

    // oda lehet irni a tipust, de nem muszaj
    // ha helyben erteket kap akkor tudja magatol a tipust
    var number2 : Int
    number2 = 4

    println(number)
    println("Szam: $number")
    println("Ez negy szam ${number + 5}")

    // arraylist
    val szamokImmutable = listOf<Int>(1, 2, 3) // immutable, nincs remove, add, meg kell adni a listat
    val szamokMutable = mutableListOf<Int>() // van remove, add, nem kell helyben erteket adni
    szamokMutable.add(2)
    szamokMutable.add(15)
    szamokMutable.add(3)
    for (value in szamokMutable) {
        println(value)
    }
    for (i in 0..<szamokMutable.size) {
        println(szamokMutable[i])
    }

    // tanarno igy szereti: lambda
    szamokMutable.forEach { t -> println(t) }
    // maskepp
    val kiir : (Int) -> Unit = { elem : Int -> println (elem) }
    szamokMutable.forEach(kiir)

    val szavakMutable = mutableListOf("A" , "Kutya" , "szep")
    szavakMutable.forEach { println(it) }


    val negativak = szamokMutable.map{ elem -> (-1)*elem}.filter { it % 2 == 0}
    negativak.forEach {println(it)  }
println(avg(4,5))

    print(osszeg(szamokMutable))
    val person1 = Person("Szili",24,false)
    print(person1)
}

fun avg (elso:Int, masodik:Int) : Double {
    return (elso+masodik)/2.0
}

fun szamokKiir (lista: List<Int>) : Unit {
    lista.forEach { print(it) }
}
fun osszeg (lista: List<Int>) : Int {
    var i=0
    lista.forEach {i+=it}
return i
    }

fun szamokOsszegeCompact(lista: List<Int>) = lista.sum() // Compact fügvény!
