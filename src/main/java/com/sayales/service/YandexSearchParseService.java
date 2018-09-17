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


    //В возвращаемой строке: constantService.getFileDelimiter() - граница файла и constantService.getPropertyDelimiter() - граница свойства (url, Заголовок, краткое описание)
    @Override
    public String parseData(String parseUrl) throws IOException {
        Document doc = Jsoup.connect(parseUrl)
                .ignoreContentType(true)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .timeout(12000)
                .followRedirects(true).execute().parse();
        StringBuilder result = new StringBuilder();

        Elements searchTitles = doc.select(".serp-item");
        searchTitles.forEach(element -> {
            Element titleElement = element.selectFirst(".organic__url-text");
            if (titleElement == null)
                return;
            String title = titleElement.text();
            Element urlLinksElement = element.selectFirst(".path.organic__path");
            Elements links = urlLinksElement.select("a");
            Element link = links.get(links.size()-1);
            String url = link != null ? link.attr("href") : "";
            Element reviewElement = element.selectFirst(".extended-text__full");
            if (reviewElement == null)
                reviewElement = element.selectFirst(".text-container.typo.typo_text_m.typo_line_m.organic__text");
            String review = reviewElement != null ? reviewElement.text() : "";
            String newStringEntry = url + constantService.getPropertyDelimiter() + title + constantService.getPropertyDelimiter() + review + constantService.getFileDelimiter();
            result.append(newStringEntry);
        });

        return result.toString();
    }
}
