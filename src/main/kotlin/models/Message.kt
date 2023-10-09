package models

class Message(var message: String)
{
    override fun toString(): String
    {
        return message
    }

    override fun equals(other: Any?): Boolean
    {
        return if (other is Message)
        {
            other.message == message
        }
        else false
    }
}

