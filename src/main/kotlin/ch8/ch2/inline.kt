package ch8.ch2

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}

fun runLambda (l: Lock) {
    println("Before sync")

    synchronized(l) {
        println("Action")
    }

    println("After sync")
}

fun runFunctionParameter (l: Lock, body :() -> Unit) {
    println("Before sync")
    synchronized(l, body)
    println("After sync")
}

inline fun synchronizedWithSaveLambdaAndRun(lock: Lock, noinline action: () -> Unit) {
    lock.lock()
    try {
        // Illegal usage of inline-parameter 'action' in
        // 'public inline fun <T> synchronizedWithSaveLambdaAndRun(lock: Lock, action: () -> Unit): Unit defined in ch8.ch2 in file inline.kt'.
        // Add 'noinline' modifier to the parameter declaration
        val lockSample = LockSample(action)
        lockSample.runBody()
    } finally {
        lock.unlock()
    }
}

class LockSample(val body: () -> Unit) {

    fun runBody() {
        body()
    }
}

fun main(args: Array<String>) {
    val l = ReentrantLock()

    runLambda(l)    // body is inlined
    runFunctionParameter(l) {   // body is not inlined
        println("Action")
    }
    synchronizedWithSaveLambdaAndRun(l) {
        println("Action")
    }
}

