package parsers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.InputStream

class DataParser
{
    inline fun <reified T> parse(filePath: String): List<T>
    {
        val inputStream: InputStream = File(filePath).inputStream()
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val replacementType = object : TypeToken<List<T>>() {}.type
        return Gson().fromJson(jsonString, replacementType)
    }

}