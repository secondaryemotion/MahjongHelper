package main.java.com.secondaryemotion.controller;

import main.java.com.secondaryemotion.data.entity.Hand;
import main.java.com.secondaryemotion.data.entity.HandVariation;
import main.java.com.secondaryemotion.data.entity.HandVariationWaits;
import main.java.com.secondaryemotion.domain.interactor.GenerateHandVariationWaits;
import main.java.com.secondaryemotion.domain.interactor.GenerateHandVariations;
import main.java.com.secondaryemotion.views.view.FullHandView;

public class Controller {
    private FullHandView fullHandView;

    public void requestFullHandViews(String handJsonResponse){
        Hand hand = Hand.parseHand(handJsonResponse);
        HandVariation[] handVariations = GenerateHandVariations.generateHand(hand);
        for (HandVariation handVariation : handVariations){
            HandVariationWaits handVariationWaits = GenerateHandVariationWaits.generateWaits(handVariation);
            fullHandView = new FullHandView(handVariation,handVariationWaits);
        }
    }

}
