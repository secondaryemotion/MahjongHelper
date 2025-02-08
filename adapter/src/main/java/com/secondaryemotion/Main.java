package main.java.com.secondaryemotion;

import main.java.com.secondaryemotion.controller.Controller;
import main.java.com.secondaryemotion.presenter.view.HandVariationView;
import main.java.com.secondaryemotion.presenter.view.HandVariationWaitsView;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        String handJsonResponse = "{\"hand\":\"1678m9p58s111455z\"}";
        HandVariationView[] handVariationViews = Controller.generateHandVariations(handJsonResponse);
        HandVariationWaitsView[] handVariationWaitsViews = Controller.generateHandVariationWaits(handJsonResponse);
        for (int i = 0; i < handVariationViews.length; i++){
            System.out.println(Arrays.deepToString(handVariationViews[i].getTiles()));
            System.out.println(Arrays.deepToString(handVariationWaitsViews[i].getTiles()));
        }
    }
}
