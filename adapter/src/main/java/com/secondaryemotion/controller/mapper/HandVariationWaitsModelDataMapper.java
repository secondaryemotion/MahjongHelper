package main.java.com.secondaryemotion.controller.mapper;


import main.java.com.secondaryemotion.controller.model.HandVariationWaitsModel;
import main.java.com.secondaryemotion.data.entity.HandVariationWaits;

public class HandVariationWaitsModelDataMapper {

    public static HandVariationWaitsModel transform(HandVariationWaits handVariationWaits){
        HandVariationWaitsModel handVariationWaitsModel = null;
        if (handVariationWaits != null){
            handVariationWaitsModel = new HandVariationWaitsModel();
            handVariationWaitsModel.setManWaits(handVariationWaits.getManWaits());
            handVariationWaitsModel.setPinWaits(handVariationWaits.getPinWaits());
            handVariationWaitsModel.setSouWaits(handVariationWaits.getSouWaits());
            handVariationWaitsModel.setHonorWaits(handVariationWaits.getHonorWaits());
        }
        return handVariationWaitsModel;
    }

}
