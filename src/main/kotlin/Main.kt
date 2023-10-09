import actions.MessageFixAction
import clients.HttpClient
import managers.FileManager
import models.Message
import models.Replacement
import parsers.DataParser

fun main()
{
    val url = System.getenv("GET_DATA_URL")
    val httpClient = HttpClient()
    val data = httpClient.get(url)

    val dataFilePath = "data.json"
    val fileManager = FileManager()
    fileManager.write(data, dataFilePath)

    val dataParser = DataParser()
    val messages: List<Message> = dataParser.parse<String>(dataFilePath).map { Message(it) }

    val replacementFilePath = "replacement.json"
    val replacements: List<Replacement> = dataParser.parse(replacementFilePath)

    val action = MessageFixAction()
    val correctedMessages = action.execute(messages, replacements).filter { it.message != "" }

    val resultFilePath = "result.json"
    fileManager.write(correctedMessages, resultFilePath)
}