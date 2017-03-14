import spray.json.DefaultJsonProtocol

case class ResponseData(requestId: String, status: String, request:RequestData, message: String)

object ResponseData extends DefaultJsonProtocol{

  implicit val responseDataFormat = jsonFormat4(ResponseData.apply)

}
