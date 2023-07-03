package com.coherentsolutions.training.aqa.java.zhavrid.util;

public enum PropertyKey {
    BROWSER("browser"),
    USER("user"),
    PASSWORD("password"),
    URLLOGIN ("URLlogin"),

    USERNAMESL("userNameSL"),
    ACCESSKEYSL("accessKeySL"),
    URLSL("urlSL");

    private final String key;

    PropertyKey (String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
