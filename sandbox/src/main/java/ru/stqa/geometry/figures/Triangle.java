package ru.stqa.geometry.figures;

public class Triangle {

    private double a;
    private double b;
    private double c;

    public Triangle (double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter (){
        return this.a + this.b + this.c;
    }

    public double square (){
        double hP = this.perimeter() / 2.;
        return Math.sqrt(hP * (hP - this.a) * (hP - this.b) * (hP - this.c));
    }
}
