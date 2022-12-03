package com.example.matematika;

public class Quetion {
    String savol,JA,JB,JC,JD,javob;

    public Quetion() {
    }

    public Quetion(String savol, String JA, String JB, String JC, String JD, String javob) {
        this.savol = savol;
        this.JA = JA;
        this.JB = JB;
        this.JC = JC;
        this.JD = JD;
        this.javob = javob;
    }

    public String getSavol() {
        return savol;
    }

    public void setSavol(String savol) {
        this.savol = savol;
    }

    public String getJA() {
        return JA;
    }

    public void setJA(String JA) {
        this.JA = JA;
    }

    public String getJB() {
        return JB;
    }

    public void setJB(String JB) {
        this.JB = JB;
    }

    public String getJC() {
        return JC;
    }

    public void setJC(String JC) {
        this.JC = JC;
    }

    public String getJD() {
        return JD;
    }

    public void setJD(String JD) {
        this.JD = JD;
    }

    public String getJavob() {
        return javob;
    }

    public void setJavob(String javob) {
        this.javob = javob;
    }
}
