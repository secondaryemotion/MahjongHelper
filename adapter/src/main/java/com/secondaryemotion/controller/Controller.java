package com.secondaryemotion.controller;

import com.secondaryemotion.data.entity.Hand;
import com.secondaryemotion.data.entity.HandVariation;
import com.secondaryemotion.data.entity.HandVariationWaits;
import com.secondaryemotion.domain.interactor.HandVariationWaitsGenerator;
import com.secondaryemotion.domain.interactor.HandVariationsGenerator;
import com.secondaryemotion.views.view.FullHandView;

public class Controller {

    public FullHandView requestFullHandViews(String handRequest){
        Hand hand = Hand.parseHand(handRequest);
        HandVariation[] handVariations = HandVariationsGenerator.generateHand(hand);
        for (HandVariation handVariation : handVariations){
            HandVariationWaits handVariationWaits = HandVariationWaitsGenerator.generateWaits(handVariation);
            return new FullHandView(handVariation, handVariationWaits);
        }
        return null;
    }

}
