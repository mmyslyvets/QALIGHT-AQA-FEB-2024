package org.web.testng;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.net.URIBuilder;
import org.collections.web.dto.ResultsDto;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApacheTests {

    @Test
    public void testApacheClient() throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setPort(443);
        builder.setHost("randomuser.me");
        builder.setPath("/api");
        builder.setParameter("inc", "gender,name,nat");
        builder.setParameter("noinfo", null);

        HttpGet httpGet = new HttpGet(builder.build());

        ResultsDto dto = client.execute(httpGet, classicHttpResponse -> {
            return mapper().readValue(classicHttpResponse.getEntity().getContent(), ResultsDto.class);
        });
        System.out.println(dto.getResults().size());
    }

    public ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
