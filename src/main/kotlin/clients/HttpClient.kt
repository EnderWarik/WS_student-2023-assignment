package clients

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients

class HttpClient
{
    fun get(url: String): String
    {
        val httpClient = HttpClients.createDefault()
        val httpGet = HttpGet(url)

        val response = httpClient.execute(httpGet)
        val result = response.entity?.content?.bufferedReader()?.readText() ?: throw Exception("Response body is null")

        response.close()
        httpClient.close()

        return result
    }
}