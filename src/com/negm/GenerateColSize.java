package com.negm;

import java.util.Random;
/**
 * This class generates a random column size
 * between 6 and 7 and then OrderedStack uses
 * it to set a size for each column
 *
 * */
public class GenerateColSize {

    // Declaring variables
    public int min = 6;
    public int max = 7;
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
    /**
     * rand returns a random number between min and max
     * @param max maximum bound
     * @param min minimum bound
     * @return a random number between min and max
     * */
    public static int rand(int min, int max) {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }

        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * A method that returns column 1 size
     * @return column 1 size
     * */
    public int getcol1() {
        return col1;
    }

    /**
     * A method that returns column 1 size
     * @return column 2 size
     * */
    public int getcol2() {
        return col2;
    }

    /**
     * A method that returns column 1 size
     * @return column 3 size
     * */
    public int getcol3() {
        return col3;
    }

    /**
     * A method that returns column 1 size
     * @return column 4 size
     * */
    public int getcol4() {
        return col4;
    }

    /**
     * A method that returns column 1 size
     * @return column 5 size
     * */
    public int getcol5() {
        return col5;
    }

    /**
     * A method that returns column 1 size
     * @return column 6 size
     * */
    public int getcol6() {
        return col6;
    }

    /**
     * A method that returns column 1 size
     * @return column 7 size
     * */
    public int getcol7() {
        return col7;
    }

    /**
     * A method that returns column 1 size
     * @return column 8 size
     * */
    public int getcol8() {
        return col8;
    }
}
