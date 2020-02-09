package practice

import java.io.FileNotFoundException
import java.io.IOException
import org.apache.avro.file.FileReader
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.sql._

object Exception {
  def main(args: Array[String]) {
    try {
//          val f = new FileReader("C:/Users/a228912/Desktop/text.txt")
    }    catch {
      case ex: FileNotFoundException => {
        println("FileNotFoundException")
      }
      case ex: IOException => {
        println("IO Exception")
      }   
    }finally {
      println("Existing finaly....")
    }
  }
}