package ru.stqa.geometry.figures;

public class Circle {

    private double R;

    public Circle(double R){
        this.R = R;
    }

    public double areaCircle (){
        return  Math.PI *  Math.pow (this.R,2);
    }
}
