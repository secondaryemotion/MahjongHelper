package com.secondaryemotion.entrypoint.api.controller;

import com.secondaryemotion.entrypoint.api.model.FullHand;
import com.secondaryemotion.entrypoint.service.FullHandGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullHandGeneratorController {

    private FullHandGeneratorService fullHandGeneratorService;

    @Autowired
    public FullHandGeneratorController(FullHandGeneratorService service){
        this.fullHandGeneratorService = service;
    }

    @GetMapping("/analyseHand")
    @ResponseBody
    public FullHand getFullHand(@RequestParam String hand){
        return fullHandGeneratorService.getFullHand(hand);
    }

}
