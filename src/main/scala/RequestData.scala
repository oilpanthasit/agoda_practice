import spray.json.DefaultJsonProtocol

case class RequestData(sendTo: String, subject: String, body: String,fromName: Option[String]){
  require(sendTo != null, "please insert sendTo")
  require(subject != null, "please insert subject")
  require(body != null, "please insert body")
}


object RequestData extends DefaultJsonProtocol{

  implicit val requestDataFormat = jsonFormat4(RequestData.apply)

}
