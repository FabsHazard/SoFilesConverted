package com.microtechmd.blecomm.parser;

public class AidexXDeviceInfoEntity {
    private int days;
    private String edition;
    private int editionBuild;
    private int editionMajor;
    private int editionMinor;
    private int editionRevision;
    private int flag;
    private int hardWare;
    private String key;
    private int life;
    private int reserved;
    private int type;
    private String typeString;
    private int typeWithFlag;

    public AidexXDeviceInfoEntity(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, int i11, String str2, String str3) {
        this.hardWare = i;
        this.type = i2;
        this.typeWithFlag = i3;
        this.editionMajor = i4;
        this.editionMinor = i5;
        this.editionRevision = i6;
        this.editionBuild = i7;
        this.life = i8;
        this.reserved = i9;
        this.edition = str;
        this.flag = i10;
        this.days = i11;
        this.key = str2;
        this.typeString = str3;
    }

    public String toString() {
        return "AidexXDeviceInfoEntity{hardWare=" + this.hardWare + ", type=" + this.type + ", typeWithFlag=" + this.typeWithFlag + ", editionMajor=" + this.editionMajor + ", editionMinor=" + this.editionMinor + ", editionRevision=" + this.editionRevision + ", editionBuild=" + this.editionBuild + ", life=" + this.life + ", reserved=" + this.reserved + ", edition='" + this.edition + "', flag=" + this.flag + ", days=" + this.days + ", key='" + this.key + "', typeString='" + this.typeString + "'}";
    }

    public int getHardWare() {
        return this.hardWare;
    }

    public void setHardWare(int i) {
        this.hardWare = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getTypeWithFlag() {
        return this.typeWithFlag;
    }

    public void setTypeWithFlag(int i) {
        this.typeWithFlag = i;
    }

    public int getEditionMajor() {
        return this.editionMajor;
    }

    public void setEditionMajor(int i) {
        this.editionMajor = i;
    }

    public int getEditionMinor() {
        return this.editionMinor;
    }

    public void setEditionMinor(int i) {
        this.editionMinor = i;
    }

    public int getEditionRevision() {
        return this.editionRevision;
    }

    public void setEditionRevision(int i) {
        this.editionRevision = i;
    }

    public int getEditionBuild() {
        return this.editionBuild;
    }

    public void setEditionBuild(int i) {
        this.editionBuild = i;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int i) {
        this.life = i;
    }

    public int getReserved() {
        return this.reserved;
    }

    public void setReserved(int i) {
        this.reserved = i;
    }

    public String getEdition() {
        return this.edition;
    }

    public void setEdition(String str) {
        this.edition = str;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public int getDays() {
        return this.days;
    }

    public void setDays(int i) {
        this.days = i;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getTypeString() {
        return this.typeString;
    }

    public void setTypeString(String str) {
        this.typeString = str;
    }
}
