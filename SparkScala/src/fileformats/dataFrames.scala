package fileformats

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql._
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.DataFrameReader
import org.apache.spark.sql.DatasetHolder._

//created case class for pattern match to get expected Data
case class Abo(id: Int, v: (String, String))
case class Loc(id: Int, v: String)
  
object dataFrames {
  def main(args: Array[String]): Unit = {
    
// created customer address with Abo
   val as = List(Abo(101, ("Ruetli", "AG")), Abo(102,("Brelaz", "DemiTari")),
                Abo(103, ("Gress", "DemiTariVisa")), Abo(104, ("Schatten", "DemiTari")))
                
// created customer locations as destination with Loc 
   val ls = List(Loc(101, "Bern"), Loc(101, "Thun"), Loc(102, "Lausanne"), Loc(102, "Geneve"),
                Loc(102, "Nyon"), Loc(103, "Zurich"), Loc(103, "St-Gallen"), Loc(103, "Chur"))

//created SQLContext from sparkContext and this sparkContext linked with sparkConf
   val sparkConf = new SparkConf().setAppName("address").setMaster("local")
   val sc = new SparkContext(sparkConf)
   val sqlContext = new org.apache.spark.sql.SQLContext(sc)

//created setLog exceptions for ("WARN") 
   sc.setLogLevel("WARN")

//imported sqlContext implicits
  import sqlContext.implicits._

//created DataFrame for Abo and making toDF
  val abosDF = sc.parallelize(as).toDF
  println("Customer Address")
  abosDF.show()

//created DataFrame for Loc and making toDF
  val locationsDF = sc.parallelize(ls).toDF
  println("Destination Locations")
  locationsDF.show()

//created join transformation (join) and combined both abosDF and locationsDF with new Dataframe
  val trackedCustomersDF = abosDF.join(locationsDF, abosDF("id") === locationsDF("id"))
  println("combined both DataFrames (abosDF+locationsDF)")
  trackedCustomersDF.show()
 
//applied left_outer join for missing Data with help of new DataFrame
  val abosWithOptionalLocationsDF = abosDF.join(locationsDF, abosDF("id") === locationsDF("id"), "left_outer")
  println("applying left_outer join for missing locations customers data")
  abosWithOptionalLocationsDF.show()
  
 }
} 
  