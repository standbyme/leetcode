object Solution {

    def hsGroup(value: List[Int]): List[List[Int]] = value match{
        case Nil => Nil
        case (x :: xs) => {
            val (ys, zs) = xs.span(_ == x)
            (x :: ys) :: hsGroup(zs)
        }
    }

    def countAndSay(n: Int): String = {
        val expectedTime = n
        def helper(currentTime: Int,value: List[Int]): List[Int] = currentTime match{
            case currentTime if(currentTime==expectedTime) => value
            case currentTime => hsGroup(value).map(x => List(x.length, x.head)).flatten
        }
        helper(1,List(1)).mkString
    }
}