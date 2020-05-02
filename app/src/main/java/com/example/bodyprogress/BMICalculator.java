package com.example.bodyprogress;

public class BMICalculator {
    private float BMI;
    private float paino;
    private float pituus;

    public BMICalculator(float paino, float pituus){
        this.BMI = 0;
        this.paino = paino;
        this.pituus = pituus;
    }
    public float getPaino(){
        return this.paino;
    }
    public float getPituus(){
        return this.pituus;
    }
    public float getBMI(){
        this.BMI = this.paino / ((this.pituus / 100) * (this.pituus / 100));
        return this.BMI;
    }
}
