package main.java.com.secondaryemotion.controller.mapper;


import main.java.com.secondaryemotion.controller.model.HandVariationModel;
import main.java.com.secondaryemotion.data.entity.HandVariation;

public class HandVariationModelDataMapper {

    public static HandVariationModel transform(HandVariation handVariation){
        HandVariationModel handVariationModel = null;
        if (handVariation != null){
            handVariationModel = new HandVariationModel();
            handVariationModel.setMan(handVariation.getMan());
            handVariationModel.setPin(handVariation.getPin());
            handVariationModel.setSou(handVariation.getSou());
            handVariationModel.setHonor(handVariation.getHonor());
        }
        return handVariationModel;
    }

}
