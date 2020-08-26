package tools
import breeze.linalg._
import breeze.stats._

class FeatureNormalizer(norm_type: String) {

  type data_type = List[List[Double]]
  type stat_type = Map[String, Transpose[DenseVector[Double]]]
  val preprocessing_type: String = norm_type

  /**
   * Creates a new DenseMatrix from data and map of data statistics.
   * @param data
   * @return a tuple of (matrix, statistics)
   */
  def get_statistics(data: data_type): (DenseMatrix[Double], stat_type) = {
    val matrix = DenseMatrix(data.map(_.toArray):_*)
    val statistics = Map(
      "mean" -> mean(matrix(::, *)),
      "min" -> min(matrix(::, *)),
      "max" -> max(matrix(::, *)),
      "std" -> stddev(matrix(::, *))
    )
  (matrix, statistics)
  }

  /**
   * Feature normalization.
   *  min-max normalization, z-score
   * @param data
   * @param statistics
   * @return a dense matrix
   */
  def normalize(data: DenseMatrix[Double], statistics: stat_type): DenseMatrix[Double] = {
    for (i <- 0 until data.cols) {
      val current_column = data(::, i)

      if (preprocessing_type == "min_max_norm") {
        data(::, i) := (current_column - statistics("min")(i)) / (statistics("max")(i) - statistics("min")(i))
      }
      else if (preprocessing_type == "z-score") {
        data(::, i) := (current_column - statistics("mean")(i)) / statistics("std")(i)
      }
    }
    println(data)
    data
  }

}
