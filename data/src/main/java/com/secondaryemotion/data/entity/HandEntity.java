package main.java.com.secondaryemotion.data.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


public class HandEntity {

    private int[] man;
    private int[] pin;
    private int[] sou;
    private int[] honor;
    public int maxSuitValue = 9;
    public int maxHonorsValue = 7;
    public int validHandSize = 13;
    public HandVariationEntity[] handVariationEntities;

    public HandEntity(int[] man, int[] pin, int[] sou, int[] honors){
        Arrays.sort(man);
        Arrays.sort(pin);
        Arrays.sort(sou);
        Arrays.sort(honors);

        this.setMan(man);
        this.setPin(pin);
        this.setSou(sou);
        this.setHonor(honors);
    }

    public boolean validate(){
        if (getHandSize() != validHandSize) return false;
        if (!validateSuit(this.getHonor(),maxHonorsValue)) return false;
        if (!validateSuit(this.getMan(),maxSuitValue)) return false;
        if (!validateSuit(this.getPin(),maxSuitValue)) return false;
        if (!validateSuit(this.getSou(),maxSuitValue)) return false;
        return true;
    }

    public boolean validateSuit(int[] suit, int maxValue){
        HashMap<Integer,Integer> frequencies = new HashMap<>();
        for (int i : suit){
            if (i > maxValue) return false;
            if (i <= 0) return false;
            frequencies.put(i,frequencies.getOrDefault(i,0) + 1);
            if (frequencies.get(i)>4) return false;
        }
        return true;
    }



    public int[] getMan() {
        return man;
    }

    public void setMan(int[] man) {
        this.man = man;
    }

    public int[] getSou() {
        return sou;
    }

    public void setSou(int[] sou) {
        this.sou = sou;
    }

    public int[] getPin() {
        return pin;
    }

    public void setPin(int[] pin) {
        this.pin = pin;
    }

    public int[] getHonor() {
        return honor;
    }

    public void setHonor(int[] honor) {
        this.honor = honor;
    }

    public int getHandSize(){
        return this.getHonor().length + this.getMan().length + this.getSou().length + this.getPin().length;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HandEntity that)) return false;
        return Objects.deepEquals(getMan(), that.getMan()) && Objects.deepEquals(getPin(), that.getPin()) && Objects.deepEquals(getSou(), that.getSou()) && Objects.deepEquals(getHonor(), that.getHonor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(getMan()), Arrays.hashCode(getPin()), Arrays.hashCode(getSou()), Arrays.hashCode(getHonor()));
    }

}
