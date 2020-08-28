import breeze.linalg._
import breeze.numerics._
import tools.DataTools
import tools.FeatureNormalizer
import models.Anal

object Pipeline {
  def main(args: Array[String]): Unit = {

    val model_type: String = "anal"
    val model = None

    val data_tools = new DataTools()
    val feature_normalizer = new FeatureNormalizer(norm_type="z-score")

    val (train, test) = data_tools.load_data("/home/mikhail/IdeaProjects/line_regr/data/Dataset.csv")
    val (train_matrix, train_statistics) = feature_normalizer.get_statistics(train.map(_._1))
    val train_norm = feature_normalizer.normalize(train_matrix, train_statistics)
    val y_train = data_tools.transform_labels2matrix(train.map(_._2))

    val (test_matrix, _) = feature_normalizer.get_statistics(test.map(_._1))
    val test_norm = feature_normalizer.normalize(test_matrix, train_statistics)
    val y_test = data_tools.transform_labels2matrix(test.map(_._2))

    if (model_type == "anal") {
      val model = new Anal()
      val params = model.solution(train_norm, y_train)
      val predictions = model.predict(test_norm, params)
      loss(y_test, predictions)
    }

  }

  def loss(y_test: DenseMatrix[Double], y_pred: DenseMatrix[Double]) = {
    val error_pow = pow(y_test - y_pred, 2)
    val error_pow_sum = sum(error_pow)
    val mse = error_pow_sum / y_test.rows
    println(s"MSE: $mse")
  }


}
