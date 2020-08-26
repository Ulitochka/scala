import tools.Data
import tools.FeatureNormalizer

object Model {
  def main(args: Array[String]): Unit ={

    val data = new Data()
    val (train, test) = data.load_data("/home/mikhail/IdeaProjects/line_regr/data/Dataset.csv")

    val feature_normalizer = new FeatureNormalizer(norm_type="z-score")
    val (train_matrix, train_statistics) = feature_normalizer.get_statistics(train.map(_._1))
    val train_norm = feature_normalizer.normalize(train_matrix, train_statistics)

    val (test_matrix, _) = feature_normalizer.get_statistics(test.map(_._1))
    val test_norm = feature_normalizer.normalize(test_matrix, train_statistics)

  }
}
