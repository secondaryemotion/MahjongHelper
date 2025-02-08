package main.java.com.secondaryemotion.presenter;

import main.java.com.secondaryemotion.controller.model.HandVariationModel;
import main.java.com.secondaryemotion.controller.model.HandVariationWaitsModel;
import main.java.com.secondaryemotion.presenter.mapper.HandVariationViewDataMapper;
import main.java.com.secondaryemotion.presenter.mapper.HandVariationWaitsViewDataMapper;
import main.java.com.secondaryemotion.presenter.view.HandVariationView;
import main.java.com.secondaryemotion.presenter.view.HandVariationWaitsView;

public class Presenter {

    public static HandVariationView[] presentHandVariations(HandVariationModel[] handVariationModels){
        HandVariationView[] handVariationViews = new HandVariationView[handVariationModels.length];
        for (int i = 0; i < handVariationModels.length; i++){
            handVariationViews[i] = HandVariationViewDataMapper.transform(handVariationModels[i]);}
        return handVariationViews;
    }

    public static HandVariationWaitsView[] presentHandVariationWaits(HandVariationWaitsModel[] handVariationWaitsModels){
        HandVariationWaitsView[] handVariationWaitsViews = new HandVariationWaitsView[handVariationWaitsModels.length];
        for (int i = 0; i < handVariationWaitsModels.length; i++){
            handVariationWaitsViews[i] = HandVariationWaitsViewDataMapper.transform(handVariationWaitsModels[i]);
        }
        return handVariationWaitsViews;
    }


}
