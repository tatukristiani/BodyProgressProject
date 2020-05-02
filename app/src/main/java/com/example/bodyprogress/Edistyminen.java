package com.example.bodyprogress;


public class Edistyminen {
    private String pvm;
    private int ika;
    private float paino;
    private float pituus;
    private float bmi;
    private String lisatietoja;


    public Edistyminen(String pvm, int ika, float paino, float pituus, float bmi, String lisatietoja) {
        this.pvm = pvm;
        this.ika = ika;
        this.paino = paino;
        this.pituus = pituus;
        this.bmi = bmi;
        this.lisatietoja = lisatietoja;

    }
    public String getPvm(){
        return this.pvm;
    }
    public int getIka(){
        return this.ika;
    }
    public float getPaino(){
        return this.paino;
    }
    public float getPituus(){
        return this.pituus;
    }
    public float getBmi(){
        return this.bmi;
    }
    public String getLisatietoja(){
        return this.lisatietoja;
    }

    @Override
    public String toString() {
        return this.pvm;
    }
}
