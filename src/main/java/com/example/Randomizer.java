package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {
    static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
    public Randomizer() {
    }

    public static char GetChar(){
        Random random = new Random();
        return alphabet[random.nextInt(alphabet.length)];
    }

    public static String GetRandomizer(){
        String randomId = "";
        for (int i = 0; i < 50; i++) {
            randomId += GetChar();
        }
        return randomId;
    }
}
