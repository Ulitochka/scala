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


}


