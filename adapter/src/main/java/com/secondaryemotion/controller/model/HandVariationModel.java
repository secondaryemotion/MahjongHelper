package main.java.com.secondaryemotion.controller.model;


import main.java.com.secondaryemotion.data.entity.Hand;
import main.java.com.secondaryemotion.data.entity.HandVariation;

import java.util.Arrays;
import java.util.Objects;

public class HandVariationModel {

    private int[][] man;
    private int[][] pin;
    private int[][] sou;
    private int[][] honor;

    public HandVariationModel(){};

    public HandVariationModel(int[][] man, int[][] pin, int[][] sou, int[][] honor) {
        this.man = man;
        this.pin = pin;
        this.sou = sou;
        this.honor = honor;
    }

    public int[][] getMan() {
        return man;
    }

    public void setMan(int[][] man) {
        this.man = man;
    }

    public int[][] getPin() {
        return pin;
    }

    public void setPin(int[][] pin) {
        this.pin = pin;
    }

    public int[][] getSou() {
        return sou;
    }

    public void setSou(int[][] sou) {
        this.sou = sou;
    }

    public int[][] getHonor() {
        return honor;
    }

    public void setHonor(int[][] honor) {
        this.honor = honor;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HandVariationModel that)) return false;
        return Objects.deepEquals(man, that.man) && Objects.deepEquals(pin, that.pin) && Objects.deepEquals(sou, that.sou) && Objects.deepEquals(honor, that.honor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(man), Arrays.deepHashCode(pin), Arrays.deepHashCode(sou), Arrays.deepHashCode(honor));
    }


}
