package main.java.com.secondaryemotion.views.view;

import java.util.Arrays;
import java.util.Objects;

public class HandBaseView {

    private int[][] tiles;

    public HandBaseView(int[][] man, int[][] pin, int[][] sou, int[][] honors){
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HandBaseView that)) return false;
        return Objects.deepEquals(getTiles(), that.getTiles());
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(getTiles());
    }
}
