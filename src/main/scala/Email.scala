import spray.json.DefaultJsonProtocol


case class Data(sendTo: String, subject: String, body: String)


object EmailProtocol extends DefaultJsonProtocol{

  implicit val barFormat = jsonFormat3(Data)

}
