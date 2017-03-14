import spray.json.DefaultJsonProtocol

case class ResponseData(requestId: String, status: String, request: ResponseData, message: String)

object ResponseData extends DefaultJsonProtocol{

  implicit val responseDataFormat = jsonFormat4(RequestData.apply)

}
