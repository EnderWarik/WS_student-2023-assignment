package parsers

import managers.FileManager
import models.Message
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class DataParserTest
{
    val parser = DataParser()
    val fileManager = FileManager()

    @Test
    fun parseTest()
    {
        val data = listOf(Message("i message"), Message("i message 2"))
        val path = "test.txt"
        fileManager.write(data,path)

        val res = parser.parse<String>(path).map { Message(it) }

        File(path).delete()

        assertEquals(data,res)
    }
}