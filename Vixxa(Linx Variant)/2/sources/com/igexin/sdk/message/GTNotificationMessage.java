package com.igexin.sdk.message;

public class GTNotificationMessage extends GTPushMessage {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public GTNotificationMessage() {
    }

    public GTNotificationMessage(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public GTNotificationMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f = str5;
        this.g = str6;
        this.e = str7;
    }

    public String getContent() {
        return this.d;
    }

    public String getIntentUri() {
        return this.g;
    }

    public String getMessageId() {
        return this.b;
    }

    public String getPayload() {
        return this.e;
    }

    public String getTaskId() {
        return this.a;
    }

    public String getTitle() {
        return this.c;
    }

    public String getUrl() {
        return this.f;
    }

    public void setContent(String str) {
        this.d = str;
    }

    public void setIntentUri(String str) {
        this.g = str;
    }

    public void setMessageId(String str) {
        this.b = str;
    }

    public void setPayload(String str) {
        this.e = str;
    }

    public void setTaskId(String str) {
        this.a = str;
    }

    public void setTitle(String str) {
        this.c = str;
    }

    public void setUrl(String str) {
        this.f = str;
    }
}
