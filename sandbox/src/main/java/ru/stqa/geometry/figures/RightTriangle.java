package ru.stqa.geometry.figures;

public class RightTriangle {

    private  double a;
    private double b;

    public RightTriangle (double a, double b){
        if (a < 0 || b < 0)
            throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    public double AreaRightTriangle (){
        return (this.a * this.b) / 2;
    }
}
