package com.sayales;

import com.sayales.inputs.ConsoleFolderProvider;
import com.sayales.inputs.ConsoleYandexSearchURLProvider;
import com.sayales.inputs.FolderProvider;
import com.sayales.inputs.SearchURLProvider;
import com.sayales.outputs.FileResultSaver;
import com.sayales.outputs.ResultSaver;
import com.sayales.service.ParseService;
import com.sayales.service.YandexSearchParseService;

import java.io.IOException;

/**
 * Created by Pavel on 17.09.2018.
 */
public class Main {

    public static void main(String... args) throws IOException {
        SearchURLProvider URLprovider = new ConsoleYandexSearchURLProvider();
        String parseUrl = URLprovider.getSearchText();
        FolderProvider folderProvider = new ConsoleFolderProvider();
        ParseService service = new YandexSearchParseService();
        String parseResults = service.parseData(parseUrl);
        ResultSaver saver = new FileResultSaver(folderProvider.getFolder());
        saver.saveResults(parseResults);
    }


}
