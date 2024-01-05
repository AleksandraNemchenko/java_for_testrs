package ru.stqa.geometry.figures;

import java.util.Objects;

public class Triangle {

    private double a;
    private double b;
    private double c;


    public Triangle (double a, double b, double c){

        if ( a < 0 || b < 0 || c < 0){
            throw new IllegalArgumentException("Triangle side shoud be non-negative");
        }
        if ( a > (b + c) || b > (a + c) || c > (a + b)){
            throw new IllegalArgumentException("The triangle inequality is violated");
        }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0
                || Double.compare(a, triangle.b) == 0 && Double.compare(b, triangle.c) == 0 && Double.compare(c, triangle.a) == 0
                || Double.compare(a, triangle.c) == 0 && Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.b) == 0;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
