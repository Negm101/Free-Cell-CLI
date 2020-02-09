package com.negm;

import java.util.Scanner;

/**
 * Main Class
 * 
 * @author Abdelrahman Elseayed Negm
 * @author Uzair
 * */
public class Main {

    /**
     * Function to clear a screen
     * 
     */
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    // Main Function
    public static void main(String[] args) throws Exception {

        // Declaring variables in order to store user input
        String colFrom;
        String colTo;
        String cardName;



        OrderedStack orderedStack = new OrderedStack();

        // calling shuffleDeck from orderedStack to shuffle the deck
        orderedStack.shuffleDeck();
        orderedStack.column9.push("s2");
        orderedStack.column9.push("sA");
        // this loop prints out the piles and columns as long as the game is not done
        do {// Start of loop


            // An if else statement to check if the game is finished
            if (orderedStack.isDone()) {
                orderedStack.printBoard();
                System.out.println("Game is done");
                break;
            }

            // Calling the PrintBoard method
            orderedStack.printBoard();
            System.out.print("Command->> ");

            /*
             * takes input from the user and checks
             * which command he or she want to run
             * */
            Scanner input = new Scanner(System.in);
            colFrom = input.next();

            // Rotates the columns
            if (colFrom.equals("rot")) {
                String colRot = input.next();
                orderedStack.colRotation(colRot);
            }

            // Restarts the game
            else if (colFrom.equals("r") || colFrom.equals("R") ) {
                orderedStack.restart();
            }
            // Exits the game
            else if (colFrom.equals("x") || colFrom.equals("X") ){
                System.out.println("You exited the game");
                break;
            }
            // Moves the card
            else {
                cardName = input.next();
                colTo = input.next();
                cardName = orderedStack.checkLowerCase(cardName);
                orderedStack.moveTo(colFrom, cardName, colTo);
            }
            // Loop ends and clears the screen
            cls();
        } while (!colFrom.equals("x"));{}
    }
}
