package com.microtechmd.blecomm.parser;

public class AidexXRawHistoryEntity {
    public float i1;
    public float i2;
    public int isValid;
    public int timeOffset;
    public float vc;

    public AidexXRawHistoryEntity(int i, float f, float f2, float f3, int i3) {
        this.timeOffset = i;
        this.i1 = f;
        this.i2 = f2;
        this.vc = f3;
        this.isValid = i3;
    }

    public String toString() {
        return "AidexXRawHistoryEntity{timeOffset=" + this.timeOffset + ", i1=" + this.i1 + ", i2=" + this.i2 + ", vc=" + this.vc + ", isValid=" + this.isValid + '}';
    }
}
