package com.nyha.webfinal.resource;

import java.util.ResourceBundle;

public class MessageManager {
    private static final String RESOURCE = "messages";
    private static final ResourceBundle resourceBundle;

    static {
        resourceBundle = ResourceBundle.getBundle(RESOURCE);
    }

    private MessageManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}