package com.microtechmd.blecomm.entity;

import java.io.Serializable;
import java.util.Arrays;

public class BleMessage implements Serializable {
    private byte[] data;
    private MessageType messageType;
    private int operation;
    private int resCode;
    private boolean success;

    public enum MessageType {
        NORMAL,
        PAIR
    }

    public BleMessage(int i) {
        this(i, true, (byte[]) null);
    }

    public BleMessage(int i, boolean z) {
        this(i, z, (byte[]) null);
    }

    public BleMessage(int i, boolean z, byte[] bArr) {
        this.operation = i;
        this.success = z;
        this.data = bArr;
    }

    public BleMessage(int i, boolean z, byte[] bArr, int i2) {
        this.operation = i;
        this.success = z;
        this.data = bArr;
        this.resCode = i2;
    }

    public BleMessage(int i, boolean z, byte[] bArr, int i2, MessageType messageType2) {
        this.resCode = i2;
        this.operation = i;
        this.success = z;
        this.data = bArr;
        this.messageType = messageType2;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }

    public void setMessageType(MessageType messageType2) {
        this.messageType = messageType2;
    }

    public int getResCode() {
        return this.resCode;
    }

    public void setResCode(int i) {
        this.resCode = i;
    }

    public int getOperation() {
        return this.operation;
    }

    public void setOperation(int i) {
        this.operation = i;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public String toString() {
        return " {resCode=" + this.resCode + ", operation=" + Integer.toHexString(this.operation) + ", success=" + this.success + ", data=" + Arrays.toString(this.data) + ", messageType=" + this.messageType + '}';
    }
}
