package com.sayales;

import com.sayales.inputs.ConsoleFolderProvider;
import com.sayales.inputs.ConsoleYandexSearchURLProvider;
import com.sayales.inputs.FolderProvider;
import com.sayales.inputs.URLProvider;
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
        URLProvider URLprovider = new ConsoleYandexSearchURLProvider();
        String parseUrl = URLprovider.getURL();
        FolderProvider folderProvider = new ConsoleFolderProvider();
        ResultSaver saver = new FileResultSaver(folderProvider.getFolder());
        ParseService service = new YandexSearchParseService();
        String parseResults = service.parseData(parseUrl);
        saver.saveResults(parseResults);
    }


}
