package main.java.com.secondaryemotion.controller;

import main.java.com.secondaryemotion.controller.mapper.HandVariationModelDataMapper;
import main.java.com.secondaryemotion.controller.mapper.HandVariationWaitsModelDataMapper;
import main.java.com.secondaryemotion.controller.model.HandVariationModel;
import main.java.com.secondaryemotion.controller.model.HandVariationWaitsModel;
import main.java.com.secondaryemotion.data.entity.Hand;
import main.java.com.secondaryemotion.data.entity.HandVariation;
import main.java.com.secondaryemotion.data.entity.HandVariationWaits;
import main.java.com.secondaryemotion.domain.interactor.GenerateHandVariationWaits;
import main.java.com.secondaryemotion.domain.interactor.GenerateHandVariations;

public class HandController {

    public HandVariationModel[] generateHandVariations(String handJsonResponse){
        Hand hand = new Hand(handJsonResponse);
        HandVariation[] handVariations = GenerateHandVariations.generateHand(hand);
        HandVariationModel[] handVariationModels = new HandVariationModel[handVariations.length];
        for (int i = 0; i < handVariations.length; i++){
            handVariationModels[i] = HandVariationModelDataMapper.transform(handVariations[i]);
        }
        return handVariationModels;
    }

    public HandVariationWaitsModel generateHandVariationWaits(HandVariationModel handVariationModel){
        HandVariation handVariation = handVariationModel.toHandVariation();
        HandVariationWaits handVariationWaits = GenerateHandVariationWaits.generateWaits(handVariation);
        HandVariationWaitsModel handVariationWaitsModel = HandVariationWaitsModelDataMapper.transform(handVariationWaits);
        return handVariationWaitsModel;
    }
}
