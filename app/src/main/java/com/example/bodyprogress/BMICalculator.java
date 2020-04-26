package com.example.bodyprogress;

public class BMICalculator {
    private double BMI;
    private double paino;
    private double pituus;

    public BMICalculator(double paino, double pituus){
        this.BMI = 0;
        this.paino = 0;
        this.pituus = 0;
    }
    public double getPaino(){
        return this.paino;
    }
    public double getPituus(){
        return this.pituus;
    }
    public double getBMI(){
        this.BMI = this.paino / ((this.pituus / 100) * (this.pituus / 100));
        return this.BMI;
    }
}
