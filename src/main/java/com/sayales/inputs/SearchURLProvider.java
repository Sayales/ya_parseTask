package com.sayales.inputs;

import java.io.IOException;

/**
 * Created by Pavel on 17.09.2018.
 */
public interface SearchURLProvider {

    String getSearchText() throws IOException;

}
