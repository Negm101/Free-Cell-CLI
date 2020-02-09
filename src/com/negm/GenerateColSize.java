package com.negm; /*remove me when compiling using cmd
                    if compiling in IDE replace with your own domain*/

import java.util.Random;

public class GenerateColSize {

    public int min = 6;
    public int max = 7;
    public int deckSize = 8;
    public int col1;
    public int col2;
    public int col3;
    public int col4;
    public int col5;
    public int col6;
    public int col7;
    public int col8;


    GenerateColSize() {
        while (true) {
            col1 = rand(min, max);
            col2 = rand(min, max);
            col3 = rand(min, max);
            col4 = rand(min, max);
            col5 = rand(min, max);
            col6 = rand(min, max);
            col7 = rand(min, max);
            col8 = rand(min, max);
            if (col1 + col2 + col3 + col4 + col5 + col6 + col7 + col8 == 52) {
                break;
            }
        }

    }

    public static int rand(int min, int max) {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }

        return new Random().nextInt(max - min + 1) + min;
    }

    public int getcol1() {
        return col1;
    }

    public int getcol2() {
        return col2;
    }

    public int getcol3() {
        return col3;
    }

    public int getcol4() {
        return col4;
    }

    public int getcol5() {
        return col5;
    }

    public int getcol6() {
        return col6;
    }

    public int getcol7() {
        return col7;
    }

    public int getcol8() {
        return col8;
    }

    //to String function for testing purposes
    @Override
    public String toString() {
        return "GenerateColSize{" +
                "col1=" + col1 +
                ", col2=" + col2 +
                ", col3=" + col3 +
                ", col4=" + col4 +
                ", col5=" + col5 +
                ", col6=" + col6 +
                ", col7=" + col7 +
                ", col8=" + col8 +
                '}';
    }
}
