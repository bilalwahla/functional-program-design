package week1.json

/**
  * Documentation
  */
object JSONPlayground {
  def show(json: JSON): String = json match {
    case JSeq(elems) => "[" + (elems map show mkString ",") + "]"
    case JNum(num) => num.toString
    case JStr(str) => '\"' + str + '\"'
    case JBool(b) => b.toString
    case JNull => "null"
    case JObj(bindings) => val assocs = bindings map { case (k, v) => "\"" + k + "\": " + show(v) }
      "{" + (assocs mkString ", ") + "}"
  }

  def main(args: Array[String]): Unit = {
    val data = JObj(
      Map(
        "firstName" -> JStr("Bilal"),
        "lastName" -> JStr("Wahla"),
        "address" -> JObj(
          Map(
            "streetAddress" -> JStr("56 The Square"),
            "county" -> JStr("North Yorkshire"),
            "postcode" -> JStr("YO24 1UR")
          )
        ),
        "phoneNumbers" -> JSeq(
          List(
            JObj(
              Map(
                "type" -> JStr("home"),
                "number" -> JStr("07904 711778")
              )
            ),
            JObj(
              Map(
                "type" -> JStr("mobile"),
                "number" -> JStr("07904 711778")
              )
            )
          )
        )
      )
    )

    println(show(data))
  }
}
