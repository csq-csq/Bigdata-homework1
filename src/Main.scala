import scala.io.Source
import scala.collection.mutable
object Main {
  def main(args: Array[String]): Unit = {
    var map : mutable.Map[String,Int] = mutable.Map()
    var path="test.txt"
    var txt=Source.fromFile(path).mkString
    var q1 = "-\\s".r
    var replace1=q1 replaceAllIn(txt,"")//把跨行单词中间的分隔去掉
    val q2 = "[^a-zA-Z\\-]".r
    var replace2=q2 replaceAllIn(replace1," ")//把非字母串替换为空格,但是不要把正常的-给去掉
    var wild=replace2.split(" ")
    for(word <- wild){
      if(word!="" && word.length>1) {//注意不要统计非单词
        if (map.contains(word)) {
          map(word) = map(word)+1
        } else {
          map += (word -> 1)
        }
      }
    }
    map.foreach(println)//输出统计结果
  }
}