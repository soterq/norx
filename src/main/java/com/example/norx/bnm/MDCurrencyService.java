package com.example.norx.bnm;

import com.example.norx.parcer.XMLStringToCurrency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MDCurrencyService {

    private final static String BNM_LINK = "https://www.bnm.md/en/official_exchange_rates?get_xml=1&date=%s";

    public static void main(String[] args) throws IOException, InterruptedException {
        getHttpCurrencyList("25.10.2021");

        System.out.println( getCurrencyListFromToday());
    }

    public static List<Currency> getHttpCurrencyList(String date) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(BNM_LINK, date)))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        String stringResponse = response.body().substring(
                response.body().indexOf("<Valute"), response.body().indexOf("</ValCurs>"));

        return XMLStringToCurrency.getCurrencyList(stringResponse);

    }

    public static List<Currency> getCurrencyListFromToday() throws IOException, InterruptedException {
        DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        return getHttpCurrencyList(LocalDateTime.now().format(timeColonFormatter));
    }
}
