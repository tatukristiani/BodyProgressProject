package com.example.bodyprogress;

/**
 * Luokka sisältää lisättävän edistyksen tiedot, joita voidaan hyödyntää laskettaessa BMI arvoa tai
 * vertaillessa tietoja.
 * @author Tatu Pulkkinen
 * @version 2.5.2020
 */

public class Edistyminen {
    private String pvm;
    private int ika;
    private float paino;
    private float pituus;
    private float bmi;
    private String lisatietoja;

    /**
     * Edistymisen konstruktoriin lisätään seuraavat tiedot.
     * @param pvm
     * @param ika
     * @param paino
     * @param pituus
     * @param bmi
     * @param lisatietoja
     */

    public Edistyminen(String pvm, int ika, float paino, float pituus, float bmi, String lisatietoja) {
        this.pvm = pvm;
        this.ika = ika;
        this.paino = paino;
        this.pituus = pituus;
        this.bmi = bmi;
        this.lisatietoja = lisatietoja;

    }

    /**
     * Palauttaa päivämäärän.
     * @return String pvm.
     */
    public String getPvm(){
        return this.pvm;
    }

    /**
     * Palauttaa iän.
     * @return int ika.
     */
    public int getIka(){
        return this.ika;
    }

    /**
     * Palauttaa painon.
     * @return float paino.
     */
    public float getPaino(){
        return this.paino;
    }

    /**
     * Palauttaa pituuden.
     * @return float pituus.
     */
    public float getPituus(){
        return this.pituus;
    }

    /**
     * palauttaa BMI arvon.
     * @return float bmi.
     */
    public float getBmi(){
        return this.bmi;
    }

    /**
     * Palauttaa lisatiedot.
     * @return String lisatietoja.
     */
    public String getLisatietoja(){
        return this.lisatietoja;
    }

    /**
     * Palauttaa itsestään pävämäärän.
     * @return String pvm.
     */
    @Override
    public String toString() {
        return this.pvm;
    }
}
