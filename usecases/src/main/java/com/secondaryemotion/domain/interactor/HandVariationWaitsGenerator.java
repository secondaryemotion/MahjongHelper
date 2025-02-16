package com.secondaryemotion.domain.interactor;


import com.secondaryemotion.data.entity.HandVariation;
import com.secondaryemotion.data.entity.HandVariationWaits;

/* Hand variation waits - tiles that we need to obtain to form a winning hand
    [2-3-3]m,[4-5]m,[2-3-4]p,[4]s,[3-3]z,[4]z,[5]z hand
    [2-3-3]m waits are 1 to form 1-2-3, 3 to form 3-3-3 and 4 to form 2-3-4, so we write [1, 3, 4]
    [4-5]m -> [3,6] Set
    [2-3-4]p is a complete set, so its waits are empty []
    [4]p wait is a Pair [4]
    [3-3]z -> [3] Set
    [4]z -> [4] Pair
    [5]z -> [5] Pair

    This hand has 1 complete set and 3 potential sets,
    so to become the winning hand it needs to complete all its sets and get one of the possible pairs
    [3-4] waits are 2 and 5, it's called side wait
    [3-5] wait is 4, it's called closed wait
    [1-2] wait is only 3, since there's no 0 tile. it's called edge wait

    * if the sum of the numbers in 3 tile Set %3 = 0, the Set is complete
    * in Set with repeating number the repeated number will always be in the second position ([2-3-3] and [2-2-3] etc)
*/
public class HandVariationWaitsGenerator {

    private static final int leftEdge = 1;
    private static final int rightEdge = 9;

    public static HandVariationWaits generateWaits(HandVariation handVariation){
        int[][] manWaits = generateSuitWaits(handVariation.getMan());
        int[][] pinWaits = generateSuitWaits(handVariation.getPin());
        int[][] souWaits = generateSuitWaits(handVariation.getSou());
        int[][] honorWaits = generateHonorWaits(handVariation.getHonor());
        return new HandVariationWaits(manWaits,pinWaits,souWaits,honorWaits);
    }

    public static int[][] generateSuitWaits(int[][] suit){
        int[][] result = new int[suit.length][];
        for (int i = 0; i<suit.length; i++){
            switch (suit[i].length){
                case 1: {
                    result[i] = generatePairWait(suit[i]);
                    break;
                }
                case 2: {
                    result[i] = generateWaitsForTwoTiles(suit[i]);
                    break;
                }
                case 3: {
                    result[i] = generateWaitsForThreeTiles(suit[i]);
                }
            }
        }
        return result;
    }

    public static int[] generateWaitsForThreeTiles(int[] set) {
        int[] tempSet;
        int tilesSetSum = set[0] + set[1] + set[2];
        boolean isSetComplete = (tilesSetSum) % 3 == 0;
        if (isSetComplete) {
            tempSet = new int[0];
        } else if (set[0]+1 == set[1] || set[1]+1 == set[2]) {
            if (set[0]==leftEdge || set[2]==rightEdge){
                tempSet = generateEdgeAndIdenticalWaits(set);
            } else {
                tempSet = generateSideAndIdenticalWaits(set);
            }
        } else {
            tempSet = generateClosedAndSideWaitForTriple(set);
        }
        return tempSet;
    }

    public static int[] generateWaitsForTwoTiles(int[] set) {
        int[] tempSet;
        if (set[0] + 2 == set[1]) {
            tempSet = generateClosedWait(set);
        } else {
            if (set[0]==leftEdge || set[1]==rightEdge){
                tempSet = generateEdgeWait(set);
            } else {
                tempSet = generateSideWaits(set);
            }
        }
        return tempSet;
    }

    public static int[] generateEdgeAndIdenticalWaits(int[] set) {
        int[] tempSet = new int[2];
        if (set[0] == 1) {
            tempSet[0] = set[1];
            tempSet[1] = set[2] + 1;
        } else {
            tempSet[0] = set[0] - 1;
            tempSet[1] = set[1];
        }
        return tempSet;
    }

    public static int[] generateSideAndIdenticalWaits(int[] set) {
        int[] tempSet = new int[3];
        tempSet[0] = set[0] - 1;
        tempSet[1] = set[2] + 1;
        tempSet[2] = set[1];
        return tempSet;
    }

    public static int[] generateClosedAndSideWaitForTriple(int[] set) {
        int[] tempSet = new int[2];
        tempSet[0] = (set[0]+ set[2])/2;
        tempSet[1] = set[1];
        return tempSet;
    }

    public static int[] generateSideWaits(int[] set) {
        int[] tempSet = new int[2];
        tempSet[0] = set[0] - 1;
        tempSet[1] = set[1] + 1;
        return tempSet;
    }

    public static int[] generateEdgeWait(int[] set) {
        int[] tempSet = new int[1];
        if (set[0] == 1) {
            tempSet[0] = set[1] + 1;
        } else {
            tempSet[0] = set[0] - 1;
        }
        return tempSet;
    }

    public static int[] generateClosedWait(int[] set) {
        int[] tempSet = new int[1];
        tempSet[0] = (set[0] + set[1]) / 2;
        return tempSet;
    }

    public static int[] generatePairWait(int[] set) {
        int[] tempPair = new int[1];
        tempPair[0] = set[0];
        return tempPair;
    }


    public static int[][] generateHonorWaits(int[][] honors){
        int[][] result = new int[honors.length][];
        for (int i = 0; i<honors.length; i++){
            result[i] = new int[]{honors[i][0]};
        }
        return result;
    }

}
