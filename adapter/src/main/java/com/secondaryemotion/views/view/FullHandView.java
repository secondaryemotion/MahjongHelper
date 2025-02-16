package com.secondaryemotion.views.view;

import com.secondaryemotion.data.entity.HandVariation;
import com.secondaryemotion.data.entity.HandVariationWaits;
import com.secondaryemotion.views.mapper.HandVariationViewDataMapper;
import com.secondaryemotion.views.mapper.HandVariationWaitsViewDataMapper;

import java.util.Arrays;

public class FullHandView {
    public HandVariationView handVariationView;
    public HandVariationWaitsView handVariationWaitsView;

    public FullHandView(HandVariation handVariation, HandVariationWaits handVariationWaits) {
        this.handVariationView = HandVariationViewDataMapper.transform(handVariation);
        this.handVariationWaitsView = HandVariationWaitsViewDataMapper.transform(handVariationWaits);
        //System.out.println(Arrays.deepToString(handVariationView.getTiles()));
        //System.out.println(Arrays.deepToString(handVariationWaitsView.getTiles()));
    }

    public int[][] getHandVariation() {
        return handVariationView.getTiles();
    }

    public int[][] getHandVariationWaits(){
        return handVariationWaitsView.getTiles();
    }
}
