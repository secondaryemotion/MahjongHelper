package main.java.com.secondaryemotion.data.entity.mapper;

import main.java.com.secondaryemotion.data.entity.HandEntity;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandEntityJsonMapper {

    private static Pattern manPattern = Pattern.compile("[1-9]{1,13}m");
    private static Pattern pinPattern = Pattern.compile("[1-9]{1,13}p");
    private static Pattern souPattern = Pattern.compile("[1-9]{1,13}s");
    private static Pattern honorPattern = Pattern.compile("[1-7]{1,13}z");

    public static HandEntity transformHandEntity(String handJsonResponse){
        JSONObject obj = new JSONObject(handJsonResponse);
        String handString = obj.getString("hand");
        int[] man = findSuitMatch(handString,manPattern);
        int[] pin = findSuitMatch(handString,pinPattern);
        int[] sou = findSuitMatch(handString,souPattern);
        int[] honor = findSuitMatch(handString,honorPattern);
        return new HandEntity(man,pin,sou,honor);
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

}
