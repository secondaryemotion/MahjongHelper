package test.java.com.secondaryemotion.data.entity;

import main.java.com.secondaryemotion.data.entity.Hand;
import main.java.com.secondaryemotion.data.entity.HandVariation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandVariationTest {

    @Test
    public void HandVariation_test(){
        // arrange
        int[] man = new int[]{2, 7, 3, 9, 1};
        int[] pin = new int[]{};
        int[] sou = new int[]{2, 1, 2, 2, 9, 1};
        int[] honors = new int[]{4, 6};
        Hand hand = new Hand(man,pin,sou,honors);
        int[] tiles = hand.parseTiles();
        double[] expected = {1,1,1,1,5,3,4,8};
        HandVariation handVariation = new HandVariation(new int[][]{{1,2,3},{9}},new int[][]{},new int[][]{{1,1,2},{2},{9}}, new int[][]{{4,4,4},{6}},tiles);
        // act
        double[] actual = handVariation.getTiles();
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

}