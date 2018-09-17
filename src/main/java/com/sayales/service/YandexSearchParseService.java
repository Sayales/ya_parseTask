package com.sayales.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Pavel on 17.09.2018.
 */
public class YandexSearchParseService implements ParseService {


    private ConstantProviderService constantService = new HardcodeConstantProviderService();

    @Override
    public String parseData(String parseUrl) throws IOException { //Return string has two delimiters: <newfile/> for another file and <prop/> to filename and cont
        Document doc = Jsoup.connect(parseUrl)
                .ignoreContentType(true)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .timeout(12000)
                .followRedirects(true).execute().parse();
        StringBuilder result = new StringBuilder();
        Elements searchTitles = doc.select(".serp-item");
        searchTitles.forEach(element -> {
            String title = element.selectFirst(".organic__url-text").text();
            Element urlElement = element.selectFirst(".organic__subtitle.organic__subtitle_overflow_yes.typo.typo_type_greenurl").selectFirst(".path.organic__path");
            Elements links = urlElement.select("a");
            String url = links.get(links.size() - 1).attr("href");
            String review = element.selectFirst(".extended-text__full").text();
            String newStringEntry = url + constantService.getPropertyDelimiter() + title + constantService.getPropertyDelimiter() + review + constantService.getFileDelimiter();
            result.append(newStringEntry);
        });
        String resultString = result.toString();

        return resultString;
    }
}
