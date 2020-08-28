package models
import breeze.linalg._


class Anal {

  type data = DenseMatrix[Double]

  def add_b(x: data): data = {
    val t = DenseMatrix.ones[Double](x.rows, 1)
    val x_b = DenseMatrix.horzcat(t, x)
    x_b
  }

  /**
   * Analytical linear regression. O(n3) where n is the number of features
   * @param x_train matrix with features
   * @return y_train matrix with labels
   */
  def solution(x_train: data, y_train: data): data =  {
    // add bias
    val x_train_bias = add_b(x_train)
    println(y_train.rows, y_train.cols)
    val parameters = inv(x_train_bias.t * x_train_bias) * x_train_bias.t * y_train
    parameters
  }

  def predict(x_test: data, params: data): DenseMatrix[Double] = {
    val x_test_bias = add_b(x_test)
    val predictions = DenseMatrix.zeros[Double](x_test_bias.rows, 1)

    for (i <- 0 until x_test_bias.rows) {
      val current_feature_vector = x_test_bias(i, ::)
      val prediction = sum(current_feature_vector * params)

      if (prediction < 0.0) {
        predictions(i, ::) := 0.0
      }
      else {
        predictions(i, ::) := prediction
      }
    }
    predictions
  }
}
