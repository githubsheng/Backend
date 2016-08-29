package task.two

object PrintResult {

  /**
   * get this from:
   * http://stackoverflow.com/questions/14921591/scala-option-map-to-another-option
   */
  implicit def toOption[T](x: T): Option[T] = Option(x)

  def printResult(foo: Foo) {
    val result: String = Option(foo) flatMap { _.getBar } flatMap { _.getBaz } flatMap { _.getResult } getOrElse "No Result"
    println(result)
  }

  def main(args: Array[String]) {
    
    //below are all kinds of possibilities
    val foo1 = new Foo(null)
    val foo2 = new Foo(new Bar(null))
    val foo3 = new Foo(new Bar(new Baz(null)))
    val foo4 = new Foo(new Bar(new Baz("Hello")))

    printResult(foo1)
    printResult(foo2)
    printResult(foo3)
    printResult(foo4)
  }

}