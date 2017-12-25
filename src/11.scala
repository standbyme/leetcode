object Solution {
def maxArea(height: Array[Int]): Int = {
    def volume(heights: List[Int]): Int = (heights.length - 1)*(heights.head min heights.last)
    def helper(maxArea: Int,heights: List[Int]): Int = heights match{
        case m :: n :: Nil => maxArea max (m min n)
        case heights if (heights.head > heights.last) => helper((maxArea max (volume(heights))),heights.init)
        case heights => helper((maxArea max (volume(heights))),heights.tail)
    }

    helper(0, height.toList)
}
}