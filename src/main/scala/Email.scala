import spray.json.DefaultJsonProtocol

case class Email(sendTo: String, subject: String, body: String,fromName: Option[String]){
  require(sendTo != null, "please insert sendTo")
  require(subject != null, "please insert subject")
  require(body != null, "please insert body")
}


object Email extends DefaultJsonProtocol{

  implicit val emailFormat = jsonFormat4(Email.apply)

}
