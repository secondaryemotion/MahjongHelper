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
import main.java.com.secondaryemotion.presenter.Presenter;
import main.java.com.secondaryemotion.presenter.view.HandVariationView;
import main.java.com.secondaryemotion.presenter.view.HandVariationWaitsView;

public class Controller {

    public static HandVariationView[] generateHandVariations(String handJsonResponse){
        Hand hand = Hand.parseHand(handJsonResponse);
        HandVariation[] handVariations = GenerateHandVariations.generateHand(hand);
        HandVariationModel[] handVariationModels = new HandVariationModel[handVariations.length];
        for (int i = 0; i < handVariations.length; i++){
            handVariationModels[i] = HandVariationModelDataMapper.transform(handVariations[i]);
        }
        return Presenter.presentHandVariations(handVariationModels);
    }

    public static HandVariationWaitsView[] generateHandVariationWaits(String handJsonResponse){
        Hand hand = Hand.parseHand(handJsonResponse);
        HandVariation[] handVariations = GenerateHandVariations.generateHand(hand);
        HandVariationWaitsModel[] handVariationWaitsModels = new HandVariationWaitsModel[handVariations.length];
        for (int i = 0; i < handVariations.length; i++){
            HandVariationWaits handVariationWaits = GenerateHandVariationWaits.generateWaits(handVariations[i]);
            handVariationWaitsModels[i] = HandVariationWaitsModelDataMapper.transform(handVariationWaits);
        }
        return Presenter.presentHandVariationWaits(handVariationWaitsModels);
    }
}
