package ch5.ch2

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


/**
 * TypesafeMap, TypeReference
 * Reference: https://www.youtube.com/watch?v=01sdXvZSjcI
 */
fun main(args: Array<String>) {
    val typesafeMap = TypesafeMap()

    typesafeMap.put(object: TypeReference<Int>(){}, 1)
    typesafeMap.put(object: TypeReference<String>(){}, "String")
    typesafeMap.put(object: TypeReference<List<Int>>(){}, listOf(1, 2, 3))
    typesafeMap.put(object: TypeReference<List<String>>(){}, listOf("alice", "bob", "chris"))
    typesafeMap.put(object: TypeReference<Map<String, List<String>>>(){}, mapOf("alice" to emptyList(), "bob" to listOf("alice", "bob", "chris")))

    println(typesafeMap.get(object: TypeReference<Int>(){}))
    println(typesafeMap.get(object: TypeReference<String>(){}))
    println(typesafeMap.get(object: TypeReference<List<Int>>(){}))
    println(typesafeMap.get(object: TypeReference<List<String>>(){}))
    println(typesafeMap.get(object: TypeReference<Map<String, List<String>>>(){}))
}

class TypesafeMap(private val map: MutableMap<TypeReference<*>, Any> = HashMap()) {
    fun <T: Any> put(tr: TypeReference<T>, value: T) {
        map[tr] = value
    }

    fun <T> get(tr: TypeReference<T>): T? {
        return if(tr.type is Class<*>) {
            @Suppress("UNCHECKED_CAST")
            val clazz = tr.type as Class<T>

            clazz.cast(map[tr])
        } else {
            val pt = tr.type as ParameterizedType

            @Suppress("UNCHECKED_CAST")
            val clazz = pt.rawType as Class<T>

            clazz.cast(map[tr])
        }
    }
}

open class TypeReference<T> {
    val type: Type

    init {
        val superType: Type = javaClass.genericSuperclass
        if (superType is ParameterizedType) {
            this.type = superType.actualTypeArguments[0]
        } else {
            throw IllegalArgumentException("Generic Type is not set")
        }
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) {
            return true
        }

        if(other == null || other !is TypeReference<*>) {
            return false
        }

        return type == other.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }

    override fun toString(): String {
        return "TypeReference<$type>"
    }
}
