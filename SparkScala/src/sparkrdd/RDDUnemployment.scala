package sparkrdd

import scalafx.application.JFXApp
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

case class Area(code: String, text: String)
case class Series(id: String, area: String, measure: String, title: String)
case class LAData(id: String, year: Int, period: Int, value: Double)

object RDDUnemployment extends JFXApp  {
  val conf = new SparkConf().setAppName("Temp Data").setMaster("local[*]")
  val sc = new SparkContext(conf)
  
  sc.setLogLevel("WARN")
  
  val areas = sc.textFile("C:/Users/a228912/Desktop/datasets/la.area").filter(!_.contains("area_type")).map { line =>
    val p = line.split("\t").map(_.trim)
    Area(p(1), p(2))
  }.cache()
  areas.take(5) foreach println
  
  val series = sc.textFile("C:/Users/a228912/Desktop/datasets/la.series").filter(!_.contains("area_code")).map { line =>
    val p = line.split("\t").map(_.trim)
    Series(p(0), p(2), p(3), p(6))
  }.cache()
  series.take(5) foreach println 
  
  val data = sc.textFile("C:/Users/a228912/Desktop/datasets/la.data.30.Minnesota").filter(!_.contains("year")).map { line =>
    val p = line.split("\t").map(_.trim)
    LAData(p(0), p(1).toInt, p(2).drop(1).toInt, p(3).toDouble)
  }.cache()
  data.take(5) foreach println
  
  val rates = data.filter(_.id.endsWith("03"))
  val decadeGroups = rates.map(d => (d.id, d.year/10) -> d.value)
  val decadeAverages = decadeGroups.aggregateByKey(0.0 -> 0)({ case ((s, c), d) =>
    (s+d, c+1)
  }, { case ((s1, c1), (s2, c2)) => (s1+s2, c1+c2) })
  decadeAverages.take(5) foreach println
  
  sc.stop()
}