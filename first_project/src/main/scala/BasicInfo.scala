import scala.io.StdIn

// чтобы не писать object Main
object BasicInfo extends App {

  // ТИПЫ ПЕРЕМЕННЫХ
  // если def и val ни разу не использовать, то они не будут вычислены
  val message_0: String = "Hello word!" // не можем менять значение, вычисляется 1 раз
  def message_1: String = "Hello word!" // вычисляются каждый раз, когда на них ссылкаются, запрещен import
  lazy val message_2: String = "Hello word!" // будет вычсилена в тот момент, когда вы сошлетесь на нее первый раз
  var message_3: Int = 1 // може менять значения
  val block_example: Unit = {
    val x = 1.0
    val d = Math.acos(x)
  }

  // ТИПЫ
  // Когда понижаем требования к типам переменных.
//  val x: AnyRef = 1 // AnyRef базовый тип всех ссылочных типов
//  val y: AnyVal = 1 // AnyRef базовый тип всех примитивных типов.

  // byte (8 бит /1 байт); short (16 бит /2 байт); Int (32 бит / 4 байт); Long (64 бит /8 байт);
  // Float (4 байта), Double (8 байт);
  // Char
  // Boolean
  // Unit - в return метода, который ничего не возвращает.
  // Int, BigInt
  // BigDecimal

  // Сравнение данных
//  val s3 = "bar"; val s1 = "foo" + s3; val s2 = "foo" + s3; println(s1 == s2);
//  val s4 = "foo"; val s5 = "foo"; println(s4 eq s5)

  // СТРОКИ
  def isCapital(word: String, pos: Int): Boolean = {
    // проверка, что первый символ строки в upper case
    val check_first_letter: Boolean = word.charAt(0) == word.toUpperCase().charAt(0)
    check_first_letter
  }

  def reverse_string(index1: Int, index2: Int, init_string: String): String = {
//    val Array(index1, index2) = readLine().split(" ").map(_.toInt)
//    val init_string: String = readLine()
    val slice_0: String = init_string.slice(0, index1)
    val slice_1: String = init_string.slice(index2 + 1, init_string.length)
    val slice_2: String = init_string.slice(index1, index2 + 1)
    val result: String = slice_0 + slice_2.reverse + slice_1
    result
  }
//  println(reverse_string(2, 6, init_string = "foobarbaz"))



  val name: String = "Russia"
  val simple_int: Int = 2
  val int2str: String = simple_int.toString
//  println(name.startsWith("a"), name.endsWith("b"), name.contains("bb"))

  // для регулярных выражений
  val simple_regex = "a+b+".r
//  println(name.matches("a+b+"))

  val simple_string: String = s"Some text $name"
  val many_strings: String =
    """
      |a
      |b
      |c
      |""".stripMargin
//  println(many_strings)

}


