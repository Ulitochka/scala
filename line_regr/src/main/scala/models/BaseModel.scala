package models

import breeze.linalg._
import breeze.numerics._

abstract class BaseModel {

  type data = DenseMatrix[Double]
  type data_vector = DenseVector[Double]

  def add_b(x: data): data = {
    val t = DenseMatrix.ones[Double](x.rows, 1)
    val x_b = DenseMatrix.horzcat(t, x)
    x_b
  }

  def predict(x: data, params: DenseVector[Double], add_bias: Boolean = true): DenseVector[Double] = {
    var features = x
    if (add_bias) {
      features = add_b(x)
    }
    val predictions = features * params
    predictions
  }

  def loss(y_test: DenseVector[Double], y_pred: DenseVector[Double]): Double = {
    val error_pow = pow(y_test - y_pred, 2)
    val error_pow_sum = sum(error_pow)
    val mse = error_pow_sum / y_test.length
    println(s"MSE: $mse")
    mse
  }

}
