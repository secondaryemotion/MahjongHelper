package main.java.com.secondaryemotion.data.entity;

public class HandVariationWaits {

    private int[][] manWaits;
    private int[][] pinWaits;
    private int[][] souWaits;
    private int[][] honorWaits;

    public HandVariationWaits(int[][] manWaits, int[][] pinWaits, int[][] souWaits, int[][] honorWaits) {
        this.manWaits = manWaits;
        this.pinWaits = pinWaits;
        this.souWaits = souWaits;
        this.honorWaits = honorWaits;
    }

    public int[][] getManWaits() {
        return manWaits;
    }

    public void setManWaits(int[][] manWaits) {
        this.manWaits = manWaits;
    }

    public int[][] getPinWaits() {
        return pinWaits;
    }

    public void setPinWaits(int[][] pinWaits) {
        this.pinWaits = pinWaits;
    }

    public int[][] getSouWaits() {
        return souWaits;
    }

    public void setSouWaits(int[][] souWaits) {
        this.souWaits = souWaits;
    }

    public int[][] getHonorWaits() {
        return honorWaits;
    }

    public void setHonorWaits(int[][] honorWaits) {
        this.honorWaits = honorWaits;
    }

}
