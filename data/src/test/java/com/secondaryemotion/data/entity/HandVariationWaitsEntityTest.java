package test.java.com.secondaryemotion.data.entity;

import main.java.com.secondaryemotion.data.entity.HandVariationWaitsEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandVariationWaitsEntityTest {

    @Test
    void generateSuitWaits_test() {
        //arrange
        int[][] set = { {1,1,2},{3,5},{8}};
        int[][] expected = { {1,3},{4},{8}};
        // act
        int[][] actual = HandVariationWaitsEntity.generateSuitWaits(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }
}