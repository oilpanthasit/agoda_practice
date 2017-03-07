import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http

object Main extends App {
  implicit val system = ActorSystem("simple-service")

  val service = system.actorOf(Props[SampleServiceActor], "simple-service")

  lazy val host = Option(System.getenv("VCAP_APP_HOST")).getOrElse("localhost")
  lazy val port = Option(System.getenv("VCAP_APP_PORT")).getOrElse("8080").toInt
  IO(Http) ! Http.Bind(service, host, port = port)

}
