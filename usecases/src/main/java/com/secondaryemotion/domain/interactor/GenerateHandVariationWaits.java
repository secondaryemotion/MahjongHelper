package main.java.com.secondaryemotion.domain.interactor;


import main.java.com.secondaryemotion.data.entity.HandVariation;
import main.java.com.secondaryemotion.data.entity.HandVariationWaits;

public class GenerateHandVariationWaits {

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
                    int[] tempPair = new int[1];
                    tempPair[0] = suit[i][0];
                    result[i] = tempPair;
                    break;
                }
                case 2: {
                    int[] tempSet;
                    if (suit[i][0] + 2 == suit[i][1]) {
                        tempSet = new int[1];
                        tempSet[0] = (suit[i][0] + suit[i][1]) / 2;
                    } else {
                        tempSet = new int[2];
                        tempSet[0] = suit[i][0] - 1;
                        tempSet[1] = suit[i][1] + 1;
                    }
                    result[i] = tempSet;
                    break;
                }
                case 3: {
                    int[] tempSet;
                    if ((suit[i][0] + suit[i][1] + suit[i][2]) % 3 == 0) {
                        tempSet = new int[0];
                        result[i] = tempSet;
                    } else if (suit[i][0]+1 == suit[i][1] || suit[i][1]+1 == suit[i][2]) {
                        if (suit[i][0]==1 || suit[i][2]==9){
                            tempSet = new int[2];
                            tempSet[0] = suit[i][1];
                            tempSet[1] = suit[i][2] + 1;
                        } else {
                            tempSet = new int[3];
                            tempSet[0] = suit[i][0] - 1;
                            tempSet[1] = suit[i][2] + 1;
                            tempSet[2] = suit[i][1];
                        }
                        result[i] = tempSet;
                    } else {
                        tempSet = new int[1];
                        tempSet[0] = (suit[i][0]+suit[i][2])/2;
                        result[i] = tempSet;
                    }
                }
            }
        }
        return result;
    }

    public static int[][] generateHonorWaits(int[][] honors){
        int[][] result = new int[honors.length][];
        for (int i = 0; i<honors.length; i++){
            int[] tempSet = {honors[i][0]};
            result[i] = tempSet;
        }
        return result;
    }

}
