package main.java.com.secondaryemotion.controller;

import main.java.com.secondaryemotion.data.entity.Hand;
import main.java.com.secondaryemotion.data.entity.HandVariation;
import main.java.com.secondaryemotion.data.entity.HandVariationWaits;
import main.java.com.secondaryemotion.domain.interactor.HandVariationWaitsGenerator;
import main.java.com.secondaryemotion.domain.interactor.HandVariationsGenerator;
import main.java.com.secondaryemotion.views.view.FullHandView;

public class Controller {
    private FullHandView fullHandView;

    public void requestFullHandViews(String handJsonResponse){
        Hand hand = Hand.parseHand(handJsonResponse);
        HandVariation[] handVariations = HandVariationsGenerator.generateHand(hand);
        for (HandVariation handVariation : handVariations){
            HandVariationWaits handVariationWaits = HandVariationWaitsGenerator.generateWaits(handVariation);
            fullHandView = new FullHandView(handVariation,handVariationWaits);
        }
    }

}
