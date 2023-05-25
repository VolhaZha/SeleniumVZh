package com.coherentsolutions.training.aqa.java.zhavrid.util;

public enum DownloadInfo {
    CONTENT_TYPE("Content-Type"),
    CONTENT_LENGTH("Content-Length");

    private final Object value;

    DownloadInfo(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
