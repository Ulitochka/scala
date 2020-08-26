package tools

class Data {

  type data_set = (List[(List[Double], Double)], List[(List[Double], Double)])

  def transform2Double(line: String): Double = {
    try {
      line.toDouble
    } catch {
      case ex: NumberFormatException => 0.0
    }
  }

  def split_train_test(data: List[(List[Double], Double)]): data_set = {
    var i = 0
    val (train, test) = data.partition { _ =>
      i += 1
      i % 5 != 0
    }
    (train, test)
  }

  /**
   * Read data_set file and split data into train and test subsets.
   * @param path2data
   * @return a tuple of (train and test data)
   */
  def load_data(path2data: String): data_set = {
    val file = io.Source.fromFile(path2data)
    val names = file.getLines().next().split(",").toVector
    println("Header in file:", names)

    val lines = file.getLines()
    val dataset = lines.map { line =>
      val xs :+ y = line.split(",").toList.map(transform2Double)
      (xs, y)
    }.toList

    val (train, test): data_set = split_train_test(
      data = dataset)
    println("train= %s; test=%s;".format(train.size, test.size))

    (train, test)
  }
}
