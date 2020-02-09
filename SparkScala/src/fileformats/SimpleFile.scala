package fileformats

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf

case class Auth(auth_code: String, license_id: String, res_dist_name: String)

object SimpleFile {
  def main(args: Array [String]): Unit = {
    val conf = new SparkConf().setAppName("auth").setMaster("local")
    val sc = new SparkContext(conf)
        sc.setLogLevel("WARN")
        
    val source = scala.io.Source.fromFile("C:/Users/a228912/Desktop/datasets/auth.csv")
// val lines = source.getLines().drop(1)
//    val data = lines.map { line => 
//      val p = lines.split(" , ").mkString
//      Auth(p(0).toDouble, p(1).toInt, p(2).toDouble)
//    }.toArray
    source.take(1)
  }
}