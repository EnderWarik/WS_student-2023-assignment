package managers

import com.google.gson.Gson
import java.io.File

class FileManager
{
    fun write(data: String, fileName: String)
    {
        File(fileName).writeText(data)
    }

    fun <T> write(list: List<T>, fileName: String)
    {
        val listString = list.map { it.toString() }
        File(fileName).writeText(Gson().toJson(listString))
    }

}