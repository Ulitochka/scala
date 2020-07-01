import data_loader.BaseDataLoader.{path2data, threshold => base_threshold}

object SenDataLoader extends App{
  val custom_path2data: String = path2data
  val threshold: Int = base_threshold
  println(custom_path2data, threshold)
}

