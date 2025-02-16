package com.secondaryemotion;

import com.secondaryemotion.controller.Controller;


public class Main {
    public static void main(String[] args){
        String handJsonResponse = "{\"hand\":\"12334678m9p58s55z\"}";
        Controller controller = new Controller();
        controller.requestFullHandViews(handJsonResponse);
    }
}
