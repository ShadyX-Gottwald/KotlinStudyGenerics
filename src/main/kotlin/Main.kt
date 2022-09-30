fun main(args: Array<String>) {

    println(add(45.0f,45.0f))
    sort(listOf<Int>(34,45))
   println( copyWhenGreater(listOf("kotlin","java","Javaaa"),"java"))

    generic(5)
    genericExample<Int>(Int::class.java,45)

    //Different Return type with reified types.
//    genericMarks<String>(78)
//    println( genericMarks<Int>(5))
   // println( genericMarks<Int>("5"))

    val list = listOf<Long>(2,6,3,1)

    println(mergeSort(list))

}


/**Simple Generic Function to Inherit from Number super Class and return that type **/
private fun <T : Number> add(one: T,two: T):T{
    val addnumbers = one.toLong() + two.toLong()
    return addnumbers as T
}
/**Setting an upper bound restriction to the types allowed in the function.
 * types allowed must extend Comparable<T> .**/
private fun <T :Comparable<T>> sort(list: List<T>) {

    var temp: T
    // DoSomething ->
}
/**Simple Generic Implementation of a function that has Two upper bound Restrictions.
 * The function takes List<T> and compares the length of the threshold
 * or the Comparable type to the threshold > than.
 * **/
private fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}

/**Kotlin reified generic types. Prelude to reified types . type erasure **/
private inline fun <reified T> generic(value : T) {
    println(value)
    println("${T::class.java}")
}

private fun <T> genericExample(clazz: Class<T> ,value : T) {
    println(value)
   println("${clazz}")
}

 inline fun <reified T> genericMarks(marks: Any): T {
    return when(T::class.java) {
        Integer::class ,Int::class-> marks as T
        String::class -> "more than 90%" as T
        else -> "please enter valid type" as T
    }
}

fun mergeSort(data: List<Long>): List<Long> {
    if (data.size <= 1) return data
    val half = data.size / 2
    val leftData = mergeSort(data.take(half))
    val rightData = mergeSort(data.drop(half))
    var result = mutableListOf<Long>()
    var leftPointer = 0
    var rightPointer = 0
    while (leftPointer < leftData.size && rightPointer < rightData.size) {
        result.add(
            if (leftData[leftPointer] <= rightData[rightPointer])
                leftData[leftPointer++]
            else rightData[rightPointer++]
        )
    }
    return result + leftData.drop(leftPointer) + rightData.drop(rightPointer)
}
