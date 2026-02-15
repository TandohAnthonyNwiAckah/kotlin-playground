import kotlinx.coroutines.*


 /**
  * What is a coroutine?
   * A coroutine is a lightweight thread-like construct that can run concurrently
    * with other coroutines. Unlike regular threads, coroutines are cheap to create,
    * can be suspended without blocking a thread (using 'delay', 'withContext', etc.),
    * and allow structured concurrency.
**/

// Entry point of the program
fun main() = runBlocking {
    println("=== GlobalScope Demo ===")
    // Launching a coroutine in the GlobalScope
    GlobalScope.launch {
        // This coroutine runs concurrently with the main thread
        println("GlobalScope: Coroutine start")
        
        // Suspend this coroutine for 500ms without blocking the main thread
        delay(500)
        
        println("GlobalScope: Coroutine end")
    }

    // This prints immediately, before the coroutine finishes
    println("GlobalScope: Main continues")
    
    // Delay the main coroutine to give the GlobalScope coroutine time to finish
    // Without this, the program might exit before "Coroutine end" prints
    delay(1000)

    println("=== GlobalScope Demo Finished ===")
}
