package com.microtechmd.cgat;

import com.microtechmd.cgat.CGA;
import java.util.Date;

public class CgmAgp {
    private double[] aac;
    private double adrr = Double.NaN;
    private double[] auc;
    private Date beginDate;
    private double[] conga1;
    private double[] conga4;
    private double[] cv;
    private double[] dailyMean;
    private double[] dailyPrctile10;
    private double[] dailyPrctile25;
    private double[] dailyPrctile50;
    private double[] dailyPrctile75;
    private double[] dailyPrctile90;
    private double ehba1c = Double.NaN;
    private Date endDate;
    private double[][] glucose;
    private Integer glucoseCount;
    private CGA.GRADE grade;
    private CGA.Event[] hbgd;
    private double hbgi = Double.NaN;
    private Double hyper;
    private Double hypo;
    private double[] iqr;
    private double[] jindex;
    private double[] lage;
    private CGA.Event[] lbgd;
    private double lbgi = Double.NaN;
    private double[] mag;
    private CGA.MAGE[] mage;
    private double maxLage = Double.NaN;
    private double[] maxbg;
    private double[] mbg;
    private double meanLage = Double.NaN;
    private double[] minbg;
    private double[] modd;
    private double[] mvalue;
    private double[] num;
    private CGA.Pentagon[] pentagon;
    private double[] sdbg;
    private CGA.TIR tir;

    public Integer getGlucoseCount() {
        return this.glucoseCount;
    }

    public void setGlucoseCount(Integer num2) {
        this.glucoseCount = num2;
    }

    public Date getBeginDate() {
        return this.beginDate;
    }

    public void setBeginDate(Date date) {
        this.beginDate = date;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }

    public Double getHyper() {
        return this.hyper;
    }

    public void setHyper(Double d) {
        this.hyper = d;
    }

    public Double getHypo() {
        return this.hypo;
    }

    public void setHypo(Double d) {
        this.hypo = d;
    }

    public double[][] getGlucose() {
        return this.glucose;
    }

    public void setGlucose(double[][] dArr) {
        this.glucose = dArr;
    }

    public double[] getDailyMean() {
        return this.dailyMean;
    }

    public void setDailyMean(double[] dArr) {
        this.dailyMean = dArr;
    }

    public double[] getDailyPrctile10() {
        return this.dailyPrctile10;
    }

    public void setDailyPrctile10(double[] dArr) {
        this.dailyPrctile10 = dArr;
    }

    public double[] getDailyPrctile25() {
        return this.dailyPrctile25;
    }

    public void setDailyPrctile25(double[] dArr) {
        this.dailyPrctile25 = dArr;
    }

    public double[] getDailyPrctile50() {
        return this.dailyPrctile50;
    }

    public void setDailyPrctile50(double[] dArr) {
        this.dailyPrctile50 = dArr;
    }

    public double[] getDailyPrctile75() {
        return this.dailyPrctile75;
    }

    public void setDailyPrctile75(double[] dArr) {
        this.dailyPrctile75 = dArr;
    }

    public double[] getDailyPrctile90() {
        return this.dailyPrctile90;
    }

    public void setDailyPrctile90(double[] dArr) {
        this.dailyPrctile90 = dArr;
    }

    public CGA.Event[] getLbgd() {
        return this.lbgd;
    }

    public void setLbgd(CGA.Event[] eventArr) {
        this.lbgd = eventArr;
    }

    public CGA.Event[] getHbgd() {
        return this.hbgd;
    }

    public void setHbgd(CGA.Event[] eventArr) {
        this.hbgd = eventArr;
    }

    public double[] getNum() {
        return this.num;
    }

    public void setNum(double[] dArr) {
        this.num = dArr;
    }

    public double[] getMaxbg() {
        return this.maxbg;
    }

    public void setMaxbg(double[] dArr) {
        this.maxbg = dArr;
    }

    public double[] getMinbg() {
        return this.minbg;
    }

    public void setMinbg(double[] dArr) {
        this.minbg = dArr;
    }

    public double[] getMbg() {
        return this.mbg;
    }

    public void setMbg(double[] dArr) {
        this.mbg = dArr;
    }

    public double getEhba1c() {
        return this.ehba1c;
    }

    public void setEhba1c(double d) {
        this.ehba1c = d;
    }

    public double[] getMvalue() {
        return this.mvalue;
    }

    public void setMvalue(double[] dArr) {
        this.mvalue = dArr;
    }

    public double[] getSdbg() {
        return this.sdbg;
    }

    public void setSdbg(double[] dArr) {
        this.sdbg = dArr;
    }

    public double[] getCv() {
        return this.cv;
    }

    public void setCv(double[] dArr) {
        this.cv = dArr;
    }

    public double[] getJindex() {
        return this.jindex;
    }

    public void setJindex(double[] dArr) {
        this.jindex = dArr;
    }

    public double[] getIqr() {
        return this.iqr;
    }

    public void setIqr(double[] dArr) {
        this.iqr = dArr;
    }

    public CGA.TIR getTir() {
        return this.tir;
    }

    public void setTir(CGA.TIR tir2) {
        this.tir = tir2;
    }

    public double[] getAac() {
        return this.aac;
    }

    public void setAac(double[] dArr) {
        this.aac = dArr;
    }

    public double[] getAuc() {
        return this.auc;
    }

    public void setAuc(double[] dArr) {
        this.auc = dArr;
    }

    public double getLbgi() {
        return this.lbgi;
    }

    public void setLbgi(double d) {
        this.lbgi = d;
    }

    public double getHbgi() {
        return this.hbgi;
    }

    public void setHbgi(double d) {
        this.hbgi = d;
    }

    public double getAdrr() {
        return this.adrr;
    }

    public void setAdrr(double d) {
        this.adrr = d;
    }

    public CGA.GRADE getGrade() {
        return this.grade;
    }

    public void setGrade(CGA.GRADE grade2) {
        this.grade = grade2;
    }

    public double[] getLage() {
        return this.lage;
    }

    public void setLage(double[] dArr) {
        this.lage = dArr;
    }

    public double getMeanLage() {
        return this.meanLage;
    }

    public void setMeanLage(double d) {
        this.meanLage = d;
    }

    public double getMaxLage() {
        return this.maxLage;
    }

    public void setMaxLage(double d) {
        this.maxLage = d;
    }

    public CGA.MAGE[] getMage() {
        return this.mage;
    }

    public void setMage(CGA.MAGE[] mageArr) {
        this.mage = mageArr;
    }

    public double[] getMag() {
        return this.mag;
    }

    public void setMag(double[] dArr) {
        this.mag = dArr;
    }

    public double[] getConga1() {
        return this.conga1;
    }

    public void setConga1(double[] dArr) {
        this.conga1 = dArr;
    }

    public double[] getConga4() {
        return this.conga4;
    }

    public void setConga4(double[] dArr) {
        this.conga4 = dArr;
    }

    public double[] getModd() {
        return this.modd;
    }

    public void setModd(double[] dArr) {
        this.modd = dArr;
    }

    public CGA.Pentagon[] getPentagon() {
        return this.pentagon;
    }

    public void setPentagon(CGA.Pentagon[] pentagonArr) {
        this.pentagon = pentagonArr;
    }
}
