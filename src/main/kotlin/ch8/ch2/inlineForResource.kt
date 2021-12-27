package ch8.ch2

import java.io.BufferedReader
import java.io.StringReader
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun main(args: Array<String>) {
    val l: Lock = ReentrantLock()

    /* withLock */
//    public inline fun <T> Lock.withLock(action: () -> T): T {
//        contract { callsInPlace(action, InvocationKind.EXACTLY_ONCE) }
//        lock()
//        try {
//            return action()
//        } finally {
//            unlock()
//        }
//    }
    l.withLock {
        println("Action!")
    }


    /* try-with-resource */
//    public inline fun <T : Closeable?, R> T.use(block: (T) -> R): R {
//        contract {
//            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//        }
//        var exception: Throwable? = null
//        try {
//            return block(this)
//        } catch (e: Throwable) {
//            exception = e
//            throw e
//        } finally {
//            when {
//                apiVersionIsAtLeast(1, 1, 0) -> this.closeFinally(exception)
//                this == null -> {}
//                exception == null -> close()
//                else ->
//                    try {
//                        close()
//                    } catch (closeException: Throwable) {
//                        // cause.addSuppressed(closeException) // ignored here
//                    }
//            }
//        }
//    }
    BufferedReader(StringReader("try-with-resources\n-> use")).use { br ->
        var line: String? = ""
        while(line != null) {
            line = br.readLine()
            println(line)
        }
    }
}