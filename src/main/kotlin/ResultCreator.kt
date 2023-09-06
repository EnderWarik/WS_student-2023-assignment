import com.google.gson.Gson
import model.Message
import java.io.File

class ResultCreator
{
    private val RESULT_FILENAME = "result.json"

    fun create(messages: List<Message>)
    {
        val messagesAsString = messages.filter { it.message != "" }.map { it.message }
        val json = Gson().toJson(messagesAsString)
        File(RESULT_FILENAME).writeText(json)
    }
}