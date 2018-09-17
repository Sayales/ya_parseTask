package com.sayales.inputs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pavel on 17.09.2018.
 */
public class ConsoleFolderProvider implements FolderProvider {
    @Override
    public Path getFolder() throws IOException {
        System.out.println("Input folder to save files");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path folder = Paths.get(reader.readLine());
        while (!Files.isDirectory(folder)) {
            System.out.println("Input valid directory");
            folder = Paths.get(reader.readLine());
        }
        return folder;
    }
}
