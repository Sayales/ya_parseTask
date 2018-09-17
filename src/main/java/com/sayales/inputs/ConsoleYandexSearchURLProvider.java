package com.sayales.inputs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Pavel on 17.09.2018.
 */
public class ConsoleYandexSearchURLProvider implements SearchURLProvider {

    @Override
    public String getSearchText() throws IOException {
        System.out.println("Input yandex search url");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String searchText = reader.readLine().trim();
      /*  while (!searchText.startsWith("http://www.yandex.ru/search/")) {
            System.out.println("Url should looks like \"http://www.yandex.ru/search/...\"");
            searchText = reader.readLine().trim();
         }*/
        return searchText;
    }
}
