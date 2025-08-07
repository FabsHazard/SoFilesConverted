package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public abstract class BaseEntry {
    private String dstOffset;
    private Boolean isTextTop;
    private Object mData;
    private Drawable mIcon;
    private String sensorId;
    private int timeOffset;
    private String timezone;
    private float y;

    public BaseEntry() {
        this.y = 0.0f;
        this.mData = null;
        this.mIcon = null;
    }

    public BaseEntry(float f) {
        this.mData = null;
        this.mIcon = null;
        this.y = f;
    }

    public BaseEntry(float f, Object obj) {
        this(f);
        this.mData = obj;
    }

    public BaseEntry(float f, Drawable drawable) {
        this(f);
        this.mIcon = drawable;
    }

    public BaseEntry(float f, Drawable drawable, Object obj) {
        this(f);
        this.mIcon = drawable;
        this.mData = obj;
    }

    public float getY() {
        return this.y;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public void setY(float f) {
        this.y = f;
    }

    public Object getData() {
        return this.mData;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setTimeOffset(int i) {
        this.timeOffset = i;
    }

    public int getTimeOffset() {
        return this.timeOffset;
    }

    public void setDstOffset(String str) {
        this.dstOffset = str;
    }

    public String getDstOffset() {
        return this.dstOffset;
    }

    public void setTimeZone(String str) {
        this.timezone = str;
    }

    public String getTimeZone() {
        return this.timezone;
    }

    public String getSensorId() {
        return this.sensorId;
    }

    public void setSensorId(String str) {
        this.sensorId = str;
    }

    public String getId() {
        return this.sensorId + this.timeOffset;
    }

    public Boolean getTextTop() {
        return this.isTextTop;
    }

    public void setTextTop(Boolean bool) {
        this.isTextTop = bool;
    }
}
