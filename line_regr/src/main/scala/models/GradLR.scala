package models

import breeze.linalg._
import breeze.numerics._
import breeze.plot._

import scala.collection.mutable.ArrayBuffer

class GradLR extends BaseModel() {

  val learning_rate = 0.1
  val max_its = 100
  val tmp_catalog: os.pwd.ThisType = os.pwd / "tmp".toString

  def grad_step(x: data, y: data_vector, phi: data_vector, learning_rate: Double): data_vector = {

    val predictions = predict(x, phi, add_bias = false)

    for (i <- 0 until x.cols) {
      val feature = x(::, i)
      val errors = (predictions - y) * feature
      phi(i) = phi(i) - (learning_rate * ((1.0 / x.rows) * sum(errors)))
    }
    phi
  }

  def compute_cost_function(x: data, y: data_vector, phi: data_vector): Double = {
    val predictions = x * phi
    val sq_errors = pow((predictions - y), 2)
    val cost_function = (1.0 / (2 * x.rows)) * sum(sq_errors)
    cost_function
  }

  def create_pot(cost_func: ArrayBuffer[Double]): Unit = {
    val f = Figure()
    val p = f.subplot(0)
    val x = linspace(0, max_its, max_its)
    val y = cost_func
    p += plot(x, y)
    p.xlabel = "iteration"
    p.ylabel = "loss"
    f.saveas(tmp_catalog + "/loss.png")
  }

  def run_grad_descent(x: data, y: DenseVector[Double]): data_vector = {
    val normal = breeze.stats.distributions.Gaussian(0, 1)
    var phi = DenseVector.rand(x.cols, normal)
    val cost_function = ArrayBuffer[Double]()

    for (i <- 0 until max_its) {
      phi = grad_step(x, y, phi, learning_rate)
      val current_cf = compute_cost_function(x, y, phi)
      cost_function += current_cf
      println(s"Iteration: $i; Cost_f: $current_cf")
    }
    create_pot(cost_function)
    phi
  }
}
