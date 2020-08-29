import tools.DataTools
import tools.FeatureNormalizer
import models.AnalitLR, models.GradLR

object Pipeline {
  def main(args: Array[String]): Unit = {

    if (args.length == 0) {
      println("dude, i need at least one parameter")
    }

    val data_catalog: os.pwd.ThisType = os.pwd / "data".toString()
    val model_type: String = args(0)
    val model = None

    val data_tools = new DataTools()
    val feature_normalizer = new FeatureNormalizer(norm_type = "z-score")

    val (train, test) = data_tools.load_data(data_catalog + "/Dataset.csv")
    val (train_matrix, train_statistics) = feature_normalizer.get_statistics(train.map(_._1))
    val train_norm = feature_normalizer.normalize(train_matrix, train_statistics)
    val y_train = data_tools.transform_labels2matrix(train.map(_._2))

    val (test_matrix, _) = feature_normalizer.get_statistics(test.map(_._1))
    val test_norm = feature_normalizer.normalize(test_matrix, train_statistics)
    val y_test = data_tools.transform_labels2matrix(test.map(_._2))

    if (model_type == "analitic") {
      val model = new AnalitLR()
      val params = model.solution(train_norm, y_train)
      val predictions = model.predict(test_norm, params)
      model.loss(y_test, predictions)
    }
    else {
      val model = new GradLR()
      val params = model.run_grad_descent(train_norm, y_train)
      val predictions = model.predict(test_norm, params, add_bias = false)
      model.loss(y_test, predictions)
    }
  }
}
