package com.dchans.api.common;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class GeocodingService {
    private static final String KAKAO_API_KEY = "6bd6a5842d734b26dc506568d850654b";
    private static final String KAKAO_API_URL = "https://dapi.kakao.com/v2/local/search/address.json";

    private final WebClient webClient;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GeocodingService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(KAKAO_API_URL).build();
    }

    public Map<String, Double> getCoordinates(String address) {
        try {
            String response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("query", address)
                            .build())
                    .header("Authorization", "KakaoAK " + KAKAO_API_KEY)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            JSONObject json = new JSONObject(response);
            JSONArray documents = json.getJSONArray("documents");

            System.out.println("API Key: " + KAKAO_API_KEY);
            System.out.println("Header: " + "KakaoAK " + KAKAO_API_KEY);

            if (!documents.isEmpty()) {
                JSONObject location = documents.getJSONObject(0);
                double latitude = location.getDouble("y");
                double longitude = location.getDouble("x");

                Map<String, Double> coordinates = new HashMap<>();
                coordinates.put("latitude", latitude);
                coordinates.put("longitude", longitude);

                return coordinates;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
