package models

import breeze.linalg._


class AnalitLR extends BaseModel() {

  /**
   * Analytical linear regression. O(n3) where n is the number of features
   *
   * @param x_train matrix with features
   * @return y_train matrix with labels
   */
  def solution(x_train: data, y_train: DenseVector[Double]): DenseVector[Double] = {
    // add bias
    val x_train_bias = add_b(x_train)
    val parameters = inv(x_train_bias.t * x_train_bias) * x_train_bias.t * y_train.toDenseVector
    parameters
  }

}
