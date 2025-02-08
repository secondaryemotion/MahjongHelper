package main.java.com.secondaryemotion.presenter.view;

public class HandVariationView {



    private int[] tiles = new int[34];
    private int[][] man;
    private int[][] pin;
    private int[][] sou;
    private int[][] honor;

    public HandVariationView(){};

    public HandVariationView(int[][] man, int[][] pin, int[][] sou, int[][] honor) {
        this.man = man;
        this.pin = pin;
        this.sou = sou;
        this.honor = honor;
    }



}
