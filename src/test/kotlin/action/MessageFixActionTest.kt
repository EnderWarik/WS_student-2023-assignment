package action

import actions.MessageFixAction
import io.mockk.*
import models.Message
import models.Replacement
import org.junit.jupiter.api.Test

import kotlin.test.assertEquals

class MessageFixActionTest
{

    val fixer = MessageFixAction()
    @Test
    fun fixTest()
    {
        val messages = listOf<Message>(
            Message("I norm message"),
            Message("I notttt123 norm message"),
            Message("I xex message")
        )
        val replacement = listOf<Replacement>(
            Replacement( "notttt123 ", null ),
            Replacement( "xex", "norm" )
        )

        val expectedResult = listOf<Message>(
            Message("I norm message"),
            Message("I norm message"),
            Message("I norm message"))

        val res = fixer.execute(messages,replacement)

        assertEquals(expectedResult, res)
    }
}