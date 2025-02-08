package main.java.com.secondaryemotion.presenter.view;

public class HandVariationView {

    private int[][] tiles;

    public HandVariationView(int[][] man, int[][] pin, int[][] sou, int[][] honors){
        int[][] tiles = new int[man.length+pin.length+sou.length+ honors.length][];
        System.arraycopy(man,0,tiles,0,man.length);
        System.arraycopy(pin,0,tiles,man.length,pin.length);
        System.arraycopy(sou,0,tiles,man.length+pin.length,sou.length);
        System.arraycopy(honors,0,tiles,man.length+pin.length+sou.length,honors.length);
        this.tiles = tiles;
    }

    public int[][] getTiles() {
        return tiles;
    }

    public void setTiles(int[][] tiles) {
        this.tiles = tiles;
    }
}
