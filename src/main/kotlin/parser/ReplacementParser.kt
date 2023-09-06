package parser

import java.io.File
import java.io.InputStream
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import model.Replacement

class ReplacementParser
{
    fun parse(filePath: String): List<Replacement>
    {
        val inputStream: InputStream = File(filePath).inputStream()
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val replacementType = object : TypeToken<List<Replacement>>() {}.type
        return Gson().fromJson(jsonString, replacementType)
    }
}