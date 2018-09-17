package com.sayales.service;

/**
 * Created by Pavel on 17.09.2018.
 */
public interface ConstantProviderService {
    String getFileExtension();

    //String delimiter for content of one file (URL,title,review)
    String getPropertyDelimiter();

    //String delimiter for new file (another search result)
    String getFileDelimiter();

}
