package tools

class Data {

  def load_data(path2data: String): Unit = {
    val file = io.Source.fromFile(path2data)
    val lines = file.getLines().next().split(",").toVector
    println("Header in file:", lines)
  }
}
