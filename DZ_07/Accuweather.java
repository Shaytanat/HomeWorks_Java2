package DZ_07;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Accuweather implements WeatherModel {
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS = "currentconditions";
    private static final String VERSION = "v1";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String FORECASTS = "forecasts";
    private static final String DAILY = "daily";
    private static final String FIVEDAY = "5day";

    private static final String API_KEY = "A5ev8m9YHDlE7MjsKAZiqEGBANUrVuWc";
    static OkHttpClient okHttpClient = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(String selectedCity, Period period) throws IOException {
        if (period == Period.NOW) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOCOL)
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS)
                    .addPathSegment(VERSION)
                    .addPathSegment(getCityKey(selectedCity))
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru")
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String responsebody = response.body().string();
            String degress = objectMapper.readTree(responsebody).get(0)
                    .at("/Temperature/Metric/Value").asText();
            //System.out.println(response.body().string());
            System.out.println("В городе - " + selectedCity + " : " + degress + " градусов по цельсию");
        }
        if (period == Period.FIVE_DAYS) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOCOL)
                    .host(BASE_HOST)
                    .addPathSegment(FORECASTS)
                    .addPathSegment(VERSION)
                    .addPathSegment(DAILY)
                    .addPathSegment(FIVEDAY)
                    .addPathSegment(getCityKey(selectedCity))
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            //TODO | Я  не смог вывести нормально прогноз на 5 дней, возможно надо в строковый массив
            //TODO | результаты записать, выяснить со временем можно но сроки сдачи и времени мало.
            //String responsebody = response.body().string();
            //String day1 = objectMapper.readTree(responsebody).get(0)
            //        .at("/DailyForecasts/Date").asText();
            //System.out.println(day1);
            System.out.println(response.body().string());
        }

    }

    public String getCityKey(String city) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", city)
                .addQueryParameter("language", "ru")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();
        String cityKey = objectMapper.readTree(responseBody).get(0).at("/Key").asText();
        return cityKey;
    }


}
