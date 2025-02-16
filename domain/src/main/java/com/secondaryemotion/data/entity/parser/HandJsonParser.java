package com.secondaryemotion.data.entity.parser;

import com.secondaryemotion.data.entity.Hand;
import com.secondaryemotion.data.exception.InvalidHandException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandJsonParser {

    private static final int maxSuitValue = 9;
    private static final int maxHonorsValue = 7;
    private static final int validHandSize = 13;
    private static final Pattern manPattern = Pattern.compile("[1-9]{1,13}m");
    private static final Pattern pinPattern = Pattern.compile("[1-9]{1,13}p");
    private static final Pattern souPattern = Pattern.compile("[1-9]{1,13}s");
    private static final Pattern honorPattern = Pattern.compile("[1-7]{1,13}z");

    public static Hand parse(String handString){
        //JSONObject obj = new JSONObject(handJsonResponse);
        //String handString = obj.getString("hand");
        int[] man = findSuitMatch(handString,manPattern);
        int[] pin = findSuitMatch(handString,pinPattern);
        int[] sou = findSuitMatch(handString,souPattern);
        int[] honor = findSuitMatch(handString,honorPattern);
        validate(man,pin,sou,honor);
        return new Hand(man,pin,sou,honor);
    }

    private static int[] findSuitMatch(String handString, Pattern pattern){
        Matcher suitMatcher = pattern.matcher(handString);
        if (suitMatcher.find()){
            String suit = suitMatcher.group().substring(0,suitMatcher.group().length()-1);
            String[] suitSplit = suit.split("");
            int[] suitNumbers = new int[suitSplit.length];
            for (int i = 0; i < suitSplit.length; i++){
                suitNumbers[i] = Integer.parseInt(suitSplit[i]);
            }
            return suitNumbers;
        } else {
            return new int[0];
        }
    }

    public static void validate(int[] man, int[] pin, int[] sou, int[] honor){
        if (man.length+pin.length+sou.length+honor.length != validHandSize) throw new InvalidHandException("Wrong hand size");
        if (invalidateSuit(man, maxSuitValue)) throw new InvalidHandException("Wrong mans");
        if (invalidateSuit(pin, maxSuitValue)) throw new InvalidHandException("Wrong pins");
        if (invalidateSuit(sou, maxSuitValue)) throw new InvalidHandException("Wrong sous");
        if (invalidateSuit(honor, maxHonorsValue)) throw new InvalidHandException("Wrong honors");
    }

    public static boolean invalidateSuit(int[] suit, int maxValue){
        HashMap<Integer,Integer> frequencies = new HashMap<>();
        for (int i : suit){
            if (i > maxValue) return true;
            if (i <= 0) return true;
            frequencies.put(i,frequencies.getOrDefault(i,0) + 1);
            if (frequencies.get(i)>4) return true;
        }
        return false;
    }

}
