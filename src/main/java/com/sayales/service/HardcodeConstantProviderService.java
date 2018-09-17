package com.sayales.service;

import com.sayales.Constants;

/**
 * Created by Pavel on 17.09.2018.
 */
public class HardcodeConstantProviderService implements ConstantProviderService {

    @Override
    public String getFileExtension() {
        return Constants.EXTENSION;
    }

    @Override
    public String getPropertyDelimiter() {
        return Constants.PROPERTY_DELIMITER;
    }

    @Override
    public String getFileDelimiter() {
        return Constants.FILE_DELIMITER;
    }
}
