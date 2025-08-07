package com.huawei.hms.ml.scan;

import com.huawei.hms.scankit.p.w7;

public class HmsScanAnalyzerOptions {
    public final boolean errorCheck;
    public final int mode;
    public final boolean parseResult;
    public final boolean photoMode;
    public final int viewType;

    public static class Creator {
        private boolean errorCheck = false;
        private boolean parseResult = true;
        private boolean photoMode = false;
        private int type = 0;
        private int viewType = 0;

        public HmsScanAnalyzerOptions create() {
            return new HmsScanAnalyzerOptions(this.type, this.photoMode, this.viewType, this.errorCheck, this.parseResult);
        }

        public Creator setErrorCheck(boolean z) {
            this.errorCheck = z;
            return this;
        }

        public Creator setHmsScanTypes(int i, int... iArr) {
            int a = w7.a(i);
            this.type = a;
            if (iArr != null && iArr.length > 0) {
                this.type = w7.b(a);
                for (int b : iArr) {
                    this.type = w7.b(b) | this.type;
                }
            }
            return this;
        }

        public Creator setParseResult(boolean z) {
            this.parseResult = z;
            return this;
        }

        public Creator setPhotoMode(boolean z) {
            this.photoMode = z;
            return this;
        }

        public Creator setViewType(int i) {
            this.viewType = i;
            return this;
        }
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return super.hashCode();
    }

    private HmsScanAnalyzerOptions(int i, boolean z, int i2, boolean z2, boolean z3) {
        this.mode = i;
        this.photoMode = z;
        this.viewType = i2;
        this.errorCheck = z2;
        this.parseResult = z3;
    }
}
