import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import java.io.BufferedInputStream
import java.io.FileOutputStream

class HttpClient
{
    fun get(url: String)
    {
        val httpClient = HttpClients.createDefault()
        val httpGet = HttpGet(url)

        val response = httpClient.execute(httpGet)
        val entity = response.entity

        if (entity != null) {
            BufferedInputStream(entity.content).use { inputStream ->
                FileOutputStream("data.json").use { outputStream ->
                    val buffer = ByteArray(1024)
                    var bytesRead: Int
                    while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                        outputStream.write(buffer, 0, bytesRead)
                    }
                }
            }
        }

        response.close()
        httpClient.close()
    }
}