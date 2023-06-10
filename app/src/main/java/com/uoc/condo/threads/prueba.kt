import kotlinx.coroutines.Delay
import java.util.concurrent.TimeUnit

// Extending the Thread class to implement threads.
class SimpleThread: Thread() {
    public override fun run() {
        println("3. ${Thread.currentThread()} this has been printed from SimpleThread.")

    }
}
// Implementing the Runnable interface to implement threads.
class SimpleRunnable: Runnable {
    override fun run() {

        println("5. Va a dormir 5 segundos")
        TimeUnit.SECONDS.sleep(5)
        println("6. ${Thread.currentThread()} Ya desperto luego de 5 segundos .")
    }
}
fun main(args: Array<String>) {
    val thread = SimpleThread()
    println("1. It will invoke a thread from the main thread")
    thread.start() // Will output: Thread[Thread-0,5,main] has run.

    println("2. It already returned to the main thread")

    val runnable = SimpleRunnable()

    val thread1 = Thread(runnable)
    thread1.start() // Will output: Thread[Thread-1,5,main] has run
    println("4. The execution has finished in the main thread.")
}