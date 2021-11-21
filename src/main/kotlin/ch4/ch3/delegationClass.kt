package ch4.ch3

class DelegatingCollection1<T>: Collection<T> {
    private val innerList = arrayListOf<T>()
    override val size: Int
        get() = innerList.size

    override fun contains(element: T): Boolean = innerList.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)

    override fun isEmpty(): Boolean = innerList.isEmpty()

    override fun iterator(): Iterator<T> = innerList.iterator()
}

class DelegatingCollection2<T> (private val innerList: Collection<T> = ArrayList()): Collection<T> by innerList

class CountingSet<T> (private val innerSet: MutableCollection<T> = HashSet()): MutableCollection<T> by innerSet {
    var objectsAdded = 0
        private set

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()
    println(cset.addAll(listOf(1,2,3)))
    println("${cset.objectsAdded} objects are added, ${cset.size} remain")

    println(cset.addAll(listOf(1,2,3,4)))
    println("${cset.objectsAdded} objects are added, ${cset.size} remain")
}