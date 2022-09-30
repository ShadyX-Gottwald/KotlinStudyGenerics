package GenericsWeek9videoExample

fun main() {


}

/**Generics used in more than just classes and functions**/
interface  Comparable<TYPE> {
    operator fun compareTo(other: TYPE): Int
}

interface Sortable<TYPE> {
    fun compare(a: TYPE, b: TYPE): Int
}

interface RandomAccess<TYPE> {
    val size: Int
    operator fun get(index:Int): TYPE
    operator fun set(index:Int,item: TYPE): TYPE
}

//Idiomatic kotlin way of swapping in a sorting algorithm.
fun RandomAccess<Int>.sort() {
    (0 until size).forEach{i -> (i+1 until size).forEach{
        j -> if(this[i]!! < this[j]!!) {
            val temp = this[i]
        if (temp != null) {
            this[j] = temp
            this[i] = this[j]!!
        }
        }
    }}
}

fun <TYPE: Comparable<TYPE>> RandomAccess<TYPE>.sort1() {
    (0 until size).forEach{i -> (i+1 until size).forEach{
            j -> if(this[i] < this[j]) {

            //Idiomatic kotlin swapping
                this[i] = this[j].also { this[j] = this[i] }
            }
    }}
}

//One other way to
class MyLinkedList<T> (
   val comparator : (T,T) -> Int
        ): RandomAccess<T> , Sortable<T> {
    inner class Node(val value: T, var next: Node? = null)

    private var head: Node? = null

  override var size: Int  = 0
        private set



    fun insert(value: T) {
        head = Node(value,head)
        size++
    }

    override operator fun get(index: Int): T{
        var temp =head

        repeat(index) {
            temp = temp?.next
        }
        return temp?.value ?: throw Exception()
    }

    override fun set(index: Int, item: T): T {
        TODO("Not yet implemented")
    }

    override fun compare(a: T, b: T): Int {
        return comparator(a,b)
    }


}