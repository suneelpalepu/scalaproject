package iostream

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException

object ReadByte extends App {
  try {
    val fis = new FileInputStream("src/iostream/ReadByte.scala")
    try { 
  var byte = fis.read()
  while(byte >= 0) {
    print(byte+" ")
    byte = fis.read()
  }
  println()
    } catch {
      case e: IOException =>
      println("Something else went wrong with IO.")
      e.printStackTrace()
    } finally {
      fis.close()
    }
  } catch {
    case e:FileNotFoundException =>
      println("The File isn't There")
      e.printStackTrace()
    
  }
}