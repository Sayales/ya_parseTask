package com.sayales.outputs;

import com.sayales.service.ConstantProviderService;
import com.sayales.service.HardcodeConstantProviderService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Pavel on 17.09.2018.
 */
public class FileResultSaver implements ResultSaver {

    private ConstantProviderService constantProvider = new HardcodeConstantProviderService();

    private Path folder;

    public FileResultSaver(Path path) {
        this.folder = path;
    }

    @Override
    public void saveResults(String results) throws IOException {
        String[] resultsArray = results.split(constantProvider.getFileDelimiter());
        for (int i = 0; i < resultsArray.length; i++) {
            Path newFile = createNewFile(String.valueOf(i));
            String[] contents = resultsArray[i].split(constantProvider.getPropertyDelimiter());
            for (String content : contents) {
                Files.write(newFile,content.getBytes(), StandardOpenOption.APPEND);
                Files.write(newFile, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
            }
        }
    }

    public Path getPath() {
        return folder;
    }

    public void setPath(Path path) {
        this.folder = path;
    }

    private Path createNewFile(String filename) throws IOException {
        String newFileStringPath = folder.toString() + File.separator + filename;
        Path newFile = Paths.get(newFileStringPath + constantProvider.getFileExtension());
        if (Files.exists(newFile)) {
            return Files.createFile(Paths.get(newFileStringPath + "_another" + constantProvider.getFileExtension()));
        }
        else {
            return Files.createFile(Paths.get(newFileStringPath + constantProvider.getFileExtension()));
        }
    }
}
