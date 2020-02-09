package practice

object Tuples {
  def main(args: Array[String]): Unit = {
    
    val t1 = ("Car", 600000)
    val (product, price) = t1
    
//    println(t1._1)
//    println(t1._2)
    
//    println(s"The Value of  $product is $price")
    
    val tList = List(("Car", 600000), ("Laptop", 60000), ("Mobile", 6000), ("Pen", 60))
    tList.foreach{ case (x,y) => println(s"The Value of $x is $y")}
    
//    tList.foreach{ case (x,y) => val hike = y+(0.1*y)}
//    println(s"Hiked Prices of $x After April will be $hike")}
  }
}