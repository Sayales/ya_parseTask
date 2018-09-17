package com.sayales.inputs;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Pavel on 17.09.2018.
 */
public interface FolderProvider {

    Path getFolder() throws IOException;
}
