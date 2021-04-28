package com.base.util;

public class Const {

    public static final String SAM = "sam";
    public static final String DEALER = "dealer";

    public static final int BLACKJACK = 21;
    public static final int BUSTED_SCORE = 22;
    public static final int MAX_SCORE_NEW_CARD = 17;
    public static final int INITIAL_CARDS = 5;
    public static final int SUITS = 4;
    public static final int MIN_VALUES = 1;
    public static final int MAX_VALUES = 13;

    public static final String[] SUITS_SHORT = {"C", "D", "H", "S"};
    public static final String[] VALUE_NAMES = {"A", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "J", "Q", "K"};
    //public static final String[] VALUE_NAMES_LONG = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    private Const() {
        throw new AssertionError();
    }
}
