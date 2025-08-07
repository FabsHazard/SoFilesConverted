package com.microtechmd.cgat;

import com.github.mikephil.charting.utils.Utils;

public class CGA {
    private int colSize;
    private long cvPtr;
    private long dataPtr;
    private long mbgPtr;
    private int rowSize;
    private long sdbgPtr;
    private long selectedDataPtr;

    private native void constructor(double[][] dArr);

    private native void destructor();

    public native double getADRR();

    public native double[] getCONGA(double d);

    public native double[] getDailyTrendMean();

    public native double[] getDailyTrendPrctile(double d);

    public native double[] getGRADE(double d, double d2);

    public native double getHBA1C();

    public native double getHBGI();

    public native double[] getLAGE();

    public native double getLBGI();

    public native double[] getMAG(double d);

    public native double[][] getMAGE(double d);

    public native double[] getMODD();

    public native double[][] getPentagon();

    public native double[] getPeriodAAC(double d);

    public native double[] getPeriodAUC(double d);

    public native double[] getPeriodCV();

    public native double[][] getPeriodHBGD(double d);

    public native double[] getPeriodIQR();

    public native double[] getPeriodJIndex();

    public native double[][] getPeriodLBGD(double d);

    public native double[] getPeriodMAXBG();

    public native double[] getPeriodMBG();

    public native double[] getPeriodMINBG();

    public native double[] getPeriodMValue(double d);

    public native double[] getPeriodNUM();

    public native double[][] getPeriodPT(double[] dArr);

    public native double[] getPeriodSDBG();

    public native double[] selectPeriod(double d, double d2);

    public static class Event {
        public double meanDuration = Utils.DOUBLE_EPSILON;
        public double times = Utils.DOUBLE_EPSILON;

        public Event(double[] dArr) {
            if (dArr != null) {
                if (dArr.length > 0) {
                    this.times = (double) ((int) dArr[0]);
                }
                if (dArr.length > 1) {
                    this.meanDuration = dArr[1];
                }
            }
        }
    }

    public static Event[] toEvents(double[][] dArr) {
        int length;
        if (dArr == null || (length = dArr.length) == 0) {
            return null;
        }
        Event[] eventArr = new Event[length];
        for (int i = 0; i < length; i++) {
            eventArr[i] = new Event(dArr[i]);
        }
        return eventArr;
    }

    public static class GRADE {
        public double grade = Double.NaN;
        public double pctEu = Double.NaN;
        public double pctHyper = Double.NaN;
        public double pctHypo = Double.NaN;

        public GRADE(double[] dArr) {
            if (dArr != null) {
                this.grade = dArr[0];
                this.pctHypo = dArr[1];
                this.pctEu = dArr[2];
                this.pctHyper = dArr[3];
            }
        }
    }

    public static class TIR {
        public double[] range;
        public double[][] tir;

        public TIR(double[] dArr, double[][] dArr2) {
            this.range = dArr;
            this.tir = dArr2;
        }
    }

    public static class MAGE {
        public double average = Double.NaN;
        public double decline = Double.NaN;
        public double rise = Double.NaN;

        public MAGE(double[] dArr) {
            if (dArr != null) {
                this.average = dArr[0];
                this.rise = dArr[1];
                this.decline = dArr[2];
            }
        }
    }

    public static MAGE[] toMages(double[][] dArr) {
        int length;
        if (dArr == null || (length = dArr.length) == 0) {
            return null;
        }
        MAGE[] mageArr = new MAGE[length];
        for (int i = 0; i < length; i++) {
            mageArr[i] = new MAGE(dArr[i]);
        }
        return mageArr;
    }

    public static class Pentagon {
        public double area = Double.NaN;
        public double cv = Double.NaN;
        public double cv_mm = Double.NaN;
        public double intHyper = Double.NaN;
        public double intHyper_mm = Double.NaN;
        public double intHypo = Double.NaN;
        public double intHypo_mm = Double.NaN;
        public double mbg = Double.NaN;
        public double mbg_mm = Double.NaN;
        public double tor = Double.NaN;
        public double tor_mm = Double.NaN;

        public Pentagon(double[] dArr) {
            if (dArr != null) {
                this.tor = dArr[0];
                this.cv = dArr[1];
                this.intHypo = dArr[2];
                this.intHyper = dArr[3];
                this.mbg = dArr[4];
                this.tor_mm = dArr[5];
                this.cv_mm = dArr[6];
                this.intHypo_mm = dArr[7];
                this.intHyper_mm = dArr[8];
                this.mbg_mm = dArr[9];
                this.area = dArr[10];
            }
        }
    }

    public static Pentagon[] toPentagons(double[][] dArr) {
        int length;
        if (dArr == null || (length = dArr.length) == 0) {
            return null;
        }
        Pentagon[] pentagonArr = new Pentagon[length];
        for (int i = 0; i < length; i++) {
            pentagonArr[i] = new Pentagon(dArr[i]);
        }
        return pentagonArr;
    }

    public CGA(double[][] dArr) {
        constructor(dArr);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        destructor();
        super.finalize();
    }
}
