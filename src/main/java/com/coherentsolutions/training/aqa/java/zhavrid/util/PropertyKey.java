package com.coherentsolutions.training.aqa.java.zhavrid.util;

public enum PropertyKey {
    BROWSER("browser"),
    USER("user"),
    PASSWORD("password"),
    URLHUB("URLhub"),
    URLLOGIN ("URLlogin"),
    URLLOGOUT ("URLlogout");

    private final String key;

    PropertyKey (String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
