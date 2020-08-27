package models
import breeze.linalg._


class Anal {

  def solution(x_train: DenseMatrix[Double], y_train: DenseMatrix[Double]): Unit =  {
    val parameters = inv(x_train.t * x_train) * x_train.t * y_train
    
  }
}
