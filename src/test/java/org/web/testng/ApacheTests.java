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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApacheTests {

    private List<String> someList = new ArrayList<>();

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


    @Test
    public void testFormat() {
        Map<String, String> sMap = new HashMap<>();
        //key1
        sMap.put("key1", "value1");
        sMap.put("key2", "value2");
        sMap.put("key3", "value3");
        sMap.put("key11", "value11");
        sMap.put("key12", "value12");
        sMap.put("key13", "value13");
        sMap.put("key14", "a_value13");

        sMap.entrySet().stream()
                .filter(entry -> entry.getKey().contains("key1"))
                .forEach(entry -> System.out.println(entry.getValue()));

        System.out.println(sMap.values().stream().anyMatch(v -> v.contains("11")));
        System.out.println(sMap.values().stream().allMatch(v -> v.startsWith("value")));

        String result = sMap.values()
                .stream()
                .map(v -> "prefix_" + v)
                .collect(Collectors.joining(","));
        System.out.println(result);

        List<String> list = sMap.values().stream().map(v -> {
            someList.add(v);
            return  "a" + v;
        }).toList();

//        List<String> values = new ArrayList<>();


//        for (Map.Entry<String, String> e : sMap.entrySet()) {
//            if (e.getKey().contains("key1")) {
//                values.add(e.getValue());
//            }
//        }
//
//        for (String s : values) {
//            System.out.println(s);
//        }
    }
}
