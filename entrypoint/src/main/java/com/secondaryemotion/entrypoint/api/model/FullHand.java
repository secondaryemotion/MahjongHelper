package com.secondaryemotion.entrypoint.api.model;

import java.util.Arrays;

public class FullHand {


    private int[][] handVariationTiles;
    private int[][] handVariationWaitsTiles;

    public FullHand(int[][] handVariation, int[][] handVariationWaits){
        this.handVariationTiles = handVariation;
        this.handVariationWaitsTiles = handVariationWaits;
    }

    public int[][] getHandVariationTiles() {
        return handVariationTiles;
    }

    public int[][] getHandVariationWaitsTiles() {
        return handVariationWaitsTiles;
    }

}
