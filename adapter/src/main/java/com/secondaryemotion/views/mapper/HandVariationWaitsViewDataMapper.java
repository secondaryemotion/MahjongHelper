package main.java.com.secondaryemotion.views.mapper;

import main.java.com.secondaryemotion.data.entity.HandVariationWaits;
import main.java.com.secondaryemotion.views.view.HandVariationWaitsView;

import java.util.Arrays;

public class HandVariationWaitsViewDataMapper {

    public static HandVariationWaitsView transform(HandVariationWaits handVariationWaits){
        int[][] manWaits = handVariationWaits.getManWaits();

        int[][] pin = handVariationWaits.getPinWaits();
        int[][] pinWaits = new int[pin.length][];
        for (int i = 0; i < pin.length; i++){
            pinWaits[i] = Arrays.stream(pin[i]).map(j -> (j+8)).toArray();
        }

        int[][] sou = handVariationWaits.getSouWaits();
        int[][] souWaits = new int[sou.length][];
        for (int i = 0; i < sou.length; i++){
            souWaits[i] = Arrays.stream(sou[i]).map(j -> (j+17)).toArray();
        }

        int[][] honors = handVariationWaits.getHonorWaits();
        int[][] honorsWaits = new int[honors.length][];
        for (int i = 0; i < honors.length; i++){
            honorsWaits[i] = Arrays.stream(honors[i]).map(j -> (j+26)).toArray();
        }
        return new HandVariationWaitsView(manWaits,pinWaits,souWaits,honorsWaits);
    }

}
