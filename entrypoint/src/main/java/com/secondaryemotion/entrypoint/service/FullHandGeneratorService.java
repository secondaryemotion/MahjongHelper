package com.secondaryemotion.entrypoint.service;

import com.secondaryemotion.controller.Controller;
import com.secondaryemotion.data.exception.InvalidHandException;
import com.secondaryemotion.entrypoint.api.model.FullHand;
import com.secondaryemotion.views.view.FullHandView;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FullHandGeneratorService {

    Controller controller;

    public FullHandGeneratorService(){
        this.controller = new Controller();
    }

    public FullHand getFullHand(String handRequest){
        try {
            FullHandView fullHandView = controller.requestFullHandViews(handRequest);
            return new FullHand(fullHandView.getHandVariation(), fullHandView.getHandVariationWaits());
        } catch (InvalidHandException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
