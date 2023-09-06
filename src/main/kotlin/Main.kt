import parser.DataParser
import parser.ReplacementParser

fun main()
{
    val url = "https://raw.githubusercontent.com/thewhitesoft/student-2023-assignment/main/data.json"
    val httpClient = HttpClient()
    httpClient.get(url)

    val dataFilePath = "data.json"
    val dataParser = DataParser()
    val messages = dataParser.parse(dataFilePath)

    val replacementFilePath = "replacement.json"
    val replacementParser = ReplacementParser()
    val replacements = replacementParser.parse(replacementFilePath)

    val fixer = MessageFixer()
    val fixedMessages = fixer.fix(messages,replacements)

    val resultCreator = ResultCreator()
    resultCreator.create(fixedMessages)
}