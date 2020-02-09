package com.negm;

import java.util.Scanner;

public class Main {

    // Function to clear screen
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }


    public static void main(String[] args) throws Exception {
        /**
         * This is the main function
         * */

        String colFrom;
        String colTo;
        String cardName;
        /**
         * Declaring variables in order to store user input
         */


        OrderedStack orderedStack = new OrderedStack();
        /**
         * Declaring orderedStack class
         * */

        orderedStack.shuffleDeck();
        /**
         * calling shuffleDeck from orderedStack to shuffle the deck
         * */
        do {
            

            if (orderedStack.isDone()) {
                orderedStack.PrintBoard();
                System.out.println("Game is done");
                break;
            }
            orderedStack.PrintBoard();
            System.out.print("Command->> ");
            Scanner input = new Scanner(System.in);
            colFrom = input.next();
            if (colFrom.equals("rot")) {
                String colRot = input.next();
                orderedStack.colRotation(colRot);
            } else if (colFrom.equals("r")) {
                orderedStack.restart();
            } else {
                cardName = input.next();
                colTo = input.next();
                orderedStack.moveTo(colFrom, cardName, colTo);
            }
            cls();
        } while (!colFrom.equals("x"));
        {
            System.out.println("done...");
        }

    }
}
