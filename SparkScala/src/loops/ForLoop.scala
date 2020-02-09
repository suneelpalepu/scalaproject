package loops
/* this is the basic For Loops programming 
 * in order to For you can see the how to use foreach method as well
 * we can use  FOR and FOREACH with help of MAP
 * code created by Suneel
 */
// in this loops iam putting for and foreach statements difference
//For is the purpose is to get the data with condition needed (x <- people) and println(x)
//instead of FOR you can also use the foreach method that’s available to Scala collections classes.
//foreach is available on most collections classes, including sequences, maps, and sets.

object ForLoop {
  def main(args: Array [String]):Unit = {
    val people = List("Bill", "Arpit", "Joy", "Nice", "Rassul", "Arjun")
//    for (x<-people) 
//    println(x)
//    people.foreach(println)

//Using for and foreach with Maps 
    val ratings = Map(
    "Lady in the Water"  -> 3.0, 
    "Snakes on a Plane"  -> 4.0, 
    "You, Me and Dupree" -> 3.5
    )
//    val frat = ratings.filter(s"frat: $filter")
    println("List of Movies and Ratings")  
//movie names and ratings using for like this
    for ((name,rating) <- ratings) println(s"Movie: $name, Rating: $rating")
//    frat.foreach(println)
//print the ratings with foreach
//    ratings.foreach {case(movie, rating) => println(s"key: $movie, value: $rating")}
  }
}