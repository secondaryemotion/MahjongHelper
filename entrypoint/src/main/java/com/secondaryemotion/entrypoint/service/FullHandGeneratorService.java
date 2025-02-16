package com.secondaryemotion.entrypoint.service;

import com.secondaryemotion.controller.Controller;
import com.secondaryemotion.entrypoint.api.model.FullHand;
import com.secondaryemotion.views.view.FullHandView;
import org.springframework.stereotype.Service;

@Service
public class FullHandGeneratorService {

    Controller controller;

    public FullHandGeneratorService(){
        this.controller = new Controller();
    }

    public FullHand getFullHand(String handRequest){
        FullHandView fullHandView = controller.requestFullHandViews(handRequest);
        return new FullHand(fullHandView.getHandVariation(), fullHandView.getHandVariationWaits());
    }
}
