package org.example.lesson04;


public class Area {

    public static double getArea(double a, double b, double c) {
        double s = (a + b + c) / 2.0;

        //Если это не треугольник - возвращаем 0.0

            if (a + b <= c || b + c <= a || a + c <= b) {
                return 0.0;
            } else {
                double x = ((s) * (s - a) * (s - b) * (s - c)); // herons formula
                return Math.sqrt(x);
            }
        }
    }

