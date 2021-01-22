package org.example.lesson04test;

import org.example.lesson04.Area;
import org.junit.Test;


import static org.junit.Assert.*;

public class TestArea {

    // DELTA используется как порог
    // если разница между ожидаемым и фактическим результатом
    // меньше, чем delta - тест возвращает true.
    private static final double DELTA = 1e-15;

    @Test
    public void testGetArea(){
        double a = 3;
        double b = 4;
        double c = 5;
        assertEquals(6.0 , Area.getArea(a, b, c), DELTA);
        System.out.println("a=3, b=4, c=5 This is a triangle - Test is successful!");
    }

    @Test
    public void testGetArea2(){
        double a = 1;
        double b = 4;  // This can not be a triangle!The area is 0.0
        double c = 7;
        // The area will be 0.0 not 7.0 ! This is not a triangle!
        assertEquals(0.0 , Area.getArea(a, b, c), DELTA);
        System.out.println("a=1, b=4, c=7 This is NOT a triangle - Test is successful!");
    }

    @Test
    public void testGetArea3(){
        double a = 3;
        double b = 3;  // This can not be a triangle! The area is 0.0
        double c = 8;
        assertEquals(0.0 , Area.getArea(a, b, c), DELTA);
        System.out.println("a=3, b=3, c=8 This is NOT a triangle - Test is successful!");
    }
}
