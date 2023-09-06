package parser

import java.io.File
import java.io.InputStream
import com.google.gson.Gson
import model.Message

class DataParser
{
    fun parse(filePath: String): List<Message>
    {
        val inputStream: InputStream = File(filePath).inputStream()
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, Array<String>::class.java).map { Message(it) }
    }
}