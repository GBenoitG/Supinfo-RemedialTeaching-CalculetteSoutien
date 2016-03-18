package com.supinfo.calculettesoutien.model;

/**
 * Created by Benoit on 10/03/2016.
 */
public class Calcul {

    private String calcul;
    private String result;

    public Calcul(String calcul, String result) {
        this.calcul = calcul;
        this.result = result;
    }

    public String getCalcul() {
        return calcul;
    }

    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
