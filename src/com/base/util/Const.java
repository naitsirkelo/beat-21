package com.base.util;

import java.util.Map;

public class Const {

    public static final String SAM = "sam";
    public static final String DEALER = "dealer";
    public static final String RESOURCE_PATH = "C:\\Users\\Greencom\\Prog\\can-you-beat-the-dealer-at-21\\src\\resources\\";

    public static final int BLACKJACK = 21;
    public static final int BUSTED_SCORE = 22;
    public static final int MAX_SCORE_NEW_CARD = 17;
    public static final int INITIAL_CARDS = 5;
    public static final int SUITS = 4;
    public static final int MIN_VALUES = 1;
    public static final int MAX_VALUES = 13;
    public static final int ACE = 1;
    public static final int ACE_SCORE = 11;
    public static final int FACE_SCORE = 10;

    public static final String[] SUITS_SHORT = {"C", "D", "H", "S"};
    public static final String[] VALUE_NAMES = {"A", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "J", "Q", "K"};

    public static final Map<String, Integer> CARD_VALUES = Map.of(
            "A", 1,
            "J", 11,
            "Q", 12,
            "K", 13
    );

    public static final Map<String, Integer> SUIT_VALUES = Map.of(
            "C", 1,
            "D", 2,
            "H", 3,
            "S", 4
    );

    private Const() {
        throw new AssertionError();
    }
}
