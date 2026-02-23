package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class NaverWeatherService {
    public static void main(String[] args) {
		NaverWeatherService n=new NaverWeatherService();
		n.getWeather();
	}
    public Map<String, String> getWeather() {
        Map<String, String> map = new HashMap<>();

        try {
            Document doc = Jsoup.connect(
                "https://weather.naver.com/today/09680630" // 서울
            ).get();

            String temp = doc.select(".temperature_text strong").text();
            String status = doc.select(".weather.before_slash").text();
            System.out.println(temp);
            System.out.println(status);
            map.put("temp", temp);
            map.put("status", status);

        } catch (Exception e) {
            map.put("temp", "N/A");
            map.put("status", "ERROR");
        }

        return map;
    }
}
