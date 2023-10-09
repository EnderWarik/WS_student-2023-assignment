package actions

import models.Message
import models.Replacement

class MessageFixAction
{
    fun execute(messages: List<Message>, replacements: List<Replacement>): List<Message>
    {

        val result = messages.toMutableList()
        for (i in replacements.size - 1 downTo 0)
        {
            val replacement = replacements[i]
            if (replacement.source == null)
            {
                result.forEach { message: Message ->
                    if (message.message.contains(replacement.replacement))
                    {
                        message.message =
                            message.message.substringBefore(replacement.replacement) + message.message.substringAfter(
                                replacement.replacement
                            )
                    }
                }
            } else
            {
                result.forEach { message: Message ->
                    if (message.message.contains(replacement.replacement))
                    {
                        message.message = message.message.replace(replacement.replacement, replacement.source)
                    }
                }
            }

        }
        return result
    }

}