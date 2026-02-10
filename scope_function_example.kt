/**
 * Scope functions in Kotlin allow you to perform multiple operations on an object
 * in a concise way. They can improve readability and reduce boilerplate.
 *
 * Common scope functions include [let], [run], [with], [apply], and [also],
 * each with slightly different behavior regarding the object context (`this`) 
 * or lambda result.
 */

data class Person(var name: String, var age: Int)

fun main() {
    
    val person = Person("Tony", 25).apply {
        age += 1           // configure
    }.also {
        println("Updated: $it") // side effect
    }

    val description = with(person) {
        "$name is $age years old"  // multiple operations
    }

    val length = person.name.let {
        it.length                   // transform value
    }

    println(description)  // Tony is 26 years old
    println(length)       // 4
}
