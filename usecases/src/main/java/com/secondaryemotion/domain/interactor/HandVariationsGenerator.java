package com.secondaryemotion.domain.interactor;

import com.secondaryemotion.data.entity.Hand;
import com.secondaryemotion.data.entity.HandVariation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*  Hand variation - starting hand divided into complete and potential sets
    12245m234p4s3345z -> [1-2-2]m,[4-5]m,[2-3-4]p,[4]s,[3-3]z,[4]z,[5]z

    Complete set - combination of 3 tiles (etc. 3-4-5 or 3-3-3)
    Potential set - combination of 2 tiles (3-4 or 3-3), we need to add 1 tile
    or combination of 3 tiles (3-4-4 or 1-1-3), we need to replace 1 tile to finish the set 3-4-4 -> 3-4-5 or 4-4-4
    distance between lowest and highest tile in a set can't be more than 2: 1-1-3 works, 1-3-4 doesn't

    * Honor suit tiles (z in mahjong notation) can only make sets with identical tiles (3345 -> 3-3, 4, 5)
    * There is also a rare 4 identical tiles combination, which counts as a Set
    * Winning hand also need to have one Pair, that's why floating tiles are not that useless

    Variations are formed by going through the sorted hand and dividing it into 1-3 tile combinations of close valued tiles
    1234667 -> 1-2-3, 4-6-6, 7
    then in findSets method we cyclically isolate the first N numbers to make different sets if possible
    1234667 -> 1, 2-3-4, 6-6-7
    1234667 -> 1, 2, 3-4, 6-6-7
    1234667 -> 1, 2, 3, 4-6-6, 7
    ...

    getOptimalSetsFrom finds variations that have the least amount of sets so it's easier to finish them
    [1, 2-3-4, 6-6-7] and [1-2-3, 4-6-6, 7] are optimal
    both have one complete set, one potential set and one floating tile, which could be discarded or combined into Pair
 */

public class HandVariationsGenerator {
    public static HandVariation[] generateHand(Hand hand){
        String[] mans = getOptimalSetsFrom(findSets(hand.getMan()));
        String[] pins = getOptimalSetsFrom(findSets(hand.getPin()));
        String[] sous = getOptimalSetsFrom(findSets(hand.getSou()));
        String[] honors = getOptimalHonorsSets(hand.getHonor());
        return getHandVariations(hand, mans, pins, sous, honors);
    }

    public static HandVariation[] getHandVariations(Hand hand, String[] mans, String[] pins, String[] sous, String[] honors) {
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
            for (int setSearchOffset = 0; setSearchOffset < suit.length; setSearchOffset++){
                if (setSearchOffset < i) {
                    combination.append(suit[setSearchOffset]).append("c");
                } else {
                    combination.append(suit[setSearchOffset]);
                    if (setSearchOffset+1 < suit.length && suit[setSearchOffset+1] - suit[setSearchOffset] <= 2) {
                        combination.append(suit[setSearchOffset+1]);
                        setSearchOffset++;
                        if (setSearchOffset+1 < suit.length && suit[setSearchOffset+1] - suit[setSearchOffset-1] <= 2) {
                            combination.append(suit[setSearchOffset+1]);
                            setSearchOffset++;
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
        Set<String> optimalSets = new HashSet<>();
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

    public static String[] getOptimalHonorsSets(int[] honors){
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
