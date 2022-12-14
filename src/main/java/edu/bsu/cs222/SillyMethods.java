package edu.bsu.cs222;

public class SillyMethods {

    public boolean didGuess42(int i) {
        return i == 42;
    }

    public String countTo(int numberCountTo) {

        StringBuilder countString = new StringBuilder();

        for (int i = 0; i<=numberCountTo; i++) {
            countString.append(i);
            if (i != numberCountTo) {
                countString.append(" ");
            }
        }
        return countString.toString();
    }

    public boolean isEven(int possiblyEvenNumber) {
        return possiblyEvenNumber % 2 == 0;
    }
}
