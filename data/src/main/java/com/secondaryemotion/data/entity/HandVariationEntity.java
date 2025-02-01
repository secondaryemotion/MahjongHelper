package main.java.com.secondaryemotion.data.entity;

import java.util.ArrayList;
import java.util.Objects;

public class HandVariationEntity {

    private String man;
    private String pin;
    private String sou;
    private String honor;

    public HandVariationEntity(String man, String pin, String sou, String honor) {
        this.man = man;
        this.pin = pin;
        this.sou = sou;
        this.honor = honor;
    }

    public static HandVariationEntity[] generateHand(HandEntity hand){
        String[] mans = getOptimalSetsFrom(findSets(hand.getMan()));
        String[] pins = getOptimalSetsFrom(findSets(hand.getPin()));
        String[] sous = getOptimalSetsFrom(findSets(hand.getSou()));
        String[] honors = getHonorsSets(hand.getHonor());
        HandVariationEntity[] handVariationEntities = new HandVariationEntity[mans.length * pins.length * sous.length * honors.length];
        int i = 0;
        for(String man : mans){
            for (String pin : pins){
                for (String sou : sous){
                    for (String honor : honors){
                        handVariationEntities[i] = new HandVariationEntity(man, pin, sou, honor);
                        i++;
                    }
                }
            }
        }
        return handVariationEntities;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HandVariationEntity that)) return false;
        return Objects.deepEquals(man, that.man) && Objects.deepEquals(pin, that.pin) && Objects.deepEquals(sou, that.sou) && Objects.deepEquals(honor, that.honor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(man, pin, sou, honor);
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getSou() {
        return sou;
    }

    public void setSou(String sou) {
        this.sou = sou;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

}
