package main.java.com.secondaryemotion.data.entity;

public class HandVariationWaitsEntity {

    private int[][] manWaits;
    private int[][] pinWaits;
    private int[][] souWaits;
    private int[][] honorWaits;

    public HandVariationWaitsEntity(int[][] manWaits, int[][] pinWaits, int[][] souWaits, int[][] honorWaits) {
        this.manWaits = manWaits;
        this.pinWaits = pinWaits;
        this.souWaits = souWaits;
        this.honorWaits = honorWaits;
    }

    public HandVariationWaitsEntity generateWaits(HandVariationEntity handVariationEntity){
        int[][] manWaits = generateSuitWaits(handVariationEntity.getMan());
        int[][] pinWaits = generateSuitWaits(handVariationEntity.getPin());
        int[][] souWaits = generateSuitWaits(handVariationEntity.getSou());
        int[][] honorWaits = generateHonorWaits(handVariationEntity.getHonor());
        return new HandVariationWaitsEntity(manWaits,pinWaits,souWaits,honorWaits);
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

    public int[][] getSouWaits() {
        return souWaits;
    }

    public void setSouWaits(int[][] souWaits) {
        this.souWaits = souWaits;
    }

    public int[][] getPinWaits() {
        return pinWaits;
    }

    public void setPinWaits(int[][] pinWaits) {
        this.pinWaits = pinWaits;
    }

    public int[][] getManWaits() {
        return manWaits;
    }

    public void setManWaits(int[][] manWaits) {
        this.manWaits = manWaits;
    }

    public int[][] getHonorWaits() {
        return honorWaits;
    }

    public void setHonorWaits(int[][] honorWaits) {
        this.honorWaits = honorWaits;
    }
}
