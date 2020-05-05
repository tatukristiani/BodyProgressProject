package com.example.bodyprogress;

/**
 * Luokka sisältää BMI:n laskemiseen tarvittavan kaavan.
 * @author Tatu Pulkkinen
 * @version 2.5.2020
 */
public class BMICalculator {
    private float BMI;
    private float paino;
    private float pituus;

    public BMICalculator(float paino, float pituus){
        this.BMI = 0;
        this.paino = paino;
        this.pituus = pituus;
    }

    /**
     * Palauttaa painon, ei ole tarvittu tämän tekemisessä.
     * @return float paino.
     */
    public float getPaino(){
        return this.paino;
    }

    /**
     * Palauttaa pituuden, ei ole tarvittu tämän tekemisessä.
     * @return float pituus.
     */
    public float getPituus(){
        return this.pituus;
    }

    /**
     * palauttaa BMI arvon laskemalla sen kaavalla: paino jaettuna pituuden muunnos metreiksi kerrottuna itsellään.
     * @return float BMI
     */
    public float getBMI(){
        this.BMI = this.paino / ((this.pituus / 100) * (this.pituus / 100));
        return this.BMI;
    }
}
