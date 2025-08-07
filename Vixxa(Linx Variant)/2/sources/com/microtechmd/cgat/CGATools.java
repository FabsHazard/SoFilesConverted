package com.microtechmd.cgat;

public class CGATools {
    private static final CGATools sInstance = new CGATools();

    public static native float[] smoothGauss(float[] fArr, int i, int i2);

    public static native float[] smoothMean(float[] fArr, int i, int i2);

    public native void destroy();

    public native double getAAC(double d, double d2, double d3);

    public native double getADRR();

    public native double getAUC(double d, double d2, double d3);

    public native double getCONGA(double d);

    public native double getCV();

    public native double[] getDailyTrendMean();

    public native double[] getDailyTrendPrctile(double d);

    public native double[] getGRADE(double d, double d2);

    public native double[] getHBGD(double d);

    public native double getHBGI();

    public native double getIQR();

    public native double getJIndex();

    public native double getLAGE();

    public native double[] getLBGD(double d);

    public native double getLBGI();

    public native double getMAG(double d);

    public native double[] getMAGE();

    public native double getMBG(double d, double d2);

    public native double getMODD();

    public native double getMValue();

    public native double getPT(double d, double d2);

    public native double getSDBG();

    public native int init(double[][] dArr);

    private CGATools() {
    }

    public static synchronized CGATools getInstance() {
        CGATools cGATools;
        synchronized (CGATools.class) {
            cGATools = sInstance;
        }
        return cGATools;
    }

    public Event getLBGD_Obj(double d) {
        double[] lbgd = getLBGD(d);
        return new Event(lbgd[0], lbgd[1]);
    }

    public Event getHBGD_Obj(double d) {
        double[] hbgd = getHBGD(d);
        return new Event(hbgd[0], hbgd[1]);
    }

    public GRADE getGRADE_Obj(double d, double d2) {
        double[] grade = getGRADE(d, d2);
        return new GRADE(grade[0], grade[1], grade[2], grade[3]);
    }

    public MAGE getMAGE_Obj() {
        double[] mage = getMAGE();
        return new MAGE(mage[0], mage[1]);
    }

    public class Event {
        public double meanDuration;
        public double times;

        public Event(double d, double d2) {
            this.times = d;
            this.meanDuration = d2;
        }
    }

    public class GRADE {
        public double grade;
        public double pctEu;
        public double pctHyper;
        public double pctHypo;

        public GRADE(double d, double d2, double d3, double d4) {
            this.grade = d;
            this.pctHypo = d2;
            this.pctEu = d3;
            this.pctHyper = d4;
        }
    }

    public class MAGE {
        public double decline;
        public double rise;

        public MAGE(double d, double d2) {
            this.rise = d;
            this.decline = d2;
        }
    }
}
