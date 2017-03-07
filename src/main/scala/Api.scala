import akka.actor.Actor
import spray.routing.HttpService
import scala.concurrent._

class SampleServiceActor extends Actor with SampleRoute {
  def actorRefFactory = context

  def receive = runRoute(route)
}

trait SampleRoute extends HttpService {

  import spray.httpx.SprayJsonSupport._
  import Stuff._
  import spray.http.MediaTypes

  implicit def executionContext: ExecutionContextExecutor = actorRefFactory.dispatcher

  var data = List(Stuff(1, "sample1"), Stuff(2, "sample2"))
  val route = path("get") {
    respondWithMediaType(MediaTypes.`application/json`) {
      get {
        complete(data)
      }
    }
  } ~
    path("add") {
      post {
        entity(as[Stuff]) { stuff =>
          complete(Stuff(stuff.id, stuff.data))
        }
      }
    } ~
    path("params") {
      get {
        parameters('req, 'opt.?) { (req, opt) =>
          complete(s"Req: $req, Opt: $opt")
        }
      }
    } ~
    get {
      path("pass"/ IntNumber) { index =>
        complete{
          index+"is passed"
        }
      }
    }~
    get {
      complete("localhost")
    }
}
