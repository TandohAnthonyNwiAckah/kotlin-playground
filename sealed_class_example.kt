/**
* A sealed class in Kotlin is a special kind of class that restricts which
* classes can inherit from it.
*
* You can think of it as a class with a fixed set 
* of possible subclasses, all known at compile time.
*/

// Sealed class declaration
// A sealed class can have a **restricted set of subclasses**, all of which must be defined in the same file.
// This is useful when you want to represent a fixed hierarchy, like operation results.
sealed class OperationResult

// Subclasses of the sealed class
// Success represents a successful operation and holds some data
data class Success(val data: String) : OperationResult()

// Failure represents a failed operation and holds an error message
data class Failure(val error: String) : OperationResult()

// Loading represents a state where an operation is still in progress
// Singleton object, since only one instance is needed
object Loading : OperationResult()

// Function using 'when' to handle all possible cases
// When using a sealed class in a 'when' expression, the compiler knows all possible subclasses
// This allows you to handle all cases **without needing an 'else' branch**
fun handleResult(result: OperationResult) {
    when (result) {
        is Success -> println("Success! Data: ${result.data}")
        is Failure -> println("Failure. Error: ${result.error}")
        Loading -> println("Loading...")
    }
}

// Demo usage
fun main() {
    val results = listOf(
        Loading,
        Success("File uploaded successfully"),
        Failure("Network error")
    )

    // Iterate through the results and handle each one appropriately
    for (result in results) {
        handleResult(result)
    }
}
