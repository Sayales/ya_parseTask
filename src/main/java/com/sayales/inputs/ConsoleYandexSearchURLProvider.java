package com.sayales.inputs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Pavel on 17.09.2018.
 */
public class ConsoleYandexSearchURLProvider implements URLProvider {

    private static final String YA_URL = "http://yandex.ru/search/?text=";

    @Override
    public String getURL() throws IOException {
        System.out.println("Input yandex search url (http://yandex.ru/search/...) or search request");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        if (input.contains("yandex.ru/search/?"))
            return input;
        else
            return YA_URL + input;
    }
}
