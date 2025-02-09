package main.java.com.secondaryemotion;

import main.java.com.secondaryemotion.controller.Controller;


public class Main {
    public static void main(String[] args){
        String handJsonResponse = "{\"hand\":\"1678m9p58s111455z\"}";
        Controller controller = new Controller();
        controller.requestFullHandViews(handJsonResponse);
    }
}
