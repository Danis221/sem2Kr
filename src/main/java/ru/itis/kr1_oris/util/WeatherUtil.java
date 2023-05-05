package ru.itis.kr1_oris.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class WeatherUtil {

    static ObjectMapper mapper = new ObjectMapper();

    public static String apiKey = "6faded995f07a67bd6431a5176bb4640";

    public double getTemperature(String city){
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(connection.getInputStream())
                         )) {
                StringBuilder content = new StringBuilder();
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }

                JsonNode node = mapper.readTree(String.valueOf(content));
                String stringTemperature = String.valueOf(node.get("main").get("temp"));
                double result = Double.parseDouble(stringTemperature);
                return result - 273.15;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}