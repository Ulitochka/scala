package methods

object CalculateProbability extends App {
  def normalDistribution(mu: Double, sigma: Double, x: Double): Double = {
    val r: Double = x - mu
    val h: Double = Math.pow(r, 2)
    val k: Double = 2 * Math.pow(sigma, 2)
    val j: Double = Math.exp(-(h / k))

    val u: Double = sigma * Math.sqrt((2 * Math.PI))
    val result: Double = j / u
    result
  }

  val result = normalDistribution(5.0, 6.0, x = 10.0)
  println(result)
}
