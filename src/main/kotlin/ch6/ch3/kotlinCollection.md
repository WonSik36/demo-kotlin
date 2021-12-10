# 코틀린 컬렉션

## 컬렉션 계층 구조
```
public interface Iterable<out T>
public interface MutableIterable<out T> : Iterable<T>

public interface Collection<out E> : Iterable<E>
public interface MutableCollection<E> : Collection<E>, MutableIterable<E>

public interface List<out E> : Collection<E>
public interface MutableList<E> : List<E>, MutableCollection<E>

public interface Set<out E> : Collection<E>
public interface MutableSet<E> : Set<E>, MutableCollection<E>

public interface Map<K, out V>
public interface MutableMap<K, V> : Map<K, V>
```

## 컬렉션 생성 함수

### List
```
// read only List
public fun <T> listOf(vararg elements: T): List<T>

// mutable List
public inline fun <T> mutableListOf(): MutableList<T> 
public inline fun <T> arrayListOf(): ArrayList<T>
```

### Set
```
// read only Set
public inline fun <T> setOf(): Set<T>

// mutable Set
public inline fun <T> mutableSetOf(): MutableSet<T>
public inline fun <T> hashSetOf(): HashSet<T>
public inline fun <T> linkedSetOf(): LinkedHashSet<T>
public fun <T> sortedSetOf(vararg elements: T): java.util.TreeSet<T>
```

### Map
```
// read only Map
public inline fun <K, V> mapOf(): Map<K, V>

// mutable Map
public inline fun <K, V> mutableMapOf(): MutableMap<K, V>
public inline fun <K, V> hashMapOf(): HashMap<K, V>
public inline fun <K, V> linkedMapOf(): LinkedHashMap<K, V>
public fun <K : Comparable<K>, V> sortedMapOf(vararg pairs: Pair<K, V>): SortedMap<K, V>
```