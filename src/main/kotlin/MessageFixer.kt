import model.Message
import model.Replacement

class MessageFixer
{
    fun fix(messages: List<Message>, replacements: List<Replacement>): MutableList<Message>
    {

        val result = copyMessagesFrom(messages)
        for (i in replacements.size-1 downTo  0)
        {
            val replacement = replacements[i]
            if (replacement.source == null)
            {
                result.forEach { message: Message ->
                    if( message.message.contains(replacement.replacement))
                    {
                        message.message = message.message.substringBefore(replacement.replacement) + message.message.substringAfter(replacement.replacement)
                    }
                }
            }
            else
            {
                result.forEach{ message: Message ->
                    if(message.message.contains(replacement.replacement))
                    {
                        message.message = message.message.replace(replacement.replacement,replacement.source)
                    }
                }
            }

        }
        return result
    }

    fun copyMessagesFrom(messages: List<Message>): MutableList<Message>
    {
        val result = mutableListOf<Message>()

        for(message in messages)
        {
            result.add(Message(message.message))
        }
        return result
    }
}