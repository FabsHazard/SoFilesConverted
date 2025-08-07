package com.microtechmd.blecomm.controller;

public class ScanResponseInfo {
    public boolean isAesInitialized;
    public boolean isBleNativePaired;

    public ScanResponseInfo(boolean z, boolean z2) {
        this.isBleNativePaired = z;
        this.isAesInitialized = z2;
    }

    public String toString() {
        return "ScanResponseInfo{isBleNativePaired=" + this.isBleNativePaired + ", isAesInitialized=" + this.isAesInitialized + '}';
    }
}
