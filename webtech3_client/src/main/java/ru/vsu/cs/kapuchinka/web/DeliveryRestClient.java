package ru.vsu.cs.kapuchinka.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ru.vsu.cs.kapuchinka.Generator;
import ru.vsu.cs.kapuchinka.dto.GeoDto;

import java.io.IOException;

public class DeliveryRestClient {
    private static final String APP_URL = "http://localhost:8080/geo/add";
    private final ObjectMapper mapper = new ObjectMapper();

    public DeliveryRestClient() {
        mapper.registerModule(new JavaTimeModule());
    }



    public void post() throws IOException {
        GeoDto dto = generate();
        String json = mapper.writeValueAsString(dto);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(APP_URL);

        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
        client.close();
    }

    public void postBunch(int count) throws IOException {
        for (int i = 0; i < count; i++) {
            post();
        }
    }

    private GeoDto generate() {
        GeoDto geoDto = new GeoDto();
        geoDto.setNamePlace(Generator.generatePlace());
        geoDto.setNameProduct(Generator.generateProductName());
        geoDto.setTypeProduct(Generator.generateProductType());
        geoDto.setPolygon(Generator.generateRandomPolygon());
        return geoDto;
    }
}
