package GenericsWeek9videoExample

fun main(){

    val list1 = MyIntLinkedList<Int>()
    list1.insert(5)
    list1.insert(6)

    println(list1.get(0))

    (0 until list1.size).forEach{ println(list1[it]) }
    println(list1.size)

}

/**Without Generics redundant code is introduced.**/
class MyIntLinkedList<T>{
   inner class Node(val value: T, var next: Node? = null)

        private var head: Node? = null

    var size: Int  = 0
        private set



     fun insert(value: T) {
        head = Node(value,head)
        size++
    }

    operator fun get(index: Int): T?{
        var temp =head

        repeat(index) {
            temp = temp?.next
        }
        return temp?.value
    }


}