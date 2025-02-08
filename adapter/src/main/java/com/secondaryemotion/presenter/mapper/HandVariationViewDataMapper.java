package main.java.com.secondaryemotion.presenter.mapper;

import main.java.com.secondaryemotion.controller.model.HandVariationModel;
import main.java.com.secondaryemotion.presenter.view.HandVariationView;

import java.util.Arrays;

public class HandVariationViewDataMapper {
    public static HandVariationView transform(HandVariationModel handVariationModel){
        int[][] manVariation = handVariationModel.getMan();
        int[][] pinVariation = Arrays.stream(handVariationModel.getPin()).map(i -> Arrays.stream(i).map(j -> (j+8)).toArray()).toArray(int[][]::new);
        int[][] souVariation = Arrays.stream(handVariationModel.getSou()).map(i -> Arrays.stream(i).map(j -> (j+17)).toArray()).toArray(int[][]::new);
        int[][] honorsVariation = Arrays.stream(handVariationModel.getHonor()).map(i -> Arrays.stream(i).map(j -> (j+26)).toArray()).toArray(int[][]::new);
        return new HandVariationView(manVariation,pinVariation,souVariation,honorsVariation);
    }
}
