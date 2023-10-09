package clients

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HttpClientTest
{

    //тут вопрос как правильно тест писать, у меня же клиент создается внутри метода, а значит я замокать его не могу.
    val client = HttpClient()
    @Test
    fun test()
    {
        val expected = "{\"count\":5555,\"name\":\"vadim\",\"age\":50}"
        val res = client.get("https://api.agify.io/?name=vadim")
       assertEquals(expected,res)
    }
}