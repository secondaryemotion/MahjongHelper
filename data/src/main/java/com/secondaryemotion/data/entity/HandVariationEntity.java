package main.java.com.secondaryemotion.data.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class HandVariationEntity {

    private String[] man;
    private String[] pin;
    private String[] sou;
    private String[] honors;

    public HandVariationEntity(String[] man, String[] pin, String[] sou, String[] honors) {
        this.man = man;
        this.pin = pin;
        this.sou = sou;
        this.honors = honors;
    }

    public static HandVariationEntity generateHand(HandEntity hand){
        String[] man = getOptimalSetsFrom(findSets(hand.getMan()));
        String[] pin = getOptimalSetsFrom(findSets(hand.getPin()));
        String[] sou = getOptimalSetsFrom(findSets(hand.getSou()));
        String[] honors = getOptimalSetsFrom(findSets(hand.getHonors()));
        return new HandVariationEntity(man, pin, sou, honors);
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
        String[] result = new String[optimalSets.size()];
        result = optimalSets.toArray(result);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HandVariationEntity that)) return false;
        return Objects.deepEquals(man, that.man) && Objects.deepEquals(pin, that.pin) && Objects.deepEquals(sou, that.sou) && Objects.deepEquals(honors, that.honors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(man), Arrays.hashCode(pin), Arrays.hashCode(sou), Arrays.hashCode(honors));
    }
}
