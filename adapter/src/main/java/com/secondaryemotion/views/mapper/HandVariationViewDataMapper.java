package com.secondaryemotion.views.mapper;

import com.secondaryemotion.data.entity.HandVariation;
import com.secondaryemotion.views.view.HandVariationView;

import java.util.Arrays;

public class HandVariationViewDataMapper {
    public static HandVariationView transform(HandVariation handVariation){
        int[][] manVariation = handVariation.getMan();

        int[][] pin = handVariation.getPin();
        int[][] pinVariation = new int[pin.length][];
        for (int i = 0; i < pin.length; i++){
            pinVariation[i] = Arrays.stream(pin[i]).map(j -> (j+8)).toArray();
        }

        int[][] sou = handVariation.getSou();
        int[][] souVariation = new int[sou.length][];
        for (int i = 0; i < sou.length; i++){
            souVariation[i] = Arrays.stream(sou[i]).map(j -> (j+17)).toArray();
        }

        int[][] honors = handVariation.getHonor();
        int[][] honorsVariation = new int[honors.length][];
        for (int i = 0; i < honors.length; i++){
            honorsVariation[i] = Arrays.stream(honors[i]).map(j -> (j+26)).toArray();
        }
        return new HandVariationView(manVariation,pinVariation,souVariation,honorsVariation);
    }
}
