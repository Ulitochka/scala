import tools.Data

object Model {
  def main(args: Array[String]): Unit ={
    val data = new Data()
    data.load_data("/home/mikhail/IdeaProjects/line_regr/data/Dataset.csv")
  }
}
