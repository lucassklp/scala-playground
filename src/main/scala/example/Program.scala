package example

import scala.util.{Try, Failure, Success, Random}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
case class Person(name: String, age: Option[Int] = None)

trait Fly {
  def fly()
}

trait Eat {
  def eat() = println("Eat")
}

class Bird extends Fly with Eat {
  override def fly(): Unit = println("Fly Bird")
}

class MyList[T] {
  def get: T = ???
}
object Program extends App {

  //implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global


  println("Hello World")
  val a = List()

  def soma(a: Int, b: Int) = a + b 

  var b = soma(1, 2)

  val person = Person("Lucas", Some(29))
  val person2 = Person("Lucas")

  println(person == person2)

  val bird = new Bird()
  bird.fly()
  bird.eat()

  def example(variable: Int => String) = variable(3)

  def callback(var1: Int) = String.valueOf(var1) + " - Teste"

  println(example(callback))

  val c = new Random(28734923).nextInt(100) // Random value
  val d = if (c > 100) "Maior que cem" else "Menor ou igual a cem" 

  val phrase = person match {
    case Person(name, None) => s"O nome da pessoa é: $name"
    case Person(name, Some(age)) => s"O $name tem $age anos"
    case _ => "Qualquer coisa"
  }

  println(phrase)

  val e = new MyList[Int]

  val f = Seq(1, 2, 3, 4)
  val g = Try {
    e.get
  }

  g match {
    case Failure(exception) => println("Falhou")
    case Success(value) => println(s"Deu certo O valor é $value!")
  }

  val either: Either[String, Int] = Left("Valor da String")
  either match {
    case Left(value) => s"String de valor $value"
    case Right(value) => s"Int de valor $value"
  }

  val future = Future.successful("Success - Funcionou!")
  def future1(s: String) = Future.successful(s)

  for {
    f0 <- future
    f1 <- future1(f0)
    _ = println(f1)
  } yield ()

  implicit def converToString(a: Int) = String.valueOf(a + "000")

  def teste1(x: String) = println(x)

  teste1(1)

}

// object => Singleton
// case class => Value class
// trait => Interface (??)
// class => Ref Class