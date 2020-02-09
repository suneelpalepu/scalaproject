package loops
//Capitalizing a list of strings

object ForExpressions {
  def main(args: Array [String]):Unit = {
// created names with starting small letters 
    val names = List("adam", "david", "frank")
    println("creating strings with starting small letter")
    names.foreach(println)
    
//capitalized strings with this for-expression 
    val ucNames = for (name <- names) yield name.capitalize
    println("applying for expression method to captilized their starting letter of Names")
    ucNames.foreach(println)
  }
}