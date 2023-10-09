package managers

import models.Message
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.io.InputStream

class FileManagerTest
{
    val manager = FileManager()

    @Test
    fun writeTest()
    {
        val data = "test data"
        val path = "test.txt"
        manager.write(data,path )

        val file =  File(path)
        val string=file.inputStream().bufferedReader().use { it.readText() }
        file.delete()

       assertEquals(string,data)
    }
    @Test
    fun writeListTest()
    {
        val data = listOf(Message("i message"), Message("i message 2"))
        val path = "test.txt"
        manager.write(data,path)

        val expected = "[\"i message\",\"i message 2\"]"
        val file =  File(path)
        val string=file.inputStream().bufferedReader().use { it.readText() }
        file.delete()

        assertEquals(string,expected)
    }
}