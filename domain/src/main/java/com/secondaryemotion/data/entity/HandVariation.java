package main.java.com.secondaryemotion.data.entity;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.*;

public class HandVariation {

    private int[][] man;
    private int[][] pin;
    private int[][] sou;
    private int[][] honor;
    private double[] tiles;

    public HandVariation(){};

    public HandVariation(int[][] man, int[][] pin, int[][] sou, int[][] honor, int[] tiles) {
        this.man = man;
        this.pin = pin;
        this.sou = sou;
        this.honor = honor;
        this.tiles = Arrays.stream(tiles).mapToDouble(HandVariation::countProbability).toArray();
    }

    public static double countProbability(int i){
        return (double) (4 - i) /136;
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

    public double[] getTiles() {
        return tiles;
    }

    public void setTiles(double[] tiles) {
        this.tiles = tiles;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HandVariation that)) return false;
        return Objects.deepEquals(man, that.man) && Objects.deepEquals(pin, that.pin) && Objects.deepEquals(sou, that.sou) && Objects.deepEquals(honor, that.honor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(man), Arrays.deepHashCode(pin), Arrays.deepHashCode(sou), Arrays.deepHashCode(honor));
    }

}
