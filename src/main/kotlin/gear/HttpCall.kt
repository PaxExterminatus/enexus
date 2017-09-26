package gear

import app.*
import org.apache.http.util.EntityUtils
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients

class HttpCall(requestString: String) {
    var RequestUrl: String = ""
    var ResponseEntity: String = ""
    var ResponseStatusLine: String = ""
    var ResponseContentType: String = ""
    var ResponseContent: String = ""
    init {
        RequestUrl = requestString
        val httpClient = HttpClients.createDefault()
        val httpResp = httpClient.execute(HttpGet(requestString))
        val httpEntity = httpResp.entity
        ResponseStatusLine = httpEntity.toString()
        ResponseEntity = httpEntity.toString()
        ResponseContentType = httpEntity.contentType.toString()
        ResponseContent = EntityUtils.toString(httpEntity, CONTENT_CHARSET)
    }
}