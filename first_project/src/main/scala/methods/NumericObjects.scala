package methods
import scala.io.StdIn.{readLine}

object NumericObjects extends App {

  def crispsWeight(weight: BigDecimal, potatoWaterRatio: Double, crispsWaterRatio: Double): BigDecimal = {
    val k: BigDecimal = (weight * potatoWaterRatio)
    val j: BigDecimal = weight - k
    val result: BigDecimal = (j * 100) / (100 - (crispsWaterRatio * 100))
    // округление
    result.setScale(5, BigDecimal.RoundingMode.HALF_UP)
  }

  def calculate_byte_mask(args: Array[String]) {
    // Посчитайте число единиц в битовой записи числа, считанного с клавиатуры, и выведите на экран.
    val result = readLine().toInt.toBinaryString.replaceAll("0", "").length
  }

  // 90.0 0.9 0.1 -> 10
  // 100.0, 0.99, 0.98 -> 50
  val result = crispsWeight(90.0, 0.90, 0.1)
//  println(result)

  def fibs(num: Int): Int = {
    if (num < 3) 1
    else fibs(num - 1) + fibs(num - 2)
  }

}
