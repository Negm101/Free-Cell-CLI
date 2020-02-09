package com.negm;

import java.util.*;

public class OrderedStack {
    public ArrayList<String> deck = new ArrayList<String>(
            Arrays.asList("cA", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "cJ", "cQ", "cK",
                    "dA", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "dJ", "dQ", "dK",
                    "hA", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "hJ", "hQ", "hK",
                    "sA", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "sJ", "sQ", "sK"));
    public ArrayList<String> deckCopy = new ArrayList<String>(deck);
    public Stack<String> pileC = new Stack<String>();
    public Stack<String> pileD = new Stack<String>();
    public Stack<String> pileH = new Stack<String>();
    public Stack<String> pileS = new Stack<String>();
    public Stack<String> column1 = new Stack<String>();
    public Stack<String> column2 = new Stack<String>();
    public Stack<String> column3 = new Stack<String>();
    public Stack<String> column4 = new Stack<String>();
    public Stack<String> column5 = new Stack<String>();
    public Stack<String> column6 = new Stack<String>();
    public Stack<String> column7 = new Stack<String>();
    public Stack<String> column8 = new Stack<String>();
    public Stack<String> column9 = new Stack<String>();
    public GenerateColSize size = new GenerateColSize();
    public Random rd = new Random();


    public OrderedStack() {
    }

    public void moveTo(String colFrom, String cardName, String colTo) {
        if (colTo.equals("h") || colTo.equals("c") || colTo.equals("s") || colTo.equals("d")) {
            if (cardName.compareTo(getTopCard(colFrom)) == 0) {
                pilePush(cardName, colTo, colFrom);
            } else
                System.out.println("Invalid check card");
        } else if (isValidCol(colTo)) {
            if (cardName.compareTo(getTopCard(colFrom)) == 0) {
                colPush(cardName, colTo);
                popFrom(colFrom);

            } else
                System.out.println("Invalid check card");
        } else {
            System.out.println("Invalid column or pile move");
        }
    }

    public void colPush(String cardName, String colTo) {
        System.out.println(colTo);
        if (isAllEmpty()) {
            pushTo(colTo, cardName);
        }
        if (isValidCol(colTo)) {
            if (getCardValue(Character.toString(getTopCard(colTo).charAt(1))) == getCardValue(Character.toString(cardName.charAt(1))) + 1) {
                pushTo(colTo, cardName);
            } else
                System.out.println("Illegal move");
        }
    }

    public void pilePush(String cardName, String colTo, String colFrom) {
        Character temp = cardName.charAt(0);
        if ((temp == 'c' && (getCardValue(getTopCard(colTo)) == getCardValue(Character.toString(cardName.charAt(1))) - 1)) && colTo.equals("c")) {
            pileC.push(cardName);
            popFrom(colFrom);
        } else if
        ((temp == 'h' && (getCardValue(getTopCard(colTo)) == getCardValue(Character.toString(cardName.charAt(1))) - 1)) && colTo.equals("h")) {
            pileH.push(cardName);
            popFrom(colFrom);
        } else if
        (((temp == 's' && (getCardValue(getTopCard(colTo)) == getCardValue(Character.toString(cardName.charAt(1))) - 1)) && colTo.equals("s"))) {
            pileS.push(cardName);
            popFrom(colFrom);
        } else if
        ((temp == 'd' && (getCardValue(getTopCard(colTo)) == getCardValue(Character.toString(cardName.charAt(1))) - 1)) && colTo.equals("d")) {
            pileD.push(cardName);
            popFrom(colFrom);
        } else {
            System.out.println("Illegal move");
        }
    }


    public void pushTo(String colTo, String cardName) {
        switch (colTo) {
            case "1":
                column1.push(cardName);
                break;
            case "2":
                column2.push(cardName);
                break;
            case "3":
                column3.push(cardName);
                break;
            case "4":
                column4.push(cardName);
                break;
            case "5":
                column5.push(cardName);
                break;
            case "6":
                column6.push(cardName);
                break;
            case "7":
                column7.push(cardName);
                break;
            case "8":
                column8.push(cardName);
                break;
            case "9":
                column9.push(cardName);
                break;
            case "c":
                pileC.push(cardName);
                break;
            case "d":
                pileD.push(cardName);
                break;
            case "h":
                pileH.push(cardName);
                break;
            case "s":
                pileS.push(cardName);
                break;
            default:
                System.out.println("error: at pushTo method");
        }
    }

    public void popFrom(String colFrom) {
        switch (colFrom) {
            case "1":
                column1.pop();
                break;
            case "2":
                column2.pop();
                break;
            case "3":
                column3.pop();
                break;
            case "4":
                column4.pop();
                break;
            case "5":
                column5.pop();
                break;
            case "6":
                column6.pop();
                break;
            case "7":
                column7.pop();
                break;
            case "8":
                column8.pop();
                break;
            case "9":
                column9.pop();
                break;
            default:
                System.out.println("error: at popFrom method");
        }
    }

    public String getTopCard(String columnNum) {
            switch (columnNum) {
                case "1":
                    return column1.peek();
                case "2":
                    return column2.peek();
                case "3":
                    return column3.peek();
                case "4":
                    return column4.peek();
                case "5":
                    return column5.peek();
                case "6":
                    return column6.peek();
                case "7":
                    return column7.peek();
                case "8":
                    return column8.peek();
                case "9":
                    if (column9.isEmpty()) {
                        return "0";
                    } else
                        return column9.peek();
                case "c":
                    if (pileC.isEmpty())
                        return "";
                    else return pileC.peek();
                case "d":
                    if (pileD.isEmpty())
                        return "0";
                    else return pileD.peek();
                case "h":
                    if (pileH.isEmpty())
                        return "0";
                    else return pileH.peek();
                case "s":
                    if (pileS.isEmpty())
                        return "0";
                    else return pileS.peek();
                default:
                    return "error: at getTopCard method";
            }

    }

    public int getCardValue(String n) {
        System.out.println("getCardValue: " + n);
        Map<String, Integer> cardValue = new HashMap<>();
        cardValue.put("A", 1);
        cardValue.put("2", 2);
        cardValue.put("3", 3);
        cardValue.put("4", 4);
        cardValue.put("5", 5);
        cardValue.put("6", 6);
        cardValue.put("7", 7);
        cardValue.put("8", 8);
        cardValue.put("9", 9);
        cardValue.put("10", 10);
        cardValue.put("J", 11);
        cardValue.put("Q", 12);
        cardValue.put("K", 13);
        cardValue.put("0", 0);
        return cardValue.get(n);
    }


    public void shuffleDeck() {

        for (int index = 0; index < size.getcol1(); index++) {
            int indexTemp = rd.nextInt(deckCopy.size());
            column1.push(deckCopy.get(indexTemp));
            deckCopy.remove(indexTemp);
            indexTemp--;
        }


        for (int index = 0; index < size.getcol2(); index++) {
            int indexTemp = rd.nextInt(deckCopy.size());
            column2.add(deckCopy.get(indexTemp));
            deckCopy.remove(indexTemp);
            indexTemp--;
        }


        for (int index = 0; index < size.getcol3(); index++) {
            int indexTemp = rd.nextInt(deckCopy.size());
            column3.add(deckCopy.get(indexTemp));
            deckCopy.remove(indexTemp);
            indexTemp--;
        }


        for (int index = 0; index < size.getcol4(); index++) {
            int indexTemp = rd.nextInt(deckCopy.size());
            column4.add(deckCopy.get(indexTemp));
            deckCopy.remove(indexTemp);
            indexTemp--;
        }


        for (int index = 0; index < size.getcol5(); index++) {
            int indexTemp = rd.nextInt(deckCopy.size());
            column5.add(deckCopy.get(indexTemp));
            deckCopy.remove(indexTemp);
            indexTemp--;
        }


        for (int index = 0; index < size.getcol6(); index++) {
            int indexTemp = rd.nextInt(deckCopy.size());
            column6.add(deckCopy.get(indexTemp));
            deckCopy.remove(indexTemp);
            indexTemp--;
        }

        for (int index = 0; index < size.getcol7(); index++) {
            int indexTemp = rd.nextInt(deckCopy.size());
            column7.add(deckCopy.get(indexTemp));
            deckCopy.remove(indexTemp);
            indexTemp--;
        }

        for (int index = 0; index < size.getcol8(); index++) {
            int indexTemp = rd.nextInt(deckCopy.size());
            column8.add(deckCopy.get(indexTemp));
            deckCopy.remove(indexTemp);
            indexTemp--;
        }
        //column9 is just an extra column no data need to be inserted in it

    }

    public void colRotation(String colRot) {
        switch (colRot) {
            case "1":
                if (column1.isEmpty()) {
                    System.out.println("The column is empty");
                } else
                    column1.add(0, column1.remove(column1.size() - 1));
                break;
            case "2":
                if (column2.isEmpty()) {
                    System.out.println("The column is empty");
                } else
                    column2.add(0, column2.remove(column2.size() - 1));
                break;
            case "3":
                if (column3.isEmpty()) {
                    System.out.println("The column is empty");
                } else
                    column3.add(0, column3.remove(column3.size() - 1));
                break;
            case "4":
                if (column4.isEmpty()) {
                    System.out.println("The column is empty");
                } else
                    column4.add(0, column4.remove(column4.size() - 1));
                break;
            case "5":
                if (column5.isEmpty()) {
                    System.out.println("The column is empty");
                } else
                    column5.add(0, column5.remove(column5.size() - 1));
                break;
            case "6":
                if (column6.isEmpty()) {
                    System.out.println("The column is empty");
                } else
                    column6.add(0, column6.remove(column6.size() - 1));
                break;
            case "7":
                if (column7.isEmpty()) {
                    System.out.println("The column is empty");
                } else
                    column7.add(0, column7.remove(column7.size() - 1));
                break;
            case "8":
                if (column8.isEmpty()) {
                    System.out.println("The column is empty");
                } else
                    column8.add(0, column8.remove(column8.size() - 1));
                break;
            case "9":
                if (column9.isEmpty()) {
                    System.out.println("The column is empty");
                } else
                    column9.add(0, column9.remove(column9.size() - 1));
                break;
            default:
                System.out.println("error:  at colRotation method");
        }
    }

    public void PrintBoard() {
        System.out.println("Pile   C : " + pileC +
                "\nPile   D : " + pileD +
                "\nPile   H : " + pileH +
                "\nPile   S : " + pileS +
                "\nColumn 1 : " + column1 +
                "\nColumn 2 : " + column2 +
                "\nColumn 3 : " + column3 +
                "\nColumn 4 : " + column4 +
                "\nColumn 5 : " + column5 +
                "\nColumn 6 : " + column6 +
                "\nColumn 7 : " + column7 +
                "\nColumn 8 : " + column8 +
                "\nColumn 9 : " + column9);
    }

    public void clearAll() {
        pileS.clear();
        pileH.clear();
        pileD.clear();
        pileC.clear();
        column1.clear();
        column2.clear();
        column3.clear();
        column4.clear();
        column5.clear();
        column6.clear();
        column7.clear();
        column8.clear();
        column9.clear();

    }

    public void restart() {
        clearAll();
        deckCopy.addAll(deck);
        shuffleDeck();
    }

    public Boolean isDone() {
        if ((column1.isEmpty() && column2.isEmpty() && column3.isEmpty() && column4.isEmpty() && column5.isEmpty() && column6.isEmpty() && column7.isEmpty() && column8.isEmpty() && column9.isEmpty())) {
            return true;
        } else
            return false;
    }

    public Boolean isAllEmpty() {
        if (column1.isEmpty() || column2.isEmpty() || column3.isEmpty() || column4.isEmpty() || column5.isEmpty() || column6.isEmpty() || column7.isEmpty() || column8.isEmpty() || column9.isEmpty()) {
            return true;
        } else
            return false;
    }

    public Boolean isValidCol(String colTo) {
        if (colTo.equals("1") || colTo.equals("2") || colTo.equals("3") || colTo.equals("4") || colTo.equals("5") || colTo.equals("6") || colTo.equals("7") || colTo.equals("8") || colTo.equals("9")) {
            return true;
        } else
            return false;
    }
}