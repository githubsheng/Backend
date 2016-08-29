package task.three

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt

object ConcurrencyIssue {

  def main(args: Array[String]): Unit = {
    val retFuture: Future[Integer] = Future{ 1 + 1 }
    retFuture.map { println(_) }
    Await.result(retFuture, 5000 millis)
  }

}