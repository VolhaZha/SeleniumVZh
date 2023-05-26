package com.coherentsolutions.training.aqa.java.zhavrid.util;

public enum DownloadInfo {
    CONTENT_TYPE("Content-Type"),
    CONTENT_LENGTH("Content-Length");

    private final String header;

    DownloadInfo(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }


}
