package main.java.com.secondaryemotion.presenter.mapper;

import main.java.com.secondaryemotion.controller.model.HandVariationWaitsModel;
import main.java.com.secondaryemotion.presenter.view.HandVariationWaitsView;

import java.util.Arrays;

public class HandVariationWaitsViewDataMapper {

    public static HandVariationWaitsView transform(HandVariationWaitsModel handVariationWaitsModel){
        int[][] manWaits = handVariationWaitsModel.getManWaits();
        int[][] pinWaits = Arrays.stream(handVariationWaitsModel.getPinWaits()).map(i -> Arrays.stream(i).map(j -> (j+8)).toArray()).toArray(int[][]::new);
        int[][] souWaits = Arrays.stream(handVariationWaitsModel.getSouWaits()).map(i -> Arrays.stream(i).map(j -> (j+17)).toArray()).toArray(int[][]::new);
        int[][] honorsWaits = Arrays.stream(handVariationWaitsModel.getHonorWaits()).map(i -> Arrays.stream(i).map(j -> (j+26)).toArray()).toArray(int[][]::new);
        return new HandVariationWaitsView(manWaits,pinWaits,souWaits,honorsWaits);

    }

}
