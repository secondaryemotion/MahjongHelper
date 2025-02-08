package main.java.com.secondaryemotion.domain.interactor;



import main.java.com.secondaryemotion.data.entity.Hand;
import main.java.com.secondaryemotion.data.entity.HandVariation;

import java.util.ArrayList;

public class GenerateHandVariations {
    public static HandVariation[] generateHand(Hand hand){
        String[] mans = getOptimalSetsFrom(findSets(hand.getMan()));
        String[] pins = getOptimalSetsFrom(findSets(hand.getPin()));
        String[] sous = getOptimalSetsFrom(findSets(hand.getSou()));
        String[] honors = getHonorsSets(hand.getHonor());
        HandVariation[] handVariations = new HandVariation[mans.length * pins.length * sous.length * honors.length];
        int i = 0;
        for(String man : mans){
            for (String pin : pins){
                for (String sou : sous){
                    for (String honor : honors){
                        handVariations[i] = new HandVariation(transformSetsToArrays(man),
                                transformSetsToArrays(pin),
                                transformSetsToArrays(sou),
                                transformSetsToArrays(honor),
                                hand.getTiles());
                        i++;
                    }
                }
            }
        }
        return handVariations;
    }

    public static ArrayList<String> findSets(int[] suit){
        ArrayList<String> sets = new ArrayList<>();
        for (int i = 0; i < suit.length; i++){
            StringBuilder combination = new StringBuilder();
            for (int j = 0; j < suit.length; j++){
                if (j < i) {
                    combination.append(suit[j]).append("c");
                } else {
                    combination.append(suit[j]);
                    if (j+1 < suit.length && suit[j+1] - suit[j] <= 2) {
                        combination.append(suit[j+1]);
                        j++;
                        if (j+1 < suit.length && suit[j+1] - suit[j-1] <= 2) {
                            combination.append(suit[j+1]);
                            j++;
                        }
                    }
                    combination.append("c");
                }
            }
            sets.add(combination.toString());
        }
        return sets;
    }

    public static String[] getOptimalSetsFrom(ArrayList<String> sets){
        int optimalCount = 13;
        ArrayList<String> optimalSets = new ArrayList<>();
        for (String set : sets) {
            int count = (int) set.chars().filter(ch -> ch == 'c').count();
            if (count <= optimalCount) {
                optimalSets.add(set);
                optimalCount = count;
            }
        }
        if (optimalSets.isEmpty()) optimalSets.add("");
        String[] result = new String[optimalSets.size()];
        result = optimalSets.toArray(result);
        return result;
    }

    public static String[] getHonorsSets(int[] honors){
        StringBuilder combination = new StringBuilder();
        for (int i = 0; i < honors.length; i++){
            combination.append(honors[i]);
            while (i + 1 < honors.length && honors[i] == honors[i + 1]){
                combination.append(honors[i]);
                i++;
            }
            combination.append("c");
        }
        return new String[]{combination.toString()};
    }

    public static int[][] transformSetsToArrays(String set){
        int count = (int) set.chars().filter(ch -> ch == 'c').count();
        int[][] sets = new int[count][];
        String[] splitSet = set.split("c");
        for (int i = 0; i < count; i++){
            int[] tempSet = new int[splitSet[i].length()];
            String[] combination = splitSet[i].split("");
            for (int j = 0; j < combination.length; j++){
                tempSet[j] = Integer.parseInt(combination[j]);
            }
            sets[i] = tempSet;
        }
        return sets;
    }
}
