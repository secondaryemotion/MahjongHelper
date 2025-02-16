package com.secondaryemotion.data.entity;

import com.secondaryemotion.data.entity.parser.HandJsonParser;

import java.util.Arrays;
import java.util.Objects;

public class Hand {

    // man (0-8), pin (9-17), sou (18-26), honor (27-33)
    private int[] tiles = new int[34];
    private int[] man;
    private int[] pin;
    private int[] sou;
    private int[] honor;


    public static Hand parseHand(String handJsonResponse){
        return HandJsonParser.parse(handJsonResponse);
    }

    public Hand(int[] man, int[] pin, int[] sou, int[] honors){
        Arrays.sort(man);
        Arrays.sort(pin);
        Arrays.sort(sou);
        Arrays.sort(honors);

        this.setMan(man);
        this.setPin(pin);
        this.setSou(sou);
        this.setHonor(honors);
        this.tiles = this.parseTiles();
    }

    public int[] parseTiles(){
        for (int tile : this.man){
            tiles[tile-1]++;
        }
        for (int tile : this.pin){
            tiles[tile+8]++;
        }
        for (int tile : this.sou){
            tiles[tile+17]++;
        }
        for (int tile : this.honor){
            tiles[tile+26]++;
        }
        return tiles;
    }

    public int[] getMan() {
        return man;
    }

    public void setMan(int[] man) {
        this.man = man;
    }

    public int[] getPin() {
        return pin;
    }

    public void setPin(int[] pin) {
        this.pin = pin;
    }

    public int[] getSou() {
        return sou;
    }

    public void setSou(int[] sou) {
        this.sou = sou;
    }

    public int[] getHonor() {
        return honor;
    }

    public void setHonor(int[] honor) {
        this.honor = honor;
    }

    public int[] getTiles() {
        return tiles;
    }

    public void setTiles(int[] tiles) {
        this.tiles = tiles;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hand hand)) return false;
        return Objects.deepEquals(getMan(), hand.getMan()) && Objects.deepEquals(getPin(), hand.getPin()) && Objects.deepEquals(getSou(), hand.getSou()) && Objects.deepEquals(getHonor(), hand.getHonor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(getMan()), Arrays.hashCode(getPin()), Arrays.hashCode(getSou()), Arrays.hashCode(getHonor()));
    }
}
